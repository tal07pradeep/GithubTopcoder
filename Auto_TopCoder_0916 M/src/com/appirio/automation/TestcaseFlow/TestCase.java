package com.appirio.automation.TestcaseFlow;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jxl.Sheet;
import jxl.common.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import com.appirio.automation.Topcoder.TopcoderMain;
import com.appirio.automation.DataValues.LoginData;
import com.appirio.automation.General.GeneralUtility;
import com.appirio.automation.General.ReadTestCase;
import com.appirio.automation.General.ReadObjectDescription;
import com.appirio.automation.General.sfdcPageEvents;
import com.appirio.automation.GmailEvents.GmailPageEvents;


public class TestCase
{
	
	WebDriver fDriver;
	 Map<String, ReadTestCase> recValues; 
	Map<String, ReadObjectDescription> recObject;
	Map<String, LoginData> loginData=null;
	boolean overallResult = false;
	static ReadTestCase value;
	public TestCase(WebDriver driver) 
	{
		fDriver=driver;
	}
	
	//public boolean runTests(Map<String, ReadTestCase> map) throws IOException, ParseException, NoSuchFieldException
	public boolean runTests() throws IOException, ParseException, NoSuchFieldException
	{
	
		Map<String, ReadTestCase> map =TopcoderMain.recordValues;
		//System.out.println("Size of Map: " + map.size()); 
		for (int i =1; i<=map.size(); i++)
		//	for (int i =1; i<=2; i++)
		{
			value = map.get(Integer.toString(i));
			//System.out.println("Key: " + i +" value: "+ value.getObjectName()+value.getAction());
			boolean result = executeTestStep(value.getStepNo(), value.getAction(), value.getObjectName(), value.getObjectType(), value.getAssociatedDataColumn(),value.getDataSheetName());
			if(result)
			{
				value.setResult("True");
				//overallResult=true;
			}
			else
			{
				value.setResult("False");
				//overallResult = false;
			}
			
		}
	 	//System.out.println("Came out of while");
		for (int i =1; i<=map.size(); i++)
		{
			value = map.get(Integer.toString(i));
			System.out.println(value.getResult());
			if(value.getResult().equalsIgnoreCase("true"))
			{
				overallResult=true;
				continue;
			}
			else
			{
				overallResult = false;
				break;
			}
		}
		return overallResult;
	}	
		
public boolean executeTestStep(String StepNo, String Action, String Identifier, String Type, String AssociatedData, String DataSheetName) 
{
	String[] Field=null;
	String[] identifiers=null;
	
	TopCoderActions tocoderActions= new TopCoderActions(fDriver);     
	
	// Code to handle Parent and Child elements
	//if (TopcoderMain.readObjectDescription.containsKey(Identifier))

	 identifiers= Identifier.split(",");
	 
	 System.out.println(identifiers.length);
	 Field=new String[identifiers.length];
	 if(identifiers.length==1)
	{
		if (TopcoderMain.readObjectDescription.containsKey(identifiers[0]))
		{
			Field[0]=TopcoderMain.readObjectDescription.get(identifiers[0]).getObjectDescription();
			System.out.println("Field="+Field);
		}
		else
			Field[0]=identifiers[0];
	}
	else if (identifiers.length>1)
	{
			for (int i=0; i<identifiers.length;i++)
			{
				if (TopcoderMain.readObjectDescription.containsKey(identifiers[i]))
				{
					Field[i]=TopcoderMain.readObjectDescription.get(identifiers[i]).getObjectDescription();
					System.out.println("Field="+Field[i]);
				}
			}	
			
		}
	
	
/*	TopCoderActions tocoderActions= new TopCoderActions(fDriver);
	String Field = "";
	if (TopcoderMain.readObjectDescription.containsKey(Identifier))
		 Field=TopcoderMain.readObjectDescription.get(Identifier).getObjectDescription();*/
	 //System.out.println("Field="+Field);
	 /*String[] fieldIds= Field.split(",");
	 if(fieldIds.length==1)
	 {
		 Field=fieldIds[0];
		 if (TopcoderMain.readObjectDescription.containsKey(fieldIds[0]))
			 Field=TopcoderMain.readObjectDescription.get(fieldIds[0]).getObjectDescription();
		 System.out.println("Field="+Field);
	 }
	*/
		if (Action.toLowerCase().trim().equalsIgnoreCase("click"))
		{
			String Field1="";
			//System.out.println("1111"+TopcoderMain.readObjectDescription.get(identifiers[0]).getVisibleText());
			//System.out.println("222"+TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
			if(!TopcoderMain.readObjectDescription.get(identifiers[0]).getVisibleText().isEmpty())
				Field1= Field[0]+":"+TopcoderMain.readObjectDescription.get(identifiers[0]).getVisibleText();
			else if(!TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn().isEmpty())	//////////////// 07/18
				Field1= Field[0]+":"+TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn(); ///////////////
			else
				Field1= Field[0]+":";
			
			System.out.println("String build for click"+Field1);
			return tocoderActions.clickAField1(Field1);
	}
	
	else if (Action.toLowerCase().trim().equalsIgnoreCase("select"))
	{
		if (Type.toLowerCase().trim().equalsIgnoreCase("menuoption"))
		{
			//return tocoderActions.selectMenuOption(Identifier);
			return tocoderActions.selectMenuOption(Field[0]);
		}

	}
	
	else if (Action.toLowerCase().trim().equalsIgnoreCase("verify"))
	{
		if (Type.toLowerCase().trim().equalsIgnoreCase("text"))
		{
			
			if(tocoderActions.verifyTextOfField(Field[0],AssociatedData))
				return true;
			else
				return false;
			
		}
		else
		{
			return tocoderActions.verifyElementExists(Field[0],TopcoderMain.readObjectDescription.get(identifiers[0]).getVisibleText(),"","Negative");
		}
		
	}
	
	else if (Action.toLowerCase().trim().equalsIgnoreCase("enter"))
	{
		if (Type.toLowerCase().trim().equalsIgnoreCase("textbox"))
		{
			//System.out.println(TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
			return tocoderActions.enterValueInTextBox(Field[0],AssociatedData);
		
			//return tocoderActions.enterValueInTextBox(Field,TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
		}
		else if (Type.toLowerCase().trim().equalsIgnoreCase("iframe"))
		{
			return tocoderActions.enterTextInIframe(Field[0],AssociatedData);
		}
	}
	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("LogIn"))
	{
		
		if(loginData==null)
		{
			loginData =LoginData.readLoginData(TopcoderMain.fileName);
		}
		
		return tocoderActions.login(loginData.get(AssociatedData),Field[0]);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("Login Direct"))
	{
		
		if(loginData==null)
		{
			loginData =LoginData.readLoginData(TopcoderMain.fileName);
		}
		
		return tocoderActions.loginDirect(loginData.get(AssociatedData));
	}
	else if (Action.toLowerCase().trim().equalsIgnoreCase("verifyChallengeLoading"))
	{
		String Field1= Field[0]+":"+TopcoderMain.readObjectDescription.get(identifiers[0]).getVisibleText();
		if(tocoderActions.verifyChallengeLoading(Field1))
			return true;
		else
			return false;
		
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifySearchResults"))
	{

/*			if(loginData==null)
		{
			loginData =LoginData.readLoginData(TopcoderMain.fileName);
		}*/

		tocoderActions.verifySearchResults(Field[0], Field[1]);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("sortByCol"))
	{
		return tocoderActions.sortByColumn(Field[0], AssociatedData);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("getOpenChallenge"))
	{
		return tocoderActions.getOpenChallenge();
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyRegsitration"))
	{
		return tocoderActions.verifyRegistration();
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyPageTitle"))
	{
		return tocoderActions.verifyPageTitle(AssociatedData);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("switchWindow"))
	{
		return GeneralUtility.switchToWindowUsingTitle(fDriver, AssociatedData);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("resetPassword"))
	{
		if(loginData==null)
		{
			loginData =LoginData.readLoginData(TopcoderMain.fileName);
		}
		return tocoderActions.resetPassword(loginData.get(AssociatedData));
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyHelpCenterLHSPanelItem"))
	{
		return tocoderActions.verifyHelpCenterLHSPanelItem(Field[0], TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());

	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyHelpCenterFAQList"))
	{
		return tocoderActions.verifyHelpCenterFAQList(Field[0], TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyBlogs"))
	{
		return tocoderActions.verifyBlogs(Field[0]);


	}

	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyForums"))
	{

		return tocoderActions.verifyForums(Field[0]);

	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("selectForumCategory"))
	{

		return tocoderActions.selectSearchItem(Field[0], Field[0],2,TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());

	}

	else if(Action.toLowerCase().trim().equalsIgnoreCase("selectForumsInCategory"))
	{

		return tocoderActions.selectSearchItem(Field[0], Field[0],2,TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());


	}

	else if(Action.toLowerCase().trim().equalsIgnoreCase("selectAForum"))
	{

		return tocoderActions.selectSearchItem(Field[0], Field[0],2,TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());


	}	

	else if(Action.toLowerCase().trim().equalsIgnoreCase("SelectThread"))
	{
		return tocoderActions.SelectThread(Field[0], Field[0],2,TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());

	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("postreply"))
	{
		return tocoderActions.postReply();
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("ExecuteAPI"))
	{
		return tocoderActions.ExecuteAPI(TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("Compare"))
	{
		return tocoderActions.compareTextOfField(Field[0]);
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("OpenURL"))
	{
		return new sfdcPageEvents(fDriver).openUrl(TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyPaging"))
	{
		return tocoderActions.verifyPaging();
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("chkloading"))
	{
		return tocoderActions.chkloading();
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("LoginGmail"))
	{
		if(loginData==null)
		{
			loginData =LoginData.readLoginData(TopcoderMain.fileName);
		}
		 try {
			new GmailPageEvents(fDriver).login(loginData.get(AssociatedData).getUserName(),loginData.get(AssociatedData).getPassword());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return true;
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("resetPassword"))
	{
		//return tocoderActions.getCodeFromEmail();
		if(loginData==null)
		{
			loginData =LoginData.readLoginData(TopcoderMain.fileName);
		}
		//new GmailPageEvents(fDriver).searchEmail(loginData.get(AssociatedData).getUserName(),loginData.get(AssociatedData).getPassword(),"TopCoder Account Password Reset","service@topcoder.com","code");
		//new GmailPageEvents(fDriver).resetPasswordgetRestTokenInMail(loginData.get(AssociatedData).getUserName(),loginData.get(AssociatedData).getPassword());
		//new GmailPageEvents(fDriver).ReadingEmail();
		return tocoderActions.resetPassword(loginData.get(AssociatedData));
		
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("selectAValueInDirectDropdown"))
	{
		return tocoderActions.selectAValueInDirectDropdown(AssociatedData);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("enterDate"))
	{
		return tocoderActions.enterDate(Field[0],AssociatedData);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("multiSelect"))
	{
		String[] platformSet= AssociatedData.split(",");
		return tocoderActions.multiSelectSelectFew(Field[0], platformSet);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("selectCheckboxes"))
	{
		String[] deliverablesSet= AssociatedData.split(",");
		return tocoderActions.selectCheckboxes(Field[0], deliverablesSet);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifySorting"))
	{
		return tocoderActions.verifySorting(Field[0], AssociatedData);
	}
	else if (Action.toLowerCase().trim().equalsIgnoreCase("verifyElementExists"))       
	{
		if (Type.toLowerCase().trim().equalsIgnoreCase("negative"))
		{
			return tocoderActions.verifyElementExists(Field[0],TopcoderMain.readObjectDescription.get(identifiers[0]).getVisibleText(),"","Negative");

			
		}
		else
		{
			return tocoderActions.verifyElementExists(Field[0],TopcoderMain.readObjectDescription.get(identifiers[0]).getVisibleText(),"","Positive");


		}
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("VerifyMemberProfile"))
	{
		return tocoderActions.VerifyMemberProfile(Field[0]);
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("selectAMember"))
	{
		
		return tocoderActions.selectAMember(Field[0], TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("VerifyNoOfBadgesDisplaying"))
	{
		
		return tocoderActions.VerifyNoOfBadgesDisplaying(Field[0]);
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("VerifyRating"))
	{
		
		return tocoderActions.VerifyRating(TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
	}	
	else if(Action.toLowerCase().trim().equalsIgnoreCase("VerifyDetailedRating"))
	{
		
		return tocoderActions.VerifyDetailedRating(TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("VerifyMemberDetail"))
	{
		
		return tocoderActions.VerifyMemberDetail(TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyUserDetails"))
	{
		if(loginData==null)
		{
			loginData =LoginData.readLoginData(TopcoderMain.fileName);
		}
		return tocoderActions.verifyUserDetails(loginData.get(AssociatedData));
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("selectChallenge"))
	{
		return tocoderActions.selectChallenge(AssociatedData);
		//return tocoderActions.selectChallenge(TopcoderMain.recordValues.get(StepNo).getAssociatedDataColumn());
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("verifyChallengeButtons"))
	{
		
		return tocoderActions.verifyChallengeButtons(Field[0],AssociatedData);
	}
	else if(Action.toLowerCase().trim().equalsIgnoreCase("completeRegistrationFromMail"))
	{
		if(loginData==null)
		{
			loginData =LoginData.readLoginData(TopcoderMain.fileName);
		}
		return tocoderActions.completeRegistrationFromMail(loginData.get(AssociatedData));
		
	}
	return false;
		
	
	
	
}




}
