package com.appirio.automation.General;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import jxl.Sheet;

public class ReadTestCase
{
	private String stepNo;
	private String action;	
	private String objectName;
	private String objectType;
	private String associatedDataColumn;
	private String dataSheetName;
	private int row;
	private String result = "";
	private String reason="";
/*	static void InstantiateRecordValuesObjects() {
	
	}*/
	
	public static Map<String, ReadTestCase> readRecordValues(Sheet sheet_object) {
	//public static Map<String, ReadTestCase> readRecordValues(String sheetName) {
		int row = 1;
		//int i=sheet_object.getColumns();
		//int j=sheet_object.getRows();
		Map<String,ReadTestCase> recordValueList=new HashMap<String, ReadTestCase>();
		do {
			try {
				
				ReadTestCase temp_objectValues = new ReadTestCase();			
				//Read from XLS and set to the object
				if(sheet_object!=null)
				//if(!sheetName.trim().equalsIgnoreCase(""))
				{
				String stepNumber=sheet_object.getCell(0, row).getContents();
				if (!stepNumber.equalsIgnoreCase(""))
				{
				//	temp_objectValues.fieldName = fName;
					
					temp_objectValues.stepNo = stepNumber; 
					temp_objectValues.row=row;
					temp_objectValues.action = sheet_object.getCell(1, row).getContents();
					temp_objectValues.objectName = sheet_object.getCell(2, row).getContents();
					temp_objectValues.objectType = sheet_object.getCell(3, row).getContents();
					if(sheet_object.getCell(4, row).getContents() != null)
						temp_objectValues.associatedDataColumn = sheet_object.getCell(4, row).getContents();
					else
						temp_objectValues.associatedDataColumn = "";
					if(sheet_object.getCell(5, row).getContents()!=null)
						temp_objectValues.dataSheetName = sheet_object.getCell(5, row).getContents();
					else
						temp_objectValues.dataSheetName = "";
					
				/*	if (Global_Settings.AllRecordsToCreate.get(CurrentRecordIndex).IsRecordVFPage)
						temp_objectValues.VerificationIDForVFPage = sheet_object.getCell(col, 13).getContents();
								
					Global_Settings.AllRecordsToCreate.get(CurrentRecordIndex).RecordValues.add(temp_objectValues);
					*/			
					recordValueList.put(stepNumber, temp_objectValues);
				}
				row++;
			}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}while(true);
		return recordValueList;
	}
	
	
	
/*	public String toString() {
		return ("Field Name:\t" + fieldName + "\n" +
				"FieldType:\t" + fieldType + "\n" +
				"FieldID:\t" + fieldId + "\n" +
				"FieldValue:\t" + fieldValue + "\n" +
				"IsFieldToBeTested:\t" + isFieldToBeTested + "\n" +
				"FieldPurpose:\t" + fieldPurpose + "\n" +
				"FieldDefaults:\t" + fieldDefaultValue + "\n"
				);
	}*/
	
	
	
	public String getStepNo() {
		return stepNo;
	}
	public void setStepNo(String stepNo) {
		this.stepNo = stepNo;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getObjectName()
	{
		return objectName;
	}
	public void setObjectName(String objectName)
	{
		this.objectName=objectName;
	}
	public String getObjectType()
	{
		return objectType;
	}
	public void setObjectType(String objectType)
	{
		this.objectType=objectType;
	}
	public String getDataSheetName()
	{
		return dataSheetName;
	}
	public void setDataSheetName(String dataSheetName)
	{
		this.dataSheetName=dataSheetName;
	}
	public String getAssociatedDataColumn()
	{
		return associatedDataColumn;
	}
	public void setAssociatedDataColumn(String associatedDataColumn)
	{
		this.associatedDataColumn=associatedDataColumn;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result=result;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason=reason;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

	
	
}

