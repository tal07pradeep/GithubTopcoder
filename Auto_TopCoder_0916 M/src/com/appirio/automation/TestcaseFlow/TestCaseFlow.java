package com.appirio.automation.TestcaseFlow;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

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



public class TestCaseFlow 
{
	
	
	private String testNo;
	private String command=null;
	private List<String> argumentList;
	private boolean returnValues;
	private String result = "";
	private String failureReason="";
	private int row=0;
	private static String sheet="Trial";
	
	public static List<TestCaseFlow> readData(String fileName) 
	{
		List<TestCaseFlow> RecordList = new ArrayList<TestCaseFlow>();
		Workbook book= null;
		try {
			book = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		Sheet sheet_summary = book.getSheet(sheet);
		int row = 1;
		List<String> argumentList = new ArrayList<String>();
		do {
			try {
				//Read from XLS and set to the object only when IsRecordToBeExecuted is true
				TestCaseFlow newRecord = new TestCaseFlow(); 
				newRecord.setTestNo(sheet_summary.getCell(0, row).getContents());
				newRecord.setCommand(sheet_summary.getCell(2, row).getContents());
				newRecord.setRow(row);
				argumentList = new ArrayList<String>();
				int argCol=3;
				do {
					try 
					{	
						

						if(!sheet_summary.getCell(argCol, row).getContents().equals(""))
						{
							argumentList.add(sheet_summary.getCell(argCol, row).getContents());
							argCol++;
						}
						else if(sheet_summary.getCell(argCol, row).getContents().equals(""))
						{
							break;
						}
						
											
					}
					catch(ArrayIndexOutOfBoundsException e) {
						break;
					}
				}while(true);
				newRecord.setArgumentList(argumentList);
				RecordList.add(newRecord);
				row++;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}while(true);
		return RecordList;
	}
	
	public void PrintValues(List<TestCaseFlow> RecordList)
	{
		for (TestCaseFlow testCaseFlow : RecordList) 
		{
			System.out.println(testCaseFlow.getCommand());
			for (String arglist  : testCaseFlow.getArgumentList()) 
			{
				System.out.println(arglist);
				
			}
			System.out.println('\n');
		}
	}
	public static String[] argList(String command,String fileName)
	{
		String[] argumentList= null;
		Workbook book= null;
		try {
			book = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		Sheet sheet_summary = book.getSheet(sheet);
		int row = 1;
		int argCol=2;
		int argno=0;
		
		do {
			try 
			{
				argumentList[argno]=sheet_summary.getCell(argCol, row).getContents();
				argCol++;
				argno++;
			
			}
			catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}while(true);
		return argumentList;
	}
	public static void writeData(List<TestCaseFlow> recordList, String outFile, String fileName)
	{
		WritableWorkbook book= null;
		Workbook wb;
		try {
			wb = Workbook.getWorkbook(new File(fileName));
			book = Workbook.createWorkbook(new File("output\\"+outFile),wb);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		WritableSheet testcase=book.getSheet(sheet);
		
		for (TestCaseFlow rec:recordList)
		{
			Label label;
			if (rec.getReturnValues())
				label=new Label(1, rec.getRow(), "Passed",  new ExcelSettings().forPass);
			else
				label=new Label(1, rec.getRow(), "Failed\n Reason:"+rec.getFailureReason(),  new ExcelSettings().forFail);
			try 
			{
					testcase.addCell(label);
			}
			catch (WriteException e) 
			{
				e.printStackTrace();
			}
		}
		try {
			book.write();
			book.close();
		} catch (WriteException | IOException e) {
			e.printStackTrace();
		}
	}
	public String getTestNo() {
		return testNo;
	}

	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public List<String> getArgumentList() {
		return argumentList;
	}

	public void setArgumentList(List<String> argumentList) {
		this.argumentList = argumentList;
	}

	public boolean getReturnValues() {
		return returnValues;
	}

	public void setReturnValues(boolean returnValues) {
		this.returnValues = returnValues;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
}
