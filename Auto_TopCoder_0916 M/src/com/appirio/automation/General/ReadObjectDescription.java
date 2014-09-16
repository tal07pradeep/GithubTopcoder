package com.appirio.automation.General;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadObjectDescription {
	private String objectName;	
	private String objectDescription;
	private String visibleText;

	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getObjectDescription() {
		return objectDescription;
	}
	public void setObjectDescription(String objectDescription) {
		this.objectDescription = objectDescription;
	}
	public String getVisibleText() {
		return visibleText;
	}
	public void setVisibleText(String visibleText) {
		this.visibleText = visibleText;
	}



	
	public static Map<String, ReadObjectDescription> readData(String fileName) {
		int row=1;
		Workbook book= null;
		try {
			book = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		Sheet sheetObject = book.getSheet("Local Object Repository");
		//System.out.println(sheetObject.getRows());
		Map<String, ReadObjectDescription> eventValueList=new HashMap<String, ReadObjectDescription>();

		do {
			try {
				
				ReadObjectDescription temp_objectValues = new ReadObjectDescription();			
				//Read from XLS and set to the object
				String objectName = sheetObject.getCell(0, row).getContents();
				if (!objectName.equalsIgnoreCase(""))
				{
				temp_objectValues.objectName=objectName;
				temp_objectValues.objectDescription=sheetObject.getCell(1, row).getContents();
				temp_objectValues.visibleText=sheetObject.getCell(2, row).getContents();
				

					
				eventValueList.put(objectName, temp_objectValues);
				//System.out.println(objectName+temp_objectValues.objectDescription);
				}
				row++;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}while(true);
		return eventValueList;
	}
	
}


