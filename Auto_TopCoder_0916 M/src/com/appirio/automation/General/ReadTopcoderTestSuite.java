package com.appirio.automation.General;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.appirio.automation.General.ExcelSettings;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ReadTopcoderTestSuite 
{
	private String testNo;
	private String testName=null;	
	private String sheetName = null;
	private boolean toBeExecuted;
	private String dataSheet = null;
	private int noOfIterations;
	private String result = null;
	private String overallResults="";
	private boolean overallResult=false;
	private WritableCellFormat resultType = null;
	private boolean isResultWritten = false;
	
	//private String testCaseIDInCMC=null;
	private int row;
	private Map<String,ReadTestCase> recordValues;
	
	public WritableCellFormat getResultType()
	{
		return resultType;
	}
	public void setResultType(WritableCellFormat resultType)
	{
		this.resultType=resultType;
	}
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getSheetName()
	{
		return sheetName;
	}
	public void setSheetName(String sheetName)
	{
		this.sheetName=sheetName;
	}
	public boolean getToBeExecuted()
	{
		return toBeExecuted;
	}
	public void setToBeExecuted(boolean toBeExecuted)
	{
		this.toBeExecuted=toBeExecuted;
	}
	
	public String getDataSheet()
	{
		return dataSheet;
	}
	public void setDataSheetName(String dataSheet)
	{
		this.dataSheet=dataSheet;
	}
	public int getNoOfIterations()
	{
		return noOfIterations;
	}
	public void setNoOfIterations(int noOfIterations)
	{
		this.noOfIterations=noOfIterations;
	}
	
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result=result;
	}
/*	public WritableCellFormat getResultType()
	{
		return resultType;
	}
	public void setResultType(WritableCellFormat resultType)
	{
		this.resultType=resultType;
	}*/
	public boolean getIsResultWritten()
	{
		return isResultWritten;
	}
	public void setIsResultWritten(boolean isResultWritten)
	{
		this.isResultWritten=isResultWritten;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public Map<String,ReadTestCase> getRecordValues()
	{
		return recordValues;
	}
	
	public void setRecordValues(Map<String, ReadTestCase> recordValues)
	{
		this.recordValues=recordValues;
	}
	public String getOverallResults() {
		return overallResults;
	}
	public void setOverallResults(String overallResults) {
		this.overallResults = overallResults;
	}
	public boolean isOverallResult() {
		return overallResult;
	}
	public void setOverallResult(boolean overallResult) {
		this.overallResult = overallResult;
	}
	
	
	public static List<ReadTopcoderTestSuite> readData(String fileName) {
		List<ReadTopcoderTestSuite> RecordList = new ArrayList<ReadTopcoderTestSuite>();
		Workbook book= null;
		try {
			book = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		Sheet sheet_summary = book.getSheet("Test Suite");
		int row = 8;
		do {
			try {
				String tcNo=sheet_summary.getCell(0, row).getContents();
			
				if (!tcNo.equalsIgnoreCase(""))
				{
				//Read from XLS and set to the object only when IsRecordToBeExecuted is true
				ReadTopcoderTestSuite newRecord = new ReadTopcoderTestSuite(); 
				newRecord.sheetName = sheet_summary.getCell(2, row).getContents();
				//System.out.println(newRecord.sheetName);
				newRecord.setRow(row);
				Sheet sheet_object=book.getSheet(newRecord.sheetName);
				
				if (sheet_summary.getCell(3, row).getContents().equalsIgnoreCase("N"))
				{
					row++;
					continue;
				}
				if ((sheet_summary.getCell(3, row).getContents().equalsIgnoreCase("Y")))
				{
					newRecord.toBeExecuted=true;
					
					newRecord.testNo=sheet_summary.getCell(0, row).getContents();
					newRecord.testName=sheet_summary.getCell(1, row).getContents();
					newRecord.dataSheet=sheet_summary.getCell(4, row).getContents();
					if (!sheet_summary.getCell(5, row).getContents().equalsIgnoreCase(""))
					newRecord.noOfIterations=Integer.parseInt(sheet_summary.getCell(5, row).getContents());
					//newRecord.testName=sheet_summary.getCell(1, row).getContents();
					
					newRecord.recordValues=ReadTestCase.readRecordValues(sheet_object);
				}

				RecordList.add(newRecord);
				}
				row++;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(RecordList.size());
				break;
			}
		}while(true);
		return RecordList;
	}
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append("RecordSheetName:\t" + sheetName + "\n"
				);
		for (String key:recordValues.keySet())
		{
			result.append("\n"+recordValues.get(key));
		}
		return result.toString();
	}
	
	public static void print(List<ReadTopcoderTestSuite> rec)
	{
		for (ReadTopcoderTestSuite currentRec:rec)
		{
			System.out.println("*******************************Record*******************************");
			System.out.println(currentRec);
		}	
	}	
	public static Map<String,ReadTestCase> getRecordsValues1(List<ReadTopcoderTestSuite> rec, String sheetName)
	{
		ReadTopcoderTestSuite recValues = null;
		for (ReadTopcoderTestSuite currentRec:rec)
		{			
			if (currentRec.getSheetName().equalsIgnoreCase(sheetName))
			{
				recValues=currentRec;
				break;
			}
		}
		return recValues.getRecordValues();
	}	
	public static ReadTopcoderTestSuite getRecordToCreateByTestCase(List<ReadTopcoderTestSuite> rec, String testCaseNo)
	{
		//System.out.println("size of rec = "+rec.size());
		ReadTopcoderTestSuite recValues = null;
		for (ReadTopcoderTestSuite currentRec:rec)
		{			
			if (currentRec.getTestNo().equalsIgnoreCase(testCaseNo))
			{
				recValues=currentRec;
				break;
			}
		}
		return recValues;
	}
	
	public static ReadTopcoderTestSuite getRecordToCreateByTestName(List<ReadTopcoderTestSuite> rec, String testName)
	{
		ReadTopcoderTestSuite recValues = null;
		for (ReadTopcoderTestSuite currentRec:rec)
		{			
			if (currentRec.getTestName().equalsIgnoreCase(testName))
			{
				recValues=currentRec;
				break;
			}
		}
		return recValues;
	}
	public static ReadTopcoderTestSuite getRecordToCreate(List<ReadTopcoderTestSuite> rec, String sheetName)
	{
		ReadTopcoderTestSuite recValues = null;
		for (ReadTopcoderTestSuite currentRec:rec)
		{			
			if (currentRec.getSheetName().equalsIgnoreCase(sheetName))
			{
				recValues=currentRec;
				break;
			}
		}
		return recValues;
	}
	public static void writeData(List<ReadTopcoderTestSuite> rec, String outFile, String fileName) throws RowsExceededException
	{
		File dir = new File("output");
		dir.mkdir();
		WritableWorkbook book= null;
		Workbook wb;
		try {
			wb = Workbook.getWorkbook(new File(fileName));
			book = Workbook.createWorkbook(new File("output\\"+outFile),wb);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		for (ReadTopcoderTestSuite currentRec:rec)
		{
			if (currentRec.toBeExecuted)
			{
				//System.out.println(currentRec.getTestName());
				WritableSheet summary=book.getSheet("Test Suite");
				try 
				{
					if (currentRec.isOverallResult())
					{
						Label label=new Label(6, currentRec.getRow(), "Passed",  new ExcelSettings().forPass);
						summary.addCell(label);
					} 
					else
					{
						Label label=new Label(6, currentRec.getRow(), "Failed",  new ExcelSettings().forFail);
						summary.addCell(label);
					}
					String overResults=currentRec.getOverallResults();
					if (overResults!="")
					{
						overResults=overResults.trim();
						Label label=new Label(7,currentRec.getRow(),overResults,new ExcelSettings().forDefault);
						summary.addCell(label);
					}
				}catch (WriteException e) {
						e.printStackTrace();
				}
				WritableSheet sheet=book.getSheet(currentRec.getSheetName());
				try {
					 Map<String, ReadTestCase> recValues=currentRec.getRecordValues();
					 
					 for (String key:recValues.keySet())
					 {
						 ReadTestCase record=recValues.get(key);
					//	 System.out.println("Write key="+key);
					
							 if (record.getResult().equalsIgnoreCase("True"))
							 {
								 Label label=new Label(5,record.getRow() , "Passed",  new ExcelSettings().forPass);
								 sheet.addCell(label);
							 }
							 else if (record.getResult().equalsIgnoreCase("False"))
							 {
								 Label label=new Label(5,record.getRow() , "Failed",  new ExcelSettings().forFail);
								 sheet.addCell(label);
							 }
							 else
							 {
								 Label label=new Label(5,record.getRow() , "Result NA",  new ExcelSettings().forDefault);
								 sheet.addCell(label);
							 }
						
							 if(record.getReason()!="")
							 {

								 Label label=new Label(6,record.getRow() , record.getReason(),  new ExcelSettings().forDefault);
								 sheet.addCell(label);
							 }
/*						 if (record.getIsFieldToBeTested())
						 {
							 
							 String[] result= record.getResultSet();
							 // if(!result.equals(null))
							 if(result.length>0)
							 {
							 if (result[1].equalsIgnoreCase("True"))
							 {
								 Label label=new Label(record.getCol(), RecordValuesToCreate.lastRow, "Passed",  new ExcelSettings().forPass);
								 sheet.addCell(label);
							 }
							 else if (result[1].equalsIgnoreCase("False"))
							 {
								 Label label=new Label(record.getCol(), RecordValuesToCreate.lastRow, "Failed",  new ExcelSettings().forFail);
								 sheet.addCell(label);
							 }
							 else
							 {
								 Label label=new Label(record.getCol(), RecordValuesToCreate.lastRow, "Result NA",  new ExcelSettings().forDefault);
								 sheet.addCell(label);
							 }
						 }
					 }*/
					 }
					 
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
			}
			
		}
		try {
			book.write();
			book.close();
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	public static void writeTCResults(List<ReadTopcoderTestSuite> recList, String outFile, String resFile) 
	{
		Workbook book = null;
		try {
			//Initializing file from which results are to be read
			book = Workbook.getWorkbook(new File("output\\"+outFile));			
			Sheet sheet_summary = book.getSheet("Summary");
			int  rowcount = sheet_summary.getRows();
			int count = 10;
			// Initializing TR file to write test results
			OutputStream os = (OutputStream)new FileOutputStream(new File("output\\"+resFile));
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			String browser=sheet_summary.getCell(1,2).getContents();
			String user=sheet_summary.getCell(7,2).getContents();
			String sprint=sheet_summary.getCell(7,3).getContents();
			String type=sheet_summary.getCell(7,4).getContents();
			String log=sheet_summary.getCell(7,5).getContents();
			
			///writing data in Result CSV file
		    bw.write("Test Case,Status,Type,Executed In Sprint,Executed By,Log,Browser");
	    	bw.newLine();
			
			/*while(count < rowcount)
			{
				String tcID= sheet_summary.getCell(9, count).getContents();
				String tcStatus = sheet_summary.getCell(6, count).getContents();
				//if (sheet_summary.getCell(6, count).getContents())
				String tcIDs[]=tcID.split(",");
				for (String temp:tcIDs)
				{
					bw.write(temp+","+tcStatus+","+type+","+sprint+","+user+","+log+","+browser);
					bw.newLine();
				}
		    	count++;
			}*/
	    	
	    	
/*	    	for (RecordToCreate rec:recList)
	    	{
	    		if (rec.getToBeExecuted())
	    		{
	    			String tcID=rec.getTestCaseIDInCMC();
	    			String tcStatus= (rec.isOverallResult()) ? "Passed": "Failed";
	    			String tcIDs[]=tcID.split(",");
					for (String temp:tcIDs)
					{
						bw.write(temp+","+tcStatus+","+type+","+sprint+","+user+","+log+","+browser);
						bw.newLine();
					}
	    		}
					
	    	}
			bw.flush();
		    bw.close();*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			book.close();
		}
	}
}
