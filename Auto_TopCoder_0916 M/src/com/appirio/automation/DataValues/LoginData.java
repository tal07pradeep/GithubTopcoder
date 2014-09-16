package com.appirio.automation.DataValues;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginData
{
	private String loginUserName;
	private String loginPassword;
	private String loginNewPassword;
	private String loginEmail;
	private String emailPassword;
	private String firstName;
	private String lastName;
	private String country;
		
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public String getUserName() {
		return loginUserName;
	}
	public void setUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}
	public String getPassword() {
		return loginPassword;
	}
	public void setPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getNewPassword() {
		return loginNewPassword;
	}
	public void setNewPassword(String loginNewPassword) {
		this.loginNewPassword = loginNewPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	private String loginDataId;
	
	public String getLoginDataId() {
		return loginDataId;
	}
	public void setLoginDataId(String loginDataId) {
		this.loginDataId = loginDataId;
	}
	public static Map<String, LoginData> readLoginData(String fileName) {
		int row=1;
		Workbook book= null;
		try {
			book = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		Sheet sheetContacts = book.getSheet("Data_LoginCredentials");
		Map<String,LoginData> loginDataList=new HashMap<String, LoginData>();
		do {
			try {
				
				LoginData temp_objectValues = new LoginData();			
				//Read from XLS and set to the object
				String loginID=sheetContacts.getCell(0, row).getContents();
				temp_objectValues.loginDataId=loginID;
				temp_objectValues.loginUserName=sheetContacts.getCell(1, row).getContents();
				temp_objectValues.loginPassword=sheetContacts.getCell(2, row).getContents();
				temp_objectValues.loginNewPassword=sheetContacts.getCell(3, row).getContents();
				temp_objectValues.loginEmail=sheetContacts.getCell(4, row).getContents();
				temp_objectValues.emailPassword=sheetContacts.getCell(5, row).getContents();
				temp_objectValues.firstName=sheetContacts.getCell(7, row).getContents();
				temp_objectValues.lastName=sheetContacts.getCell(8, row).getContents();
				temp_objectValues.country=sheetContacts.getCell(6, row).getContents();
				loginDataList.put(loginID, temp_objectValues);
				row++;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				break;
			}
		}while(true);
		return loginDataList;
	}
}
