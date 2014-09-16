package com.appirio.automation.TestcaseFlow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import jxl.common.Assert;
import java.lang.Object;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import com.appirio.automation.DataValues.LoginData;
import com.appirio.automation.General.GeneralUtility;
import com.appirio.automation.General.sfdcPageEvents;
import com.appirio.automation.GmailEvents.GmailPageEvents;
import com.appirio.automation.TestcaseFlow.TestCase;
import com.appirio.automation.Topcoder.TopcoderMain;
import com.thoughtworks.selenium.Wait;
public class TopCoderActions 
{
	static WebDriver fDriver;
	static String currentUserHandle="";
	static String competingToday="";
    static String activeChallenges="";
	static String memberCount="";
	static String prizePurse= "";
	public TopCoderActions(WebDriver driver) 
	{
		fDriver=driver;
		
	}
	private List<WebElement> findElements(String FieldDecs)
	{
		try
		{
			List<WebElement> varEle = null;
	/*			if (Type.toLowerCase().trim().equalsIgnoreCase("textbox"))
				{*/
					//String varObjDesc=null;
					//if (TopcoderMain.readObjectDescription.containsKey(FieldDecs))
						//varObjDesc=TopcoderMain.readObjectDescription.get(FieldDecs).getObjectDescription();
				//	String[] varObjs=FieldDecs.split(";;");
					//System.out.println(varObjs.length);
					//for (int i=0; i<varObjs.length;i++)
					//{
						String[] varObjsDetail=FieldDecs.split("==");
						
						System.out.println(varObjsDetail[1].trim());
						if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("id"))
						{
							varEle = fDriver.findElements(By.id(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("cssSelector"))
						{
							varEle = fDriver.findElements(By.cssSelector(varObjsDetail[1].trim()));
						//System.out.println(varWElement.size());
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("linkText"))
						{
							varEle = fDriver.findElements(By.linkText(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("xpath"))
						{
							varEle = fDriver.findElements(By.xpath(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("className"))
						{
							varEle = fDriver.findElements(By.className(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("tagname"))
						{
							varEle = fDriver.findElements(By.tagName(varObjsDetail[1].trim()));
						
						}
						//varWElement.sendKeys(TopcoderMain.userName);
							
					//}
					
	/*				
					w=fDriver.findElements(By.xpath(e));
					if (TopcoderMain.readObjectDescription.get(Field).getObjectDescription().equalsIgnoreCase(anotherString))
				if String e=;
				w=fDriver.findElements(By.cssSelector("#wrapper > div > div.article > div.container > p:nth-child(2) > span"));*/
				//System.out.println(w.size());
				//System.out.println(w.get(0).getText());
					//System.out.println(varWElement.size());
					return varEle;
		}
		catch(NoSuchElementException err)
		{
			System.out.println(err.getMessage());
			System.out.println("Element not found");
			return null;
		}
			}
	public static WebElement findElement(String FieldDecs)
	{
		try
		{
			WebElement varEle = null;
	/*			if (Type.toLowerCase().trim().equalsIgnoreCase("textbox"))
				{*/
					String varObjDesc=null;
					//if (TopcoderMain.readObjectDescription.containsKey(FieldDecs))
						//varObjDesc=TopcoderMain.readObjectDescription.get(FieldDecs).getObjectDescription();
				//	String[] varObjs=FieldDecs.split(";;");
					//System.out.println(varObjs.length);
					//for (int i=0; i<varObjs.length;i++)
					//{
						String[] varObjsDetail=FieldDecs.split("==");
						
						//System.out.println(varObjsDetail[1].trim());
						if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("id"))
						{
							varEle = fDriver.findElement(By.id(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("cssSelector"))
						{
							varEle = fDriver.findElement(By.cssSelector(varObjsDetail[1].trim()));
						//System.out.println(varWElement.size());
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("linkText"))
						{
							varEle = fDriver.findElement(By.linkText(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("xpath"))
						{
							varEle = fDriver.findElement(By.xpath(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("partialLinkText"))
						{
							varEle = fDriver.findElement(By.partialLinkText(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("className"))
						{
							varEle = fDriver.findElement(By.className(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("name"))
						{
							varEle = fDriver.findElement(By.name(varObjsDetail[1].trim()));
						
						}
						else if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("tagname"))
						{
							varEle = fDriver.findElement(By.tagName(varObjsDetail[1].trim()));
						
						}
						//varWElement.sendKeys(TopcoderMain.userName);
							
					//}
					
	/*				
					w=fDriver.findElements(By.xpath(e));
					if (TopcoderMain.readObjectDescription.get(Field).getObjectDescription().equalsIgnoreCase(anotherString))
				if String e=;
				w=fDriver.findElements(By.cssSelector("#wrapper > div > div.article > div.container > p:nth-child(2) > span"));*/
				//System.out.println(w.size());
				//System.out.println(w.get(0).getText());
					//System.out.println(varWElement.size());
					return varEle;
		}
		catch(NoSuchElementException err)
		{
			System.out.println(err.getMessage());
			System.out.println("Element not found");
			return null;
		}
			}
			
	protected boolean enterValueInTextBox(String Field,String Value) 
	{
		 WebElement varWElement=findElement(Field);
		 if(varWElement.isDisplayed() && varWElement.getAttribute("readonly")==null)
		 {
			 varWElement.clear();
			 varWElement.sendKeys(Value);
			 return true;
		 }
		 else  if(varWElement.getAttribute("readonly")!=null)
		 {
			 System.out.println("readonly="+varWElement.getAttribute("readonly"));
		 if(varWElement.getAttribute("readonly").equalsIgnoreCase("readonly") || varWElement.getAttribute("readonly").equalsIgnoreCase("") || varWElement.getAttribute("readonly").equalsIgnoreCase("true"))
		 {
			 TestCase.value.setReason(TestCase.value.getReason()+" Cannot enter text as the control is readonly");
			return true;
		 }
		 }
		 else
		 {
			 TestCase.value.setReason(TestCase.value.getReason()+" Cannot enter text as the control is not editable.");
			 return true;
		 }
         // varWElement.getAttribute("text")
          return false;
           
	/*	String varObjDesc=null;
		if (TopcoderMain.readObjectDescription.containsKey(Field))
			varObjDesc=TopcoderMain.readObjectDescription.get(Field).getObjectDescription();
		String[] varObjs=varObjDesc.split(";;");
		System.out.println(varObjs.length);
		for (int i=0; i<varObjs.length;i++)
		{
			String[] varObjsDetail=varObjs[i].split("==");
			
			
			if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("id"))
				{
				varWElement=fDriver.findElement(By.id(varObjsDetail[1].trim()));
				}
			varWElement.sendKeys(TopcoderMain.userName);
				
		}*/
	}
	protected boolean enterTextInIframe(String Field,String Value) 
	{
		GeneralUtility.sleep(5000);
		WebElement iframe = TopCoderActions.findElement(Field).findElement(By.tagName("iframe"));
		String currentHandle=fDriver.getWindowHandle();
		fDriver.switchTo().frame(iframe);
		WebElement description = fDriver.findElement(By.cssSelector("body"));
		//((IJavaScriptExecutor)fDriver).executeScript("tinyMCE.activeEditor.selection.setContent('changed! ')");
		((JavascriptExecutor) fDriver).executeScript("arguments[0].innerHTML = '"+Value+"'", description);
		//fDriver.switchTo().frame(iframe).findElement(By.cssSelector("body")).sendKeys("test");
		//fDriver.findElement(By.tagName("body")).sendKeys("test");
		//boolean enterText= tocoderActions.enterValueInTextBox("cssSelector==body > p",AssociatedData);
		fDriver.switchTo().window(currentHandle);
		return true;
		
	}
	protected boolean compareTextOfField(String Field) 
	{
		try{
				WebElement textField=findElement(Field);
				
				if(textField!=null)
				{
					System.out.println(textField.getText());
					String fieldText="";
					String varAPIvalue="";
					//Assert.verify(textField.getText()!=null,"Correct value is displayed.");
					//if(text=="")
					//{
						if(textField.getText()!=null)
						{
							fieldText=textField.getText();
							fieldText=GeneralUtility.removeCharAt(textField.getText(), textField.getText().lastIndexOf(","));
							fieldText=GeneralUtility.removeCharAt(fieldText, fieldText.lastIndexOf("$"));
							if(fieldText.equalsIgnoreCase(memberCount.trim()))
							{
								TestCase.value.setReason("Text in field-"+textField.getText()+", and API retured value "+memberCount+". Correct value is displayed.");
								varAPIvalue=memberCount;
								return true;
							}
							else if(fieldText.equalsIgnoreCase(prizePurse.trim()))
							{
								TestCase.value.setReason("Text in field-"+textField.getText()+", and API retured value "+prizePurse+". Correct value is displayed.");
								varAPIvalue=prizePurse;
								return true;
							}
							else if(fieldText.equalsIgnoreCase(competingToday.trim()))
							{
								TestCase.value.setReason("Text in field-"+textField.getText()+", and API retured value "+competingToday+". Correct value is displayed.");
								varAPIvalue=competingToday;
								return true;
							}
							else if(fieldText.equalsIgnoreCase(activeChallenges.trim()))
							{
								TestCase.value.setReason("Text in field-"+textField.getText()+", and API retured value "+activeChallenges+". Correct value is displayed.");
								varAPIvalue=activeChallenges;
								return true;
							}
							else
								TestCase.value.setReason("Text in field-"+textField.getText()+", and API retured value "+varAPIvalue+". Incorrect value is displayed.");
								//TestCase.value.setReason("Text in field-"+textField.getText()+". Value is not correct.");
								return false;                
						}
						else
						{
							TestCase.value.setReason("Element not found.");
							return false;
						}
				}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			TestCase.value.setReason("Element not found");
			return false;
		}
		return false;
	}	

	
	protected boolean verifyTextOfField(String Field,String verifyText) 
	{
		try{
			GeneralUtility.sleep(5000);
				WebElement textField=findElement(Field);
				
				if(textField!=null)
				{
					System.out.println(textField.getText());
					//Assert.verify(textField.getText()!=null,"Correct value is displayed.");
					//if(text=="")
					//{
						if(textField.getText()!=null && textField.getText().contains(verifyText))
						{
							TestCase.value.setReason(textField.getText()+". Correct value is displayed.");
							return true;
						}
						else
						{
							TestCase.value.setReason("Text in field-"+textField.getText()+". No value is displayed.");
							return false;
						}
				}
				/*	else
					{
						if(textField.getText()!=null && textField.getText().equalsIgnoreCase(text))
						{
							TestCase.value.setReason("Text in field-"+textField.getText()+". Field contains the desired text.");
							return true;
						}
						else
						{
							TestCase.value.setReason("Text in field-"+textField.getText()+". Field does not contains the desired text.");
							return false;
						}
					}
				}
				else
				{
					TestCase.value.setReason("Element not found");
					System.out.println("Element not found");
				}*/
				
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			TestCase.value.setReason("Element not found");
			return false;
		}
		return false;
	}	
	protected boolean verifyElementExists(String Field, String Label, String Type, String TestType) 
	{
		boolean finalResult=false;
		List<WebElement> varElements=findElements(Field);
		//String s="#tableView > div > article > div.content > h3 > a";
		//String obj=TopcoderMain.readObjectDescription.get("divReplyPost_Footer").getObjectDescription();
		//List <WebElement> varElements=findElement(obj).findElements(By.tagName("a"));
		System.out.println(varElements.size());
		/*		try
		{	*/
		if (varElements.size()>0)
		{
			for (WebElement ele : varElements)
			{
				System.out.println("element get text"+ele.getText());
				if (ele.getText().equalsIgnoreCase(Label))
				{
					//ele.click();
					//Thread.sleep(1000);

					finalResult=true;
					break;
				}


			}

			if (finalResult)
				TestCase.value.setReason("Element- "+Label+" is displaying on the page.");
			else
				TestCase.value.setReason("Element- "+Label+" is not displaying on the page.");

			if (TestType.toLowerCase().equalsIgnoreCase("negative") && !finalResult)
				return true;
			else if (TestType.toLowerCase().equalsIgnoreCase("negative") && finalResult)
				return false;
			else 
				return finalResult;
		}
		else
			TestCase.value.setReason("No such element is displaying on the page: "+Label);
		return false;


	}	
	
	protected boolean verifyPageTitle(String pagetitle) 
	{
		try{
		
			if(fDriver.getTitle().equals(pagetitle))
				return true;
			else
				return false;
						
		
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		TestCase.value.setReason(e.getMessage());
		return false;
	}

	}	
	protected boolean verifyChallengeLoading(String Field) 
	{
		try{
				String str =Field.split(":")[0];
				WebElement challengeField=findElement(str);
				
				if(challengeField!=null)
				{
					//System.out.println(challengeField.getAttribute("class"));
					if(challengeField.getAttribute("class")!=null)
					{
						if(!challengeField.getAttribute("class").contains("active"))
						{
							clickAField(Field);
							//Thread.sleep(10000);
						}
						long loadTime=new sfdcPageEvents(fDriver).getLoadingTime(TopcoderMain.readObjectDescription.get("tblChallenges").getObjectDescription());
					/*	long startTime = System.currentTimeMillis()/1000;  
						 System.out.println("The startTime is "+startTime);  
						 //Set the acceptable Page load time to 60 sec  
						 fDriver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);   
						 WebElement search = findElement(TopcoderMain.readObjectDescription.get("tblChallenges").getObjectDescription());
						 //Iterate through the loop as long as time(60sec) is with in the acceptable Page load time  
						 while(((System.currentTimeMillis()/1000)-startTime)<=2)
						 {  
						         if(search.isDisplayed()){  
						  long endTime = System.currentTimeMillis()/1000;  
						  System.out.println("The endTime is "+endTime);  
						  long loadTime = endTime - startTime;  
						  System.out.println("Totaltime: " +loadTime + " seconds");   
						      break;  
						  }    
						   }     */  
						    
						challengeField= findElement(TopcoderMain.readObjectDescription.get("tblChallenges").getObjectDescription());
						if(challengeField.isDisplayed() && challengeField.findElements(By.tagName("a")).size()>0)
						{
							TestCase.value.setReason(Field.split(":")[1]+" are getting loaded in "+loadTime+" secs.");
							return true;
						}
						
						else if(findElement(TopcoderMain.readObjectDescription.get("txtArticle").getObjectDescription()).getText().
								contains("challenges at this time. Please check back later"))
						{
							TestCase.value.setReason("There are no records for "+Field.split(":")[1]+" and page is getting loaded in "+loadTime+" secs.");
							return true;
						}
						else if(!challengeField.isDisplayed())
						{
							TestCase.value.setReason("There are no records for "+Field.split(":")[1]+" and page is getting loaded in "+loadTime+" secs.");
							return true;
						}
					}
				}
				else
				{
					TestCase.value.setReason("Element not found");
					System.out.println("Element not found");
				}
				
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			TestCase.value.setReason("Element not found");
			return false;
		}
		return false;
	}	
	
	protected boolean chkloading()
	{
		new sfdcPageEvents(fDriver).getLoadingTime("id==logo");
		/*long startTime = System.currentTimeMillis()/1000;  
		 System.out.println("The startTime is "+startTime);  
		 //Set the acceptable Page load time to 60 sec  
		 fDriver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);   
		 WebElement search = findElement("id==logo");
		 System.out.println((System.currentTimeMillis()/1000)-startTime);
		 //Iterate through the loop as long as time(60sec) is with in the acceptable Page load time  
		 while(((System.currentTimeMillis()/1000)-startTime)<=2)
		 {  
		         if(search.isDisplayed())
		         {  
		  long endTime = System.currentTimeMillis()/1000;  
		  System.out.println("The endTime is "+endTime);  
		  long loadTime = endTime - startTime;  
		  System.out.println("Totaltime: " +loadTime + " seconds");   
		      break;  
		  }    
		   }   */
		return true;
		
	}
	protected boolean verifyPaging() 
	{
		try
		{
			if(findElement(TopcoderMain.readObjectDescription.get("txtArticle").getObjectDescription()).getText().
					matches("There are no(.*)challenges at this time. Please check back later"))
			{
				TestCase.value.setReason("Paging is not available as there are no records on this page");
				return true;
			}
			else
			{
			WebElement prevLink=null;
			WebElement nextLink = findElement(TopcoderMain.readObjectDescription.get("lnkNext_Challenge").getObjectDescription());
			if(nextLink!=null && nextLink.isDisplayed())
			{
				nextLink.click();
				prevLink= findElement(TopcoderMain.readObjectDescription.get("lnkPrev_Challenge").getObjectDescription());
				if(prevLink!=null && prevLink.isDisplayed())
				{
					prevLink.click();
					if(!prevLink.isDisplayed() && nextLink.isDisplayed())
					{
						TestCase.value.setReason("Paging is working fine");
						//return true;
					}
					else
						TestCase.value.setReason("Paging is not working as desired. Please have a look.");
				}
			}
			nextLink = findElement(TopcoderMain.readObjectDescription.get("lnkViewAll").getObjectDescription());
			if(nextLink!=null && nextLink.isDisplayed())
			{
			nextLink.click();
			nextLink = findElement(TopcoderMain.readObjectDescription.get("lnkNext_Challenge").getObjectDescription());
			prevLink= findElement(TopcoderMain.readObjectDescription.get("lnkPrev_Challenge").getObjectDescription());
			if((nextLink==null || !nextLink.isDisplayed()) && (prevLink==null || !prevLink.isDisplayed()))
			{
				nextLink = findElement(TopcoderMain.readObjectDescription.get("lnkViewAll").getObjectDescription());
				if(nextLink==null || !nextLink.isDisplayed())
				{
					TestCase.value.setReason(TestCase.value.getReason()+" 'View All' link is working fine");
					return true;
				}
				else
				{
					TestCase.value.setReason(TestCase.value.getReason()+" 'View All' link is not working as desired. It is visible even after it is clicked");
					return false;
				}
					
			}
			else
			{
				TestCase.value.setReason(TestCase.value.getReason()+" 'View All' link is not working as desired. Please have a look.");
				return false;
			}
			}
			else
			{
				TestCase.value.setReason(TestCase.value.getReason()+" Paging is not available as there are less number of records on this page");
				return true;
			}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			TestCase.value.setReason("Element not found");
			return false;
		}
		
	}	
	
	protected void verifyTextOfField1(String Field) 
	{
		try{
			String varObjDesc=null;
			String[] words = Field.split(">");
			List<WebElement> elementsList = fDriver.findElements(By.linkText(words[0]));
			if (TopcoderMain.readObjectDescription.containsKey(Field))
				varObjDesc=TopcoderMain.readObjectDescription.get(Field).getObjectDescription();
			String[] varObjs=varObjDesc.split(";;");
			//System.out.println(varObjs.length);
			for (int i=0; i<varObjs.length;i++)
			{
				String[] varObjsDetail=varObjs[i].split("==");
				
				switch (varObjsDetail[0].toLowerCase()) 
				{
				case "cssselector":
					elementsList=fDriver.findElements(By.cssSelector(varObjsDetail[1].trim()));
					break;
				case "id":
					elementsList=fDriver.findElements(By.id(varObjsDetail[1].trim()));
					break;
				default:
					break;
				}
				
				/*if (varObjsDetail[0].toLowerCase().trim().equalsIgnoreCase("cssselector"))
				{
					w=fDriver.findElements(By.cssSelector(varObjsDetail[1].trim()));
				}*/
				if(elementsList.size()>0)
				{
					System.out.println(elementsList.get(0).getText());
					Assert.verify(elementsList.get(0).getText()!=null,"Correct value is displayed.");
				}
				else
				{
					System.out.println("Element not found");
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}	
		
	protected boolean sortByColumn(String Field, String colName)
	{
		try {
			String str =Field.split(":")[0];
		List<WebElement> divList=fDriver.findElements(By.xpath(str.split("==")[1]));
		System.out.println(divList.size());
		for (WebElement ele : divList) 
		{
			System.out.println("Sort Col text="+ele.getText());
			
			if (ele.getText().toLowerCase().trim().equalsIgnoreCase(colName))
			{
				ele=ele.findElement(By.tagName("div"));
				ele.click();
				Thread.sleep(5000);
				//ele.click();
				//Thread.sleep(5000);
				return true;
			}
			
			
		}
		}
		catch(NullPointerException e )
		{
			TestCase.value.setReason("Element not found");
			System.out.println( e.getMessage());
		}
		catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;

	}
	
	protected boolean selectAValueInDirectDropdown(String selectVal)
	{
		//GeneralUtility.sleep(7000);
		WebElement uiEle= findElement(TopcoderMain.readObjectDescription.get("lnkNewList").getObjectDescription());
		List<WebElement> aElements=uiEle.findElements(By.xpath("//li/a"));
		for (WebElement link : aElements) 
		{
			//System.out.println(link.getAttribute("text"));
			if(link.isDisplayed() && link.getAttribute("text").trim().equalsIgnoreCase(selectVal))
			{
				link.click();
				GeneralUtility.sleep(7000);
				return true;
			}
		}
		TestCase.value.setReason(TestCase.value.getReason()+" Value '"+selectVal+"' not found in the list." );
		return false;
		
		
	}
	
	protected boolean getChallengeTimeLine1()
	{
		try
		{
			String daysLeft="";
			Date currentDate= null;
			int cnt=0;
			WebElement divList=findElement("cssSelector==#tableView > div > div.ngViewport.ng-scope > div > div:nth-child("+cnt+")");
					//fDriver.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRow").getObjectDescription().split("==")[1]));
			List<WebElement> registrationDate=null;
			if(divList!=null)
			{
				registrationDate= divList.findElements(By.cssSelector("div > div.ngCell.challengeCell.col3.colt3 > div > div > div:nth-child(4) > div"));
						//findElement("cssSelector=#tableView > div > div.ngViewport.ng-scope > div > div:nth-child("+cnt+") > div > div.ngCell.challengeCell.col3.colt3 > div > div > div:nth-child(4) > div");
				cnt++;
				//ele.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRegistrationDate").getObjectDescription().split("==")[1]));
				System.out.println("registrationDate="+registrationDate.size());
				if(registrationDate.size()>=1)
				{
					for (WebElement ele1 : registrationDate) 
					{
						if(ele1.isDisplayed())
						{
							daysLeft=ele1.getText();
							System.out.println("daysLeft="+daysLeft);
							currentDate= GeneralUtility.getCurrentDateInATimezone("IST", "dd MMM yyyy HH:mm z");
							System.out.println("currentDate="+currentDate);
							Date challengeRegisterDate= GeneralUtility.convertStringtoDate(daysLeft, "dd MMM yyyy HH:mm z","EDT");
							System.out.println("challengeRegisterDate="+challengeRegisterDate);
							int dateDiff=  challengeRegisterDate.compareTo(currentDate);
							System.out.println("dateDiff="+dateDiff);
							if(dateDiff>=1)
							{
								TestCase.value.setReason("Found an open challenge: "+divList.findElement(By.tagName("a")).getText());
								divList.findElement(By.tagName("a")).click();
								return true;
							}
							else
								break;
						}
					}
				}
			}
				
				/*if(ele1!=null && ele1.isDisplayed())
				{
					daysLeft=ele1.getText();
					System.out.println("daysLeft="+daysLeft);
					currentDate= GeneralUtility.getCurrentDateInATimezone("IST");
					System.out.println("currentDate="+currentDate);
					Date challengeRegisterDate= GeneralUtility.convertStringtoDate(daysLeft, "dd MMM yyyy HH:mm z","EDT");
					System.out.println("challengeRegisterDate="+challengeRegisterDate);
					int dateDiff=  challengeRegisterDate.compareTo(currentDate);
					System.out.println("dateDiff="+dateDiff);
					if(dateDiff>=1)
					{
						TestCase.value.setReason("Found an open challenge: "+ele.findElement(By.tagName("a")).getText());
						ele.findElement(By.tagName("a")).click();
						return true;
					}
				}*/ 
		/*	if (ele.getText().toLowerCase().trim().equalsIgnoreCase(colName))
			{
				ele.click();
				Thread.sleep(5000);
				ele.click();
				Thread.sleep(5000);
				return true;
			}*/
			
			
		
		}
		catch(NullPointerException e )
		{
			TestCase.value.setReason("Element not found");
			System.out.println( e.getMessage());
		}
		TestCase.value.setReason("No open challenge available.");
		return false;

	}
	
	protected boolean getOpenChallenge()
	{
		try
		{
			String daysLeft="";
			Date currentDate= null;
			int cnt=0;
			List<WebElement> divList=fDriver.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRow").getObjectDescription().split("==")[1]));
					//fDriver.findElements(By.cssSelector("#tableView > div > div.ngViewport.ng-scope > div > div:nth-child("+cnt+")"));
					//fDriver.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRow").getObjectDescription().split("==")[1]));
			System.out.println(divList.size());
			List<WebElement> registrationDate=null;
			for (WebElement ele : divList) 
			//for (int cnt=0;cnt<divList.size();cnt++) 
			{
				//registrationDate= ele.findElements(By.cssSelector("div > div.ngCell.challengeCell.col3.colt3 > div > div > div:nth-child(4) > div"));
				registrationDate= ele.findElements(By.xpath("//div[contains(@class,'vEndRound')]"));
						//findElement("cssSelector=#tableView > div > div.ngViewport.ng-scope > div > div:nth-child("+cnt+") > div > div.ngCell.challengeCell.col3.colt3 > div > div > div:nth-child(4) > div");
				cnt++;
				//ele.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRegistrationDate").getObjectDescription().split("==")[1]));
				System.out.println("registrationDate="+registrationDate.size());
				if(registrationDate.size()>=1)
				{
					for (WebElement ele1 : registrationDate) 
					{
						//if(ele1.isDisplayed() && !ele.findElement(By.tagName("a")).getText().contains("testSuite") && !ele.findElement(By.tagName("a")).getText().contains("Test Challenge"))
						if(ele1.isDisplayed())
						{
							daysLeft=ele1.getText();
							System.out.println("daysLeft="+daysLeft);
							currentDate= GeneralUtility.getCurrentDateInATimezone("IST", "dd MMM yyyy HH:mm z"); /// added format 09/16 P
							System.out.println("currentDate="+currentDate);
							Date challengeRegisterDate= GeneralUtility.convertStringtoDate(daysLeft, "dd MMM yyyy HH:mm z","EDT");
							System.out.println("challengeRegisterDate="+challengeRegisterDate);
							int dateDiff=  challengeRegisterDate.compareTo(currentDate);
							System.out.println("dateDiff="+dateDiff);
							if(dateDiff>=1)
							{
								TestCase.value.setReason("Found an open challenge: "+ele.findElement(By.tagName("a")).getText());
								ele.findElement(By.tagName("a")).click();
								return true;
							}
							else
								break;
						}
					}
				}
				}
				/*if(ele1!=null && ele1.isDisplayed())
				{
					daysLeft=ele1.getText();
					System.out.println("daysLeft="+daysLeft);
					currentDate= GeneralUtility.getCurrentDateInATimezone("IST");
					System.out.println("currentDate="+currentDate);
					Date challengeRegisterDate= GeneralUtility.convertStringtoDate(daysLeft, "dd MMM yyyy HH:mm z","EDT");
					System.out.println("challengeRegisterDate="+challengeRegisterDate);
					int dateDiff=  challengeRegisterDate.compareTo(currentDate);
					System.out.println("dateDiff="+dateDiff);
					if(dateDiff>=1)
					{
						TestCase.value.setReason("Found an open challenge: "+ele.findElement(By.tagName("a")).getText());
						ele.findElement(By.tagName("a")).click();
						return true;
					}
				}*/ 
		/*	if (ele.getText().toLowerCase().trim().equalsIgnoreCase(colName))
			{
				ele.click();
				Thread.sleep(5000);
				ele.click();
				Thread.sleep(5000);
				return true;
			}*/
			
			
		
		}
		catch(NullPointerException e )
		{
			TestCase.value.setReason("Element not found");
			System.out.println( e.getMessage());
		}
		TestCase.value.setReason("No open challenge available.");
		return false;

	}
	protected boolean clickAField1(String Field)
	{
		GeneralUtility.sleep(7000);
		try {
			String str =Field.split(":")[0];
			List <WebElement> ele=findElements(str);
			String varText="";
			//varText=TopcoderMain.readObjectDescription.get(Field).getVisibleText().isEmpty();
			/*System.out.println(TopcoderMain.readObjectDescription.containsKey(Field.split(":")[1]));
		if (TopcoderMain.readObjectDescription.containsKey(Field.split(":")[1]))
		varText=TopcoderMain.readObjectDescription.get(Field.split(":")[1]).getVisibleText();
		else*/
			//System.out.println("hhghghg"+Field.split(":").length);
			if (Field.split(":").length>1)
			varText=Field.split(":")[1];
			//e.click();
			if(ele!=null)
			{
				for (WebElement e : ele)
				{
/*System.out.println("rct "+e.getText().toLowerCase());
System.out.println(e.getText().toLowerCase().trim().equalsIgnoreCase(varText));
System.out.println(e.getText().toLowerCase().trim().contains(varText.toLowerCase()));
*/
					if (e.isDisplayed() && (e.getText().toLowerCase().trim().equalsIgnoreCase(varText) || e.getText().toLowerCase().trim().contains(varText.toLowerCase())))
					{
						//Actions act = new Actions(fDriver);
						//act.moveToElement(e).click().perform();
						Thread.sleep(5000);
						e.click();
						Thread.sleep(5000);
						TestCase.value.setReason("Element found"+varText+" clicked.");
						return true;
											
					}
					else if (e.isDisplayed() && ele.size()==1)
					{
						e.click();
						Thread.sleep(5000);
						TestCase.value.setReason("Element found"+varText+" clicked.");
						return true;
						
					}
					else if(!e.isDisplayed())
					{
						TestCase.value.setReason("Element "+varText+" is not displayed on the page.");
						return true;
					}
					
						
					
					
				}
			}
			else
			{
				TestCase.value.setReason("Element is not displayed on the page.");
				return false;
			}
		}
		catch(NullPointerException e )
		{
			TestCase.value.setReason("Element not found");
			System.out.println( e.getMessage());
		}
		catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;

	}


	protected boolean enterValueInTextBoxReturnKey(String Field,String Value) ////// 07/11/2014  Pradeep
    {
      WebElement varWElement=findElement(Field);
      varWElement.sendKeys(Value);
      varWElement.sendKeys(Keys.RETURN); 
      
     // varWElement.getAttribute("text")
      return true;
    }                                        ////// 07/11/2014  Pradeeps

	protected boolean clickAField(String Field)
	{
		try {
			GeneralUtility.sleep(7000);
			String str =Field.split(":")[0];
			WebElement e=findElement(str);
		String varText="";
		//varText=TopcoderMain.readObjectDescription.get(Field).getVisibleText().isEmpty();
		/*System.out.println(TopcoderMain.readObjectDescription.containsKey(Field.split(":")[1]));
		if (TopcoderMain.readObjectDescription.containsKey(Field.split(":")[1]))
		varText=TopcoderMain.readObjectDescription.get(Field.split(":")[1]).getVisibleText();
		else*/
		
		//e.click();
		if(e!=null && e.isDisplayed())
		{
			if(Field.split(":").length>1)
			{
				varText=Field.split(":")[1];
			if (e.getText().toLowerCase().trim().equalsIgnoreCase(varText))
			{
				e.click();
			}
			}
			else
				e.click();
			Thread.sleep(5000);
			return true;
		}
		else if(e!=null && !e.isDisplayed())
		{
			TestCase.value.setReason("Element not visible");
			return true;
		}
		else
		{
			TestCase.value.setReason("Element not found");
			return false;
		}
		}
		catch(NullPointerException e )
		{
			TestCase.value.setReason("Element not found");
			System.out.println( e.getMessage());
		}
		catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;

	}
	 protected boolean login(LoginData loginValues, String loginIds)throws AssertionError
	    {
		  //String[] loginId= loginIds.split(",");
		  String usernameId="";
		  String passwordId="";
		  String signInButton="";
		  String logOutButton ="";
		 /*if (TopcoderMain.readObjectDescription.containsKey(loginId[0]))
			 usernameId=TopcoderMain.readObjectDescription.get(loginId[0]).getObjectDescription();
		 if (TopcoderMain.readObjectDescription.containsKey(loginId[1]))
			 passwordId=TopcoderMain.readObjectDescription.get(loginId[1]).getObjectDescription();
		 if (TopcoderMain.readObjectDescription.containsKey(loginId[2]))
			 signInButton=TopcoderMain.readObjectDescription.get(loginId[2]).getObjectDescription();*/
		 if (TopcoderMain.readObjectDescription.containsKey("tbHomeUserName"))
			 usernameId=TopcoderMain.readObjectDescription.get("tbHomeUserName").getObjectDescription();
		 if (TopcoderMain.readObjectDescription.containsKey("tbHomePassword"))
			 passwordId=TopcoderMain.readObjectDescription.get("tbHomePassword").getObjectDescription();
		 if (TopcoderMain.readObjectDescription.containsKey("btnHomeSignIn"))
			 signInButton=TopcoderMain.readObjectDescription.get("btnHomeSignIn").getObjectDescription()+":"+TopcoderMain.readObjectDescription.get("btnHomeSignIn").getVisibleText();
		 if (TopcoderMain.readObjectDescription.containsKey("lnkLogOut"))
			 logOutButton=TopcoderMain.readObjectDescription.get("lnkLogOut").getObjectDescription();
	    	try 
			{
	    		/*WebElement login_page_ctrl=null;
			    login_page_ctrl = findElement(usernameId);  
			    //login_page_ctrl.clear();
			    //login_page_ctrl.sendKeys(loginValues.getUserName());
				  //WebElement passwordTxt = driver.findElement(By.name("pw"));
			   // login_page_ctrl = findElement(passwordId);
			   // login_page_ctrl.clear();
			    //login_page_ctrl.sendKeys(loginValues.getPassword());
			
			   // login_page_ctrl =findElement(signInButton);
			   // login_page_ctrl = findElement(By.id("signin-button"));
			   // login_page_ctrl.click();
				  //login_page_ctrl = findElement(logOutButton);  
				    //if(login_page_ctrl==null)
				    //{
				    //	System.out.println("Unable to login");
				    	//return false;
				    //}
				//    else
				    	return true;*/
			    enterValueInTextBox(usernameId,loginValues.getUserName());
			    enterValueInTextBox(passwordId,loginValues.getPassword());
			    clickAField(signInButton);
			    GeneralUtility.sleep(15000);
			    if(findElement(logOutButton)!=null)
			    {
			    	currentUserHandle=loginValues.getUserName();
			    	return true;
			    }
			    else
			    {
			    	TestCase.value.setReason("Login Failed");
			    	//System.out.println("Login Failed");
			    	return false;
			    }
			    //login_page_ctrl =driver.findElement(By.xp
			    
			}
			catch (AssertionError e) 
			{
				throw new AssertionError("Login Failed");
			} 
			
	    }
	 protected boolean loginDirect(LoginData loginValues)throws AssertionError
	    {
		  //String[] loginId= loginIds.split(",");
		  String usernameId="";
		  String passwordId="";
		  String signInButton="";
		  String logOutButton ="";
		 if (TopcoderMain.readObjectDescription.containsKey("txtDirectUsername"))
			 usernameId=TopcoderMain.readObjectDescription.get("txtDirectUsername").getObjectDescription();
		 if (TopcoderMain.readObjectDescription.containsKey("txtDirectPassword"))
			 passwordId=TopcoderMain.readObjectDescription.get("txtDirectPassword").getObjectDescription();
		 if (TopcoderMain.readObjectDescription.containsKey("lnkDirectLogIn"))
			 signInButton=TopcoderMain.readObjectDescription.get("lnkDirectLogIn").getObjectDescription()+":"+TopcoderMain.readObjectDescription.get("lnkDirectLogIn").getVisibleText();
		 if (TopcoderMain.readObjectDescription.containsKey("lnkDirectLogOut"))
			 logOutButton=TopcoderMain.readObjectDescription.get("lnkDirectLogOut").getObjectDescription();
	    	try 
			{
	    		enterValueInTextBox(usernameId,loginValues.getUserName());
			    enterValueInTextBox(passwordId,loginValues.getPassword());
			    clickAField(signInButton);
			    GeneralUtility.sleep(15000);
			    if(findElement(logOutButton)!=null)
			    {
			    	currentUserHandle=loginValues.getUserName();
			    	return true;
			    }
			    else
			    {
			    	TestCase.value.setReason("Login Failed");
			    	//System.out.println("Login Failed");
			    	return false;
			    }
			    //login_page_ctrl =driver.findElement(By.xp
			    
			}
			catch (AssertionError e) 
			{
				throw new AssertionError("Login Failed");
			} 
			
	    }
	protected boolean selectMenuOption(String Field)
	{
		String[] words = Field.split(">");
		//System.out.println("words[0]="+words[0]);
		List<WebElement> elementsList = fDriver.findElements(By.linkText(words[0]));
		//List<WebElement> elementsList = fDriver.findElements(By.linkText("Community"));
		//List<WebElement> w=fDriver.findElements(By.linkText(words[0]));
		//System.out.println(elementsList.size());
		//w.get(0).click();
		try 
		{
			for(WebElement e : elementsList)
			{
				if (e.getText().toLowerCase().trim().equalsIgnoreCase(words[0]))
				{
					//e.click();
					//new Actions(fDriver).moveToElement(e).perform();
					String javaScript = "var evObj = document.createEvent('MouseEvents');" +
		                    "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
		                    "arguments[0].dispatchEvent(evObj);";
					((JavascriptExecutor)fDriver).executeScript(javaScript, e);
						Thread.sleep(5000);
					
					List<WebElement> elementsList2=e.findElement(By.xpath("./following-sibling::ul")).findElements(By.tagName("li"));
					//System.out.println(elementsList2.size());
	
					for(WebElement e1 : elementsList2)
					{
						//System.out.println(e1.getText());
						if (e1.getText().toLowerCase().trim().equalsIgnoreCase(words[1]))
						{
							//System.out.println(e1.getText());
							//e1.click();
							e1.findElement(By.tagName("a")).click();
							Thread.sleep(10000);
							System.out.println("Menu option "+words[1]+" clicked");
							//Thread.sleep(20000);
							return true;
						}
	
					}
					
				}

		}
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return false;

	}
	
	protected boolean verifySearchResults(String objTable, String objSearchItem)
	{
		
		boolean finalResult=true;
		//String s="#tableView > div > article > div.content > h3 > a";
		List<WebElement> varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
		System.out.println(varElements.size());
		try
		{
			for (int i=0; i<varElements.size();i++)
		//for (WebElement ele : varElements)
		{
			//varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
				String s="cssSelector=#tableView > div > article:nth-child("+Integer.toString(i+2)+") > div.content > h3 > a";
			WebElement ele=findElement(s);
			System.out.println(ele.getText());
			String varSearchResult=ele.getText();
			ele.click();
			Thread.sleep(5000);
			String obj=TopcoderMain.readObjectDescription.get("lblPageTitle_SearchResult").getObjectDescription();
			WebElement ele1=findElement(obj);
			String varPageHeader=ele1.getText();
			if (!varSearchResult.equalsIgnoreCase(varPageHeader))
				finalResult=false;	
			fDriver.navigate().back();
			Thread.sleep(5000);
		}
		
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return finalResult;
	
		
	}

	protected boolean verifyRegistration() 
	{
		WebElement popup=findElement(TopcoderMain.readObjectDescription.get("divRegisterSuccess").getObjectDescription());
		System.out.println("id="+popup.getAttribute("id"));
		//if(popup.getAttribute("style").contains("display: none;"))
		if(!popup.isDisplayed())
		{
			popup=findElement(TopcoderMain.readObjectDescription.get("divRegisterFail").getObjectDescription());
			if(popup!=null && popup.isDisplayed())
			{
				String popupText= popup.getText();
				TestCase.value.setReason("Registration failed. Message displayed -"+popupText);
				//popup = findElement(TopcoderMain.readObjectDescription.get("btnCloseModalBox").getObjectDescription());
				//popup.click();
				popup.findElement(By.linkText("Ok")).click();
				popup= findElement(TopcoderMain.readObjectDescription.get("lnkRegistrants").getObjectDescription());
				popup.click();
				if(popupText.contains("already registered"))
				{
					List<WebElement> registrants=findElement(TopcoderMain.readObjectDescription.get("tblRegistrants").getObjectDescription()).findElements(By.tagName("a"));
					for (WebElement registrant : registrants) 
					{
						System.out.println(registrant.getText());
						if(registrant.getText().equalsIgnoreCase(currentUserHandle))
						{
							TestCase.value.setReason(TestCase.value.getReason()+ ". User already registered for the challenge");
							break;
						}
					}
				}
				return false;
			}
			
		}
		else
		{
			System.out.println(popup.getText());
			TestCase.value.setReason("Registration successful. Message displayed -"+popup.getText());
			//popup = popup.findElement(By.xpath("//a[@class='btn closeModalReg']"));
			popup.findElement(By.linkText("Ok")).click();
			popup= findElement(TopcoderMain.readObjectDescription.get("lnkRegistrants").getObjectDescription());
			popup.click();
			List<WebElement> registrants=findElement(TopcoderMain.readObjectDescription.get("tblRegistrants").getObjectDescription()).findElements(By.tagName("a"));
			for (WebElement registrant : registrants) 
			{
				System.out.println(registrant.getText());
				if(registrant.getText().equalsIgnoreCase(currentUserHandle))
				{
					TestCase.value.setReason(TestCase.value.getReason()+ ". User registered successfully for the challenge");
					break;
				}
			}
			//if(popup.isDisplayed())
			//popup.click();
			return true;
		}
		return false;
	}
	
	protected boolean verifySearchResults(String objTable)
	{

		boolean finalResult=true;
		//String s="#tableView > div > article > div.content > h3 > a";
		List<WebElement> varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
		System.out.println(varElements.size());
		try
		{
			for (int i=0; i<varElements.size();i++)
				//for (WebElement ele : varElements)
			{
				//varElements=fDriver.findElements(By.cssSelector(objTable.split("=")[1]));
				String s="cssSelector==#tableView > div > article:nth-child("+Integer.toString(i+2)+") > div.content > h3 > a";
				WebElement ele=findElement(s);
				System.out.println(ele.getText());
				String varSearchResult=ele.getText();
				ele.click();
				Thread.sleep(5000);
				String obj=TopcoderMain.readObjectDescription.get("lblPageTitle_SearchResult").getObjectDescription();
				WebElement ele1=findElement(obj);
				String varPageHeader=ele1.getText();
				if (!varSearchResult.equalsIgnoreCase(varPageHeader))
					finalResult=false;	
				fDriver.navigate().back();
				Thread.sleep(5000);
			}

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return finalResult;


	}	
	
	protected boolean verifyHelpCenterLHSPanelItem(String objTable, String varOptionName)
	{

		String varSelectedItmNm="";
		String varPageTitle="";

		boolean finalResult=true;
		//String s1="#main > div.container.grid.grid-float.helpContainer > div.grid-3-1 > nav > ul:nth-child(1) > li > a > i";
		List<WebElement> varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
		//List<WebElement> varElements=fDriver.findElements(By.cssSelector(s1));
		System.out.println(varElements.size());

		try
		{
			for (int i=0; i<varElements.size();i++)
			{

				String s="cssSelector==#main > div.container.grid.grid-float.helpContainer > div.grid-3-1 > nav > ul:nth-child(1) > li:nth-child("+Integer.toString(i+1)+") > a";
				WebElement ele=findElement(s);
				System.out.println(varOptionName.toLowerCase().startsWith(ele.getAttribute("class").substring(0, 4)));
				System.out.println(ele.getAttribute("class").substring(0, 4));
				if (varOptionName.toLowerCase().startsWith(ele.getAttribute("class").substring(0, 4)))
				{
					ele.click();
					Thread.sleep(1000);
					//String varXpath="xpath==//*[@id=\""+"main"+"\"]/div[2]/div[1]/nav/ul[2]/li["+Integer.toString(i+1)+"]/a";
					String varXpath="xpath==/html/body/div/div[1]/div/div[2]/div[1]/nav/ul[2]/li["+Integer.toString(i+1)+"]/a";
					WebElement e=findElement(varXpath);
					varSelectedItmNm=e.getText();
					System.out.println(e.getAttribute("innerText"));
					//varSelectedItmNm=getObjectProperty("imgHelpCenterLHSSelectedItemNm","innerText");
					varPageTitle=getObjectProperty("imgHelpCenterPageTitle", "alt");

					
					if (!varSelectedItmNm.equalsIgnoreCase(varPageTitle))
						finalResult=false;	
					//break;
					//fDriver.navigate().back();
					//Thread.sleep(5000);
					break;
				}


			}

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return finalResult;


	}
	
	
	protected boolean verifyHelpCenterFAQList(String objTable, String varOptionName)
	{

		//String varSelectedItmNm="";
		String varPageTitle="";

		boolean finalResult=true;
		//String s1="#main > div.container.grid.grid-float.helpContainer > div.grid-3-1 > nav > ul:nth-child(1) > li > a > i";
		List<WebElement> varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
		//List<WebElement> varElements=fDriver.findElements(By.cssSelector(s1));
		System.out.println(varElements.size());

		try
		{
			for (int i=0; i<varElements.size();i++)
			{
				String s="cssSelector==#main > div.container.grid.grid-float.helpContainer > div.grid-3-2 > div.faqs > div.faq > ul > li:nth-child("+Integer.toString(i+1)+") > a";
				WebElement ele=findElement(s);
				System.out.println(varOptionName.toLowerCase().startsWith(ele.getAttribute("class").substring(0, 4)));
				System.out.println(ele.getAttribute("class").substring(0, 4));
				if (varOptionName.toLowerCase().startsWith(ele.getAttribute("class").substring(0, 4)))
				{
					ele.click();
					Thread.sleep(1000);
					String obj=TopcoderMain.readObjectDescription.get("txtHelpCenterFAQPageTitle").getObjectDescription();
					WebElement e=findElement(obj);
					
					varPageTitle=e.getText();                //getObjectProperty("txtHelpCenterFAQPageTitle", "innerText");


					if (!varOptionName.equalsIgnoreCase(varPageTitle))
					{
						finalResult=false;
						TestCase.value.setReason("Link name Displayed: "+varOptionName+"Page title displayed: "+varPageTitle);
					}
					//break;
					fDriver.navigate().back();
					Thread.sleep(5000);
					break;
				}


			}

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return finalResult;

	}
	
	protected boolean verifyBlogs(String objTable)
	{
		boolean finalResult=true;
		//String s="#tableView > div > article > div.content > h3 > a";
		List<WebElement> varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
		System.out.println(varElements.size());
		try
		{
			for (int i=0; i<varElements.size();i++)
				//for (WebElement ele : varElements)
			{
				//varElements=fDriver.findElements(By.cssSelector(objTable.split("=")[1]));
				//#mainContent > div > div > div.mainStream.grid-2-3 > section > div.blogsWrapper > div:nth-child(3) > a
				String s="cssSelector==#mainContent > div > div > div.mainStream.grid-2-3 > section > div.blogsWrapper > div:nth-child("+Integer.toString(i+3)+") > a";
				WebElement ele=findElement(s);
				System.out.println(ele.getText());
				String varSearchResult=ele.getText();
				ele.click();
				Thread.sleep(5000);
				String obj=TopcoderMain.readObjectDescription.get("lblPageTitle_Blog").getObjectDescription();
				WebElement ele1=findElement(obj);
				String varPageHeader=ele1.getText();
				if (!varSearchResult.equalsIgnoreCase(varPageHeader))
					finalResult=false;	
				fDriver.navigate().back();
				Thread.sleep(5000);
			}

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return finalResult;




	}
	
	protected boolean verifyForums(String obj)
	{
		boolean finalResult=true;
		WebElement select=null;	

		String varSearchResult="";
		try
		{
			select= findElement(obj);

			List<WebElement> allOptions = select.findElements(By.tagName("option"));
			System.out.println(allOptions.size());
			System.out.println(allOptions.toString());

			for (int i=1; i<allOptions.size(); i++)

			{
				String str;
				if (i ==9 || i==10)
					str= "cssSelector==body > table > tbody > tr > td.rtBody > table:nth-child(2) > tbody > tr:nth-child(1) > td.categoriesBox > form > select > optgroup > option:nth-child("+Integer.toString(i-8)+")"; 
				else				  
					str= "cssSelector==body > table > tbody > tr > td.rtBody > table:nth-child(2) > tbody > tr:nth-child(1) > td.categoriesBox > form > select > option:nth-child("+Integer.toString(i+1)+")";

				//WebElement e = fDriver.findElement(By.cssSelector(str));
				WebElement e = findElement(str);
				varSearchResult=e.getAttribute("text");
				System.out.println("Option Selected: "+varSearchResult);
				e.click();
				Thread.sleep(5000);
				String pgTitle=TopcoderMain.readObjectDescription.get("lblPageTitle_Forums").getObjectDescription();
				WebElement ele1=findElement(pgTitle);
				String varPageHeader=ele1.getText();
				System.out.println("Page Title :"+ele1.getText());
				if (!varPageHeader.contains(varSearchResult))
				{
					finalResult=false;
					System.out.println("fales"+Integer.toString(i));
					TestCase.value.setReason("Option selected : "+varSearchResult+"Page title displayed: "+varPageHeader);
				}
			}

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return finalResult;

	}
	
	protected boolean selectForumCategory(String obj, String categoryNm)
	{
		boolean finalResult=false;
		WebElement select=null;	

		String varSearchResult="";
		try
		{
			select= findElement(obj);

			List<WebElement> allOptions = select.findElements(By.tagName("option"));
			System.out.println(allOptions.size());
			System.out.println(allOptions.toString());

			for (int i=1; i<allOptions.size(); i++)

			{
				String str;
				if (i ==9 || i==10)
					str= "cssSelector==body > table > tbody > tr > td.rtBody > table:nth-child(2) > tbody > tr:nth-child(1) > td.categoriesBox > form > select > optgroup > option:nth-child("+Integer.toString(i-8)+")"; 
				else				  
					str= "cssSelector==body > table > tbody > tr > td.rtBody > table:nth-child(2) > tbody > tr:nth-child(1) > td.categoriesBox > form > select > option:nth-child("+Integer.toString(i+1)+")";

				//WebElement e = fDriver.findElement(By.cssSelector(str));
				WebElement e = findElement(str);
				varSearchResult=e.getAttribute("text");
				System.out.println("Option Selected: "+varSearchResult);
				if (varSearchResult.trim().equalsIgnoreCase(categoryNm))
				{
				e.click();
				Thread.sleep(5000);
				String pgTitle=TopcoderMain.readObjectDescription.get("lblPageTitle_Forums").getObjectDescription();
				WebElement ele1=findElement(pgTitle);
				String varPageHeader=ele1.getText();
				System.out.println("Page Title :"+ele1.getText());
				if (varPageHeader.contains(varSearchResult))
				{
					finalResult=true;
					System.out.println("fales"+Integer.toString(i));
					TestCase.value.setReason("Forum : "+varSearchResult+" selected and forum page displayed successfully");
					break;
				}
				
				}
				
			}

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		if (!finalResult)
			TestCase.value.setReason("Forum : "+varSearchResult+" is not selected.");	
		
		return finalResult;

	}
	protected boolean selectSearchItem(String objTable, String varItem, Integer j, String varCategory)
	{
		boolean finalResult=false;
		//String s="#tableView > div > article > div.content > h3 > a";
		List<WebElement> varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
		System.out.println(varElements.size());
		try
		{	
			for (WebElement ele : varElements)
			{

				System.out.println(ele.getText());
				String varSearchResult=ele.getText();
				if (varSearchResult.equalsIgnoreCase(varCategory))
				{
					ele.click();
					Thread.sleep(5000);
					finalResult=true;
					break;
				}
			}
			////////////////
			if (!finalResult)
			{
				String str=TopcoderMain.readObjectDescription.get("lnkNext").getObjectDescription();
				str= str+":"+TopcoderMain.readObjectDescription.get("lnkNext").getVisibleText();
				
				if (clickAField1(str))
				{
					if (selectSearchItem(objTable,varItem,j,varCategory))
						finalResult=true;	
						
				}
				else
					TestCase.value.setReason("Searched element "+varCategory+" is not displaying on the page.");
//////////////////////////////////				
			}

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	catch(NoSuchElementException e)
	{
		//e.printStackTrace();
		System.out.println("NoSuchElementException");
	}
	return finalResult;



	}

	protected boolean SelectThread(String objTable, String varItem, Integer j, String varCategory)
	{
		boolean finalResult=true;
		//String s="#tableView > div > article > div.content > h3 > a";
		List<WebElement> varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
		System.out.println(varElements.size());
		try
		{	
			mainloop:
			 for (WebElement ele : varElements)
			{

				//System.out.println(ele.findElement(By.cssSelector("tr:nth-child(1) > td")).getText());
				List<WebElement> varElements1=ele.findElements(By.className("rtHeader"));
				System.out.println(varElements1.size());
				if (varElements1.size()>0)
				{
					for (WebElement ele1 : varElements1)
					{
						System.out.println(ele1.findElement(By.className("rtbcLink")).getText());
						List <WebElement> varElements2= ele1.findElements(By.className("rtbcLink"));
						System.out.println(varElements2.size());
						for (WebElement ele2 : varElements2)
						{	
							System.out.println(ele2.getText());
							if (ele2.getText().equalsIgnoreCase("Reply"))
							{
								ele2.click();
							Thread.sleep(5000);	
							break mainloop;
							}
							else
							{
								finalResult=true;
							}
							}

						}
					}


				}

			
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		return finalResult;


	}
	
	protected boolean postReply()
	{
		boolean finalResult=false;
		//String s="#tableView > div > article > div.content > h3 > a";
		String obj=TopcoderMain.readObjectDescription.get("divReplyPost_Footer").getObjectDescription();
		List <WebElement> varElements=findElement(obj).findElements(By.tagName("a"));
		System.out.println(varElements.size());
		try
		{	
		for (WebElement ele : varElements)
		{
			if (ele.getText().equalsIgnoreCase("Post"))
			{
				ele.click();
				Thread.sleep(1000);
				finalResult=true;
				break;
			}
			

		}
		
		
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return finalResult;
		
	}
	
	
	
	protected boolean selectForumsInCategory(String objTable)
	{boolean finalResult=true;
	//String s="#tableView > div > article > div.content > h3 > a";
	List<WebElement> varElements=fDriver.findElements(By.cssSelector(objTable.split("==")[1]));
	System.out.println(varElements.size());
	try
	{
		for (int i=0; i<varElements.size();i++)
	//for (WebElement ele : varElements)
	{
		//varElements=fDriver.findElements(By.cssSelector(objTable.split("=")[1]));
			//#mainContent > div > div > div.mainStream.grid-2-3 > section > div.blogsWrapper > div:nth-child(3) > a
			String s="cssSelector==body > table > tbody > tr > td.rtBody > table:nth-child(2) > tbody > tr:nth-child(1) > td.categoriesBox > a:nth-child("+Integer.toString(2*i+1)+")";
		WebElement ele=findElement(s);
		System.out.println(ele.getText());
		String varSearchResult=ele.getText();
		ele.click();
		Thread.sleep(5000);
		String obj=TopcoderMain.readObjectDescription.get("lblPageTitle_Forums").getObjectDescription();
		WebElement ele1=findElement(obj);
		String varPageHeader=ele1.getText();
		System.out.println(ele1.getText());
		if (!varPageHeader.contains(varSearchResult))
			finalResult=false;	
		//fDriver.navigate().back();
		Thread.sleep(5000);
	}
	
	}catch(InterruptedException e)
	{
		e.printStackTrace();
	}
	return finalResult;

	
		
	}
	
	protected boolean VerifyMemberProfile(String objTable)///////////
	{
		boolean finalResult=false;
		int adjuster=0;
		String aa="cssSelector==#design > table > tbody > {tr:nth-child(1)} > td.colHandle > a";
		String obj=objTable.split("\\{")[0]+(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[0]+(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[1];
				//String oo=(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[0];
				//String oo2=(objTable.split("\\{")[1]).split("\\:nth-child(1)\\}")[0]+(objTable.split("\\{")[1]).split("\\:nth-child(1)\\}")[1];
		
		//String s="#tableView > div > article > div.content > h3 > a";
		List<WebElement> varElements=findElements(obj);
		System.out.println(varElements.size());
		if (varElements.size()==0)
			return false;
		try
		{	
			for (int i=1; i<=varElements.size(); i++)
			{
				String obj1=objTable.split("\\{")[0]+(objTable.split("\\{")[1]).split("1")[0]+Integer.toString(i+adjuster)+")"+(objTable.split("\\{")[1]).split("\\}")[1];
				WebElement ele =findElement(obj1);
				//String varSearchResult=ele.getAttribute("text");
				String varSearchResult=ele.getText();
				System.out.println("Member Selected: "+varSearchResult);
				ele.click();
				//((JavascriptExecutor) fDriver).executeScript("arguments[0].click();", ele);
				Thread.sleep(50000);
				String pgTitle=TopcoderMain.readObjectDescription.get("lblMemberNm_ProfilePg").getObjectDescription();
				WebElement ele1=findElement(pgTitle);
				String varPageHeader=ele1.getText();
				System.out.println("Member name on Page  :"+ele1.getText());
				if (!varPageHeader.contains(varSearchResult))
				{
					finalResult=false;
					//System.out.println("fales"+Integer.toString(i));
					TestCase.value.setReason("Member selected : "+varSearchResult+"Member name on Page  : "+varPageHeader);
				}
				fDriver.navigate().back();
				String Field="";
				if (objTable.contains("design"))
					Field="cssSelector==#mainContent > div > div > aside > section > nav > ul > li > a:Design";
				else if (objTable.contains("software"))
					Field="cssSelector==#mainContent > div > div > aside > section > nav > ul > li > a:Develop";
				else if (objTable.contains("algorithum"))
					Field="cssSelector==#mainContent > div > div > aside > section > nav > ul > li > a:Data";
						
						clickAField1(Field);
					
				Thread.sleep(30000);
				
			}
/*				if (varSearchResult.equalsIgnoreCase(varCategory))
				{
					ele.click();
					Thread.sleep(5000);
					finalResult=true;
					break;
				}
			}
			////////////////
			if (!finalResult)
			{
				String str=TopcoderMain.readObjectDescription.get("lnkNext").getObjectDescription();
				str= str+":"+TopcoderMain.readObjectDescription.get("lnkNext").getVisibleText();
				
				if (clickAField1(str))
				{
					if (selectSearchItem(objTable,varItem,j,varCategory))
						finalResult=true;	
						
				}
				else
					TestCase.value.setReason("Searched element "+varCategory+" is not displaying on the page.");
//////////////////////////////////				
			}*/

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	catch(NoSuchElementException e)
	{
		//e.printStackTrace();
		System.out.println("NoSuchElementException");
	}
	return finalResult;


	}
	
	protected boolean selectAMember(String objTable, String MemberName)///////////
	{
		boolean finalResult=false;
		int adjuster=0;
		//ArrayList<String> mylist = new ArrayList<String>();
		//mylist.add(mystring);
		//String aa="cssSelector==#design > table > tbody > {tr:nth-child(1)} > td.colHandle > a";
		String obj=objTable.split("\\{")[0]+(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[0]+(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[1];
				//String oo=(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[0];
				//String oo2=(objTable.split("\\{")[1]).split("\\:nth-child(1)\\}")[0]+(objTable.split("\\{")[1]).split("\\:nth-child(1)\\}")[1];
		
		//String s="#tableView > div > article > div.content > h3 > a";
		List<WebElement> varElements=findElements(obj);
		System.out.println(varElements.size());
		if (varElements.size()==0)
			return false;
		try
		{	
			for (int i=1; i<=varElements.size(); i++)
			{
				String obj1=objTable.split("\\{")[0]+(objTable.split("\\{")[1]).split("1")[0]+Integer.toString(i+adjuster)+")"+(objTable.split("\\{")[1]).split("\\}")[1];
				WebElement ele =findElement(obj1);
				//String varSearchResult=ele.getAttribute("text");
				String varSearchResult=ele.getText();
				System.out.println("Member Selected: "+varSearchResult);
				if (varSearchResult.trim().equalsIgnoreCase(MemberName))
				{
				ele.click();
				Thread.sleep(10000);
				finalResult=true;
				TestCase.value.setReason("Member selected : "+varSearchResult);
				break;

				
				}

			}


		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	catch(NoSuchElementException e)
	{
		//e.printStackTrace();
		System.out.println("NoSuchElementException");
	}
	return finalResult;

	}
	
	protected boolean VerifyNoOfBadgesDisplaying(String objBadges)
	{
		
		List<WebElement> varElementsTotal=findElements(objBadges);
		System.out.println(varElementsTotal.size());
		int varTotalBadgesCount=varElementsTotal.size();
		String objHiddenBadges=TopcoderMain.readObjectDescription.get("asideBadgesHIdden_TC").getObjectDescription();
		List<WebElement> varElementsHidden=findElements(objHiddenBadges);
		System.out.println(varElementsHidden.size());
		int varHiddenBadgesCount=varElementsHidden.size();
		
		TestCase.value.setReason("Total Badges displaying for the selected member : "+Integer.toString(varTotalBadgesCount-varHiddenBadgesCount));
		return true;
	}
	
	protected boolean VerifyRating(String MemberNm)
	{
		String varSelectedOption="";
		boolean finalResult=false;
		int varRatingTC=0;
		int varRatingComm=0;

		try
		{

			String objRatingTC=TopcoderMain.readObjectDescription.get("divRating_MemberProfile_TC").getObjectDescription();
			WebElement varElementsRatingTC=findElement(objRatingTC);
			if (varElementsRatingTC!=null)
			{
				System.out.println(varElementsRatingTC.getText());
				varRatingTC=Integer.parseInt(varElementsRatingTC.getText());
			}
			List <WebElement> varSelectedMenuOption =findElements("cssSelector==nav.tabNav > ul > li > a.isActive");
			varSelectedOption= varSelectedMenuOption.get(0).getText();
			if (varSelectedOption.equalsIgnoreCase("Development"))
				varSelectedOption="Develop";
			else if (varSelectedOption.equalsIgnoreCase("Marathon"))
				varSelectedOption="Marathon Matches";
			//varSelectedOption="Marathon "+"\r\n"+"Matches";

			String varURL=fDriver.getCurrentUrl();
			System.out.println(varURL);
			selectMenuOption("Community>Forums");
			String objHandleComm=TopcoderMain.readObjectDescription.get("txtHandleSearch_Comm").getObjectDescription();
			enterValueInTextBoxReturnKey(objHandleComm,MemberNm);
			Thread.sleep(1000);

			if (SelectCommunityTab(varSelectedOption))
			{	

				String objRatingComm=TopcoderMain.readObjectDescription.get("divRating_MemberProfile_Comm").getObjectDescription();
				WebElement varElementsRatingComm=findElement(objRatingComm);

				if (varElementsRatingComm!=null)
				{
					System.out.println(varElementsRatingComm.getText());
					varRatingComm=Integer.parseInt(varElementsRatingComm.getText());
				}


				if (varRatingTC==varRatingComm)
				{
					TestCase.value.setReason("Rating displaying on Topcoder : "+Integer.toString(varRatingTC)+" Rating displaying on Community : "+Integer.toString(varRatingComm));
					finalResult=true;
				}
				else 
				{
					TestCase.value.setReason("Rating displaying on Topcoder : "+Integer.toString(varRatingTC)+" Rating displaying on Community : "+Integer.toString(varRatingComm));
					finalResult=false;
				}

				sfdcPageEvents sfEvents=new sfdcPageEvents(fDriver);
				sfEvents.openUrl(varURL);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}	
		return finalResult;
	}
	
	
	protected boolean VerifyDetailedRating(String MemberNm)
	{
		ArrayList<String> varDataListTC = new ArrayList<String>();
		ArrayList<String> varDataListComm = new ArrayList<String>();
		String varSelectedOption="";
		boolean finalResult=false;

		String varResultString="";
		int a=0;

		try
		{

			String objDetailedRatingTC=TopcoderMain.readObjectDescription.get("divDetailedRating_MemberProfile_TC").getObjectDescription();
			List <WebElement> varElementsRatingTC=findElements(objDetailedRatingTC);
			if (varElementsRatingTC!=null)
			{
				varDataListTC=getTableData(varElementsRatingTC);
				//System.out.println(varElementsRatingTC.getText());
				//varRatingTC=Integer.parseInt(varElementsRatingTC.getText());
			}
			List <WebElement> varSelectedMenuOption =findElements("cssSelector==nav.tabNav > ul > li > a.isActive");
			varSelectedOption= varSelectedMenuOption.get(0).getText();
			if (varSelectedOption.equalsIgnoreCase("Development"))
				varSelectedOption="Develop";
			else if (varSelectedOption.equalsIgnoreCase("Marathon"))
				varSelectedOption="Marathon Matches";
			//varSelectedOption="Marathon "+"\r\n"+"Matches";

			String varURL=fDriver.getCurrentUrl();
			System.out.println(varURL);
			selectMenuOption("Community>Forums");
			String objHandleComm=TopcoderMain.readObjectDescription.get("txtHandleSearch_Comm").getObjectDescription();
			enterValueInTextBoxReturnKey(objHandleComm,MemberNm);
			Thread.sleep(1000);

			if (SelectCommunityTab(varSelectedOption))
			{	

				String objDetailedRatingComm=TopcoderMain.readObjectDescription.get("divDetailedRating_MemberProfile_Comm").getObjectDescription();
				List <WebElement> varElementsRatingComm=findElements(objDetailedRatingComm);

				if (varElementsRatingComm!=null)
				{
					varDataListComm=getTableData(varElementsRatingComm);
					//System.out.println(varElementsRatingComm.getText());
					//varRatingComm=Integer.parseInt(varElementsRatingComm.getText());
				}
				if (varDataListTC.size()>=varDataListComm.size())
				for (int i=0; i<varDataListTC.size();i++)
				{

					String strReturn=CompareData(varDataListTC.get(i),varDataListComm);
					varResultString=varResultString+" "+strReturn+".\n";
/*					if (strReturn.split(" ")[0].equalsIgnoreCase("SAME"))
						finalResult=true;
					else */if (strReturn.split(" ")[0].equalsIgnoreCase("DIFFERENT"))
						finalResult=false;
				}
				else if (varDataListTC.size()<varDataListComm.size())
				{

						for (int i=0; i<varDataListComm.size();i++)
						{

							String strReturn=CompareData(varDataListComm.get(i),varDataListTC);
							varResultString=varResultString+" "+strReturn;
		/*					if (strReturn.split(" ")[0].equalsIgnoreCase("SAME"))
								finalResult=true;
							else */if (strReturn.split(" ")[0].equalsIgnoreCase("DIFFERENT"))
								finalResult=false;
						}
				}

				TestCase.value.setReason(varResultString);
				

				sfdcPageEvents sfEvents=new sfdcPageEvents(fDriver);
				sfEvents.openUrl(varURL);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}	
		return finalResult;
	}
	
	protected String CompareData(String strTC,ArrayList<String> listComm)
	{
		boolean finalResult= false;
		boolean flagLabel=false;
		String strResult="";
		String varLabel1="";
		String varLabel2="";
		String varData1="";
		String varData2="";
		String varTCData="";
		String varCommData="";

			varLabel1=strTC.split(":")[0].trim();
			varData1=strTC.split(":")[1].trim();

		for (int i=0;i<listComm.size();i++)
		{


				varLabel2=listComm.get(i).split(":")[0].trim();
				varData2=listComm.get(i).split(":")[1].trim();

			
			
			if (varLabel1.equalsIgnoreCase(varLabel2))
			{
				flagLabel=true;
				
				
				if (varData1.equalsIgnoreCase(varData2))
				{
					finalResult=true;
				break;
				}
				else
				{
					varTCData=varLabel1+"  "+varData1;
					varCommData=varLabel2+"  "+varData2;
					
				}
			}
			
				
		}
		
		if (!flagLabel)
			strResult="DIFFERENT : label name is not displaying on either site: " +varLabel1;
		else if (finalResult)
			strResult="SAME data is displaying on both the sites. Topcoder Data: "+varLabel1+"  "+varData1+", Community Data: "+varLabel2+"  "+varData2;
		else
			strResult="DIFFERENT data is displaying on both the sites. Topcoder Data: "+varTCData+", Community Data: "+varCommData;
		
		
		
		return strResult;
	}
	
	
	protected ArrayList<String> getTableData(List <WebElement> objRows)
	{
		ArrayList<String> varData = new ArrayList<String>();
		System.out.println(objRows.size());
		for (WebElement row: objRows)
		{
			System.out.println(row.getText());
			String varDataRow="";
			if (row.getText().contains(":"))
			varDataRow=row.getText().replaceAll("[\\t\\n\\r]+"," ");
			else
				varDataRow=row.getText().replaceAll("[\\t\\n\\r]+",": ");
			
			varData.add(varDataRow);
		}
		
		return varData;
	}
	
	protected boolean VerifyMemberDetail(String MemberNm)//////////////
	{
		ArrayList<String> varDataListTC = new ArrayList<String>();
		ArrayList<String> varDataListComm = new ArrayList<String>();
		String varMemberNmTC="";
		String varMemberCountryTC="";
		String varMemberSinceTC="";
		String varTotalEarningTC="";
		String varMemberNmComm="";
		boolean finalResult=false;
		boolean flagMemberNm=false;
		boolean flagCountry=false;
		boolean flagMemberSince=false;
		boolean flagMemberEarning=false;

		String varResultString="";


		try
		{

			String objMemberNmTC=TopcoderMain.readObjectDescription.get("memberName_TC").getObjectDescription();
			varMemberNmTC=findElement(objMemberNmTC).getText().trim();
			
			String objMemberCountryTC=TopcoderMain.readObjectDescription.get("memberCountry_TC").getObjectDescription();
			varMemberCountryTC=findElement(objMemberCountryTC).getText().trim();
			
			
			
			String objMemberDetailTC=TopcoderMain.readObjectDescription.get("divMemberDetail_TC").getObjectDescription();
			List <WebElement> objElementMemberDetailTC=findElements(objMemberDetailTC);
			if (objMemberDetailTC!=null)
			{
				varDataListTC=getTableData(objElementMemberDetailTC);
				for (int i=0;i<varDataListTC.size();i++)
				{
					String varLabel=varDataListTC.get(i).split(":")[0].trim();

					if (varLabel.equalsIgnoreCase("Member Since"))
						varMemberSinceTC=varDataListTC.get(i).split(":")[1].trim();
					if (varLabel.equalsIgnoreCase("Total Earnings"))
						varTotalEarningTC=varDataListTC.get(i).split(":")[1].trim();;
				}

			}
			



			String varURL=fDriver.getCurrentUrl();
			System.out.println(varURL);
			selectMenuOption("Community>Forums");
			String objHandleComm=TopcoderMain.readObjectDescription.get("txtHandleSearch_Comm").getObjectDescription();
			enterValueInTextBoxReturnKey(objHandleComm,MemberNm);
			Thread.sleep(5000);
			String objMemberNmComm=TopcoderMain.readObjectDescription.get("memberName_Comm").getObjectDescription();
			varMemberNmComm=findElement(objMemberNmComm).getText().trim();
			if (varMemberNmTC.equalsIgnoreCase(varMemberNmComm))
			{
				flagMemberNm=true;
				varResultString=varResultString+" Member name is same on both the sites. Topcoder: "+varMemberNmTC+"Community: "+varMemberNmComm+ "\n";
			}
				else
				{
					flagMemberNm=false;
					varResultString=varResultString+" Member name are not same on both the sites. Topcoder: "+varMemberNmTC+"Community: "+varMemberNmComm+ "\n";
				}


/*			if (SelectCommunityTab(varSelectedOption))
			{	*/

				String objMemberDetailComm=TopcoderMain.readObjectDescription.get("divMemberDetail_Comm").getObjectDescription();
				List <WebElement> varElementMemberDetailComm=findElements(objMemberDetailComm);

				if (varElementMemberDetailComm!=null)
				{
					varDataListComm=getTableData(varElementMemberDetailComm);
					//System.out.println(varElementsRatingComm.getText());
					//varRatingComm=Integer.parseInt(varElementsRatingComm.getText());
				}
				
	
				String strReturn="";
				for (int i=0; i<varDataListComm.size();i++)
				{
					boolean flagLabel=false;

					if (varDataListComm.get(i).split(":")[0].equalsIgnoreCase("Country"))
					{
						
						if (varDataListComm.get(i).split(":")[1].trim().equalsIgnoreCase(varMemberCountryTC))	
						{
							flagCountry=true;
							strReturn="Country Name is same on both the sites. Topcoder: "+varMemberCountryTC+" Community: "+varDataListComm.get(i).split(":")[1];
						}
						else
						{
							flagCountry=false;
							strReturn="Country Name is not same on both the sites. Topcoder: "+varMemberCountryTC+" Community: "+varDataListComm.get(i).split(":")[1];
						}
					}


						

					if (varDataListComm.get(i).split(":")[0].equalsIgnoreCase("Member Since"))
					{
						String varDate=ChangeDateFormatString(varDataListComm.get(i).split(":")[1].trim());
						if (varDate.equalsIgnoreCase(varMemberSinceTC))
						{
							strReturn="Member Since is same on both the sites. Topcoder: "+varMemberSinceTC+" Community: "+varDataListComm.get(i).split(":")[1];
							flagMemberSince=true;
						}
						else
						{
							flagMemberSince=false;
							strReturn="Member Since is not same on both the sites. Topcoder: "+varMemberSinceTC+" Community: "+varDataListComm.get(i).split(":")[1];
						}
					}

					
					if (varDataListComm.get(i).split(":")[0].equalsIgnoreCase("Total Earnings"))
					{
						String varTemp=varDataListComm.get(i).split(":")[1].trim().replaceAll(",","");
						if (varTemp.equalsIgnoreCase(varTotalEarningTC))	
						{
							flagMemberEarning=true;
							strReturn="Total Earnings is same on both the sites. Topcoder: "+varTotalEarningTC+" Community: "+varTemp;
						}
						else
						{
							flagMemberEarning=false;
							strReturn="Total Earnings is not same on both the sites. Topcoder: "+varTotalEarningTC+" Community: "+varTemp;
						}
					}
					
					varResultString=varResultString+strReturn+"\n";


				}
	
	
if 	(flagMemberNm && flagCountry && flagMemberSince && flagMemberEarning)	
	finalResult=true;
else
	finalResult=false;

		TestCase.value.setReason(varResultString);
				

				sfdcPageEvents sfEvents=new sfdcPageEvents(fDriver);
				sfEvents.openUrl(varURL);
			//}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}	
		return finalResult;
	}

	
	protected boolean SelectCommunityTab(String varOptionNm)
	{
		boolean finalResult=false;

		try
		{
			String objMenuOptionsComm=TopcoderMain.readObjectDescription.get("divContestMenu_MemberProfile_Comm").getObjectDescription();
			List <WebElement> varMenuOptions =findElements(objMenuOptionsComm);
			for (WebElement ele : varMenuOptions)
			{
				System.out.println("Tab selected in Community site"+ele.getText());
				String varOptionComm="";
				if (ele.getText().contains("\n"))
				{
					/*			String[] str=ele.getText().split("\\r?\\n");
			varOptionComm=str[0]+" "+str[1];*/
					varOptionComm =     ele.getText().replaceAll("[\\t\\n\\r]+"," ");
				}
				if (ele.getText().equalsIgnoreCase(varOptionNm) || varOptionNm.equalsIgnoreCase(varOptionComm))
				{
					System.out.println(ele.getText());
					ele.click();
					Thread.sleep(1000);

					finalResult=true;
					break;
				}
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		return finalResult;
	}
	
	protected boolean VerifyMemberProfileDetails(String objTable, String ChallengeType, String ChallengeSubType, String MemberName, String Section)///////////  unuseed
	{
		boolean finalResult=false;
		int adjuster=0;
		//ArrayList<String> mylist = new ArrayList<String>();
		//mylist.add(mystring);
		//String aa="cssSelector==#design > table > tbody > {tr:nth-child(1)} > td.colHandle > a";
		String obj=objTable.split("\\{")[0]+(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[0]+(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[1];
				//String oo=(objTable.split("\\{")[1]).split(":nth\\-child\\(1\\)\\}")[0];
				//String oo2=(objTable.split("\\{")[1]).split("\\:nth-child(1)\\}")[0]+(objTable.split("\\{")[1]).split("\\:nth-child(1)\\}")[1];
		
		//String s="#tableView > div > article > div.content > h3 > a";
		List<WebElement> varElements=findElements(obj);
		System.out.println(varElements.size());
		if (varElements.size()==0)
			return false;
		try
		{	
			for (int i=1; i<=varElements.size(); i++)
			{
				String obj1=objTable.split("\\{")[0]+(objTable.split("\\{")[1]).split("1")[0]+Integer.toString(i+adjuster)+")"+(objTable.split("\\{")[1]).split("\\}")[1];
				WebElement ele =findElement(obj1);
				//String varSearchResult=ele.getAttribute("text");
				String varSearchResult=ele.getText();
				System.out.println("Member Selected: "+varSearchResult);
				if (varSearchResult.trim().equalsIgnoreCase(MemberName))
				{
				ele.click();
				Thread.sleep(50000);
				//boolean ratingFound=CompareRating(ChallengeType, MemberName);
				//CompareLHSTable(ChallengeType, MemberName);
				//CompareRHSTable(ChallengeType, MemberName);
				
				}
				String pgTitle=TopcoderMain.readObjectDescription.get("lblMemberNm_ProfilePg").getObjectDescription();
				WebElement ele1=findElement(pgTitle);
				String varPageHeader=ele1.getText();
				System.out.println("Member name on Page  :"+ele1.getText());
				if (!varPageHeader.contains(varSearchResult))
				{
					finalResult=false;
					//System.out.println("fales"+Integer.toString(i));
					TestCase.value.setReason("Member selected : "+varSearchResult+"Member name on Page  : "+varPageHeader);
				}
				fDriver.navigate().back();
				String Field="";
				if (objTable.contains("design"))
					Field="cssSelector==#mainContent > div > div > aside > section > nav > ul > li > a:Design";
				else if (objTable.contains("software"))
					Field="cssSelector==#mainContent > div > div > aside > section > nav > ul > li > a:Develop";
				else if (objTable.contains("algorithum"))
					Field="cssSelector==#mainContent > div > div > aside > section > nav > ul > li > a:Data";
						
						clickAField1(Field);
					
				Thread.sleep(30000);
				
			}
/*				if (varSearchResult.equalsIgnoreCase(varCategory))
				{
					ele.click();
					Thread.sleep(5000);
					finalResult=true;
					break;
				}
			}
			////////////////
			if (!finalResult)
			{
				String str=TopcoderMain.readObjectDescription.get("lnkNext").getObjectDescription();
				str= str+":"+TopcoderMain.readObjectDescription.get("lnkNext").getVisibleText();
				
				if (clickAField1(str))
				{
					if (selectSearchItem(objTable,varItem,j,varCategory))
						finalResult=true;	
						
				}
				else
					TestCase.value.setReason("Searched element "+varCategory+" is not displaying on the page.");
//////////////////////////////////				
			}*/

		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	catch(NoSuchElementException e)
	{
		//e.printStackTrace();
		System.out.println("NoSuchElementException");
	}
	return finalResult;


	}
	
//------------
// TO convert date format from 07.02.2014 to Jul 02, 2014 (here date are in string format) 	

	private String ChangeDateFormatString(String str)
	{
		String strDate="";
				String monthString="";
		String[] s=str.split("\\.");
		int varMonth=Integer.parseInt(s[0]);
		switch (varMonth) 
		{
        case 1:  monthString = "Jan";
                 break;
        case 2:  monthString = "Feb";
                 break;
        case 3:  monthString = "Mar";
                 break;
        case 4:  monthString = "Apr";
                 break;
        case 5:  monthString = "May";
                 break;
        case 6:  monthString = "Jun";
                 break;
        case 7:  monthString = "Jul";
                 break;
        case 8:  monthString = "Aug";
                 break;
        case 9:  monthString = "Sep";
                 break;
        case 10: monthString = "Oct";
                 break;
        case 11: monthString = "Nov";
                 break;
        case 12: monthString = "Dec";
                 break;
        default: monthString = "Invalid month";
                 break;
    }
		strDate=monthString+" "+Integer.toString(Integer.parseInt(s[1]))+", "+s[2];
		
		return strDate;
	}
	
	private String getObjectProperty(String varObjectNm,String PropertyNm)
	{
		String obj=TopcoderMain.readObjectDescription.get(varObjectNm).getObjectDescription();
		WebElement e=findElement(obj);
		//String varPageHeader=e.getAttribute(PropertyNm);
		return (e.getAttribute(PropertyNm));
	}
	protected boolean getCodeFromEmail()
	{
		new GmailPageEvents(fDriver).openEmail("service@topcoder.com", "TopCoder Account Password Reset");
		//new GmailPageEvents(fDriver).openEmail("service@topcoder.com", "User Registration Activation");
		return false;
	}
	protected boolean resetPassword(LoginData loginValues)
	{
		String handle = loginValues.getUserName();
		String newPassword = loginValues.getNewPassword();
		
		WebElement container = findElement(TopcoderMain.readObjectDescription.get("txtHandle").getObjectDescription()) ;
		container.sendKeys(handle);
		container = findElement(TopcoderMain.readObjectDescription.get("btnSubmit").getObjectDescription()) ;
		container.click();
		container = findElement(TopcoderMain.readObjectDescription.get("txtArticle").getObjectDescription()) ;
		
		if(container.getText().contains("User does not exist"))
		{
			TestCase.value.setReason(TestCase.value.getReason()+" User does not exist");
			TestCase.value.setResult("False");
			return false;
			/*fDriver.navigate().back();
			container = findElement(TopcoderMain.readObjectDescription.get("txtHandle").getObjectDescription()) ;
			container.sendKeys(handle);
			container = findElement(TopcoderMain.readObjectDescription.get("lnkSubmit").getObjectDescription()) ;
			container.click();*/
		}
		
		if(container!=null)
		{
		if(container.getText().contains("You have already requested the reset token. Please find it in your email inbox. If it's not there, please contact support@topcoder.com."))
		{
			fDriver.navigate().back();
			findElement("linkText==click here").click();
		}
		else if(container.getText().contains("it seems like"))
		{
			fDriver.navigate().back();
			findElement("linkText==click here").click();
		}
		else if(container.getText().contains("Sit tight! A confirmation code is on its way to your email."))
		{
			TestCase.value.setReason(TestCase.value.getReason()+" A confirmation code is sent to the email id '"+loginValues.getLoginEmail()+"'");
		}
		else if(container.getText().contains("It looks like you have a social account associated with your profile. You can login using your"))
		{
			findElement("linkText==click here").click();
		}
		}
		String unlockCode = new GmailPageEvents(fDriver).getRestTokenInMail(loginValues.getLoginEmail(),loginValues.getEmailPassword());
			/*container = findElement(TopcoderMain.readObjectDescription.get("txtHandle").getObjectDescription()) ;
			container.sendKeys(handle);
			container = findElement(TopcoderMain.readObjectDescription.get("txtPassword").getObjectDescription()) ;
			container.sendKeys(newPassword);
			container = findElement(TopcoderMain.readObjectDescription.get("txtConfirmPassword").getObjectDescription()) ;
			container.sendKeys(newPassword);
			container = findElement(TopcoderMain.readObjectDescription.get("txtHandle").getObjectDescription()) ;
			if(container.getText().contains("Password confirmation different from above field"))
			{
				container = findElement(TopcoderMain.readObjectDescription.get("txtPassword").getObjectDescription()) ;
				container.clear();
				container.sendKeys(newPassword);
				container = findElement(TopcoderMain.readObjectDescription.get("txtConfirmPassword").getObjectDescription()) ;
				container.clear();
				container.sendKeys(newPassword);
			}
			container = findElement(TopcoderMain.readObjectDescription.get("txtUnlockCode").getObjectDescription()) ;
			container.sendKeys(unlockCode);
		}
		else if(container.getText().contains("You have already requested the reset token. Please find it in your email inbox. If it's not there, please contact support@topcoder.com."))
		{
			fDriver.navigate().back();
			findElement("linkText==click here").click();*/
			container = findElement(TopcoderMain.readObjectDescription.get("txtHandle").getObjectDescription()) ;
			container.sendKeys(handle);
			container = findElement(TopcoderMain.readObjectDescription.get("txtPassword").getObjectDescription()) ;
			container.sendKeys(newPassword);
			container = findElement(TopcoderMain.readObjectDescription.get("txtConfirmPassword").getObjectDescription()) ;
			container.sendKeys(newPassword);
			container = findElement(TopcoderMain.readObjectDescription.get("txtHandle").getObjectDescription()) ;
			if(container.getText().contains("Password confirmation different from above field"))
			{
				container = findElement(TopcoderMain.readObjectDescription.get("txtPassword").getObjectDescription()) ;
				container.clear();
				container.sendKeys(newPassword);
				container = findElement(TopcoderMain.readObjectDescription.get("txtConfirmPassword").getObjectDescription()) ;
				container.clear();
				container.sendKeys(newPassword);
			}
			container = findElement(TopcoderMain.readObjectDescription.get("txtUnlockCode").getObjectDescription()) ;
			container.sendKeys(unlockCode);
		//}
		clickAField(TopcoderMain.readObjectDescription.get("btnSubmit").getObjectDescription());
		container = findElement(TopcoderMain.readObjectDescription.get("secPwdRecovery").getObjectDescription()) ;
		if(container.getText().contains("Your password has been reset!"))
		{
			TestCase.value.setReason(TestCase.value.getReason()+" Password reset successful.");
			TestCase.value.setResult("True");
			return true;
		}
		else
		{
			TestCase.value.setReason(TestCase.value.getReason()+" Unable to reset password. Please have a look.");
			TestCase.value.setResult("False");
			return false;
		}
		//return true;
	}

	protected boolean ExecuteAPI(String APIUrl)
    {
            
            sfdcPageEvents sfEvents=new sfdcPageEvents(fDriver);
            sfEvents.openUrl(APIUrl);
            String bodyText = findElement("tagname==body").getText();
            System.out.println(bodyText);
            String[] data= bodyText.split(",");
            for (String str : data) 
            {
                    if(str.contains("memberCount"))
                    {
                            memberCount=str.split(":")[1];
                            System.out.println(memberCount);
                    }
                    if(str.contains("prizePurse"))
                    {
                            prizePurse=str.split(":")[1];
                            System.out.println(prizePurse);
                    }
                    if(str.contains("activeContestsCount"))
                    {
                            activeChallenges=str.split(":")[1];
                            System.out.println(activeChallenges);
                    }
                    if(str.contains("activeMembersCount"))
                    {
                            competingToday=str.split(":")[1];
                            System.out.println(competingToday);
                    }
                    
            }
            if(memberCount!="" && prizePurse!="" && activeChallenges!="" && competingToday!="")
                    return true;
            return false;
    }
	protected boolean enterDate(String dateType, String date) 
	{
		WebElement dateBox = findElement(dateType) ;
		if(dateBox.isDisplayed())
		{
		dateBox.click();
		dateBox = findElement(TopcoderMain.readObjectDescription.get("divCalendar").getObjectDescription());
		List<WebElement> tblRows= dateBox.findElement(By.tagName("table")).findElements(By.tagName("tr"));
		//System.out.println(tblRows.size());
		for (WebElement row : tblRows) 
		{
			//System.out.println(row.getText());
			if(row.getText().contains(date))
			{
				List<WebElement> tblCols=row.findElements(By.tagName("td"));
				for (WebElement column : tblCols) 
				{
					if(column.getText().equalsIgnoreCase(date))
					{
						GeneralUtility.sleep(5000);
						//System.out.println(column.getText());
						column.click();
						return true;
					}
				}
				//break;
			}
		}
		}
		else
		{
			TestCase.value.setReason(TestCase.value.getReason()+" Element not visible/available.");
			TestCase.value.setResult("False");
			return false;
		}
		return false;
		
		
	}
	protected boolean multiSelectSelectFew(String by, String[] platformSet) {
    	WebElement MultiSelectElement = findElement(by);
    	boolean flagFound=false;
    	//System.out.println(findElements(by).size());
    	if(MultiSelectElement.isDisplayed())
    	{
    	Select MultiSelectSelectionBox = new Select(MultiSelectElement);
    	List<WebElement> options = MultiSelectSelectionBox.getOptions();
    	MultiSelectSelectionBox.deselectAll();
    	
    	for(String platformName : platformSet)
    	{
    		flagFound=false;
	    	for (WebElement webElement : options) 
	    	{
	    		String webElementText= webElement.getAttribute("text");
	    		//System.out.println(webElementText);
	    		if(webElementText.equalsIgnoreCase(platformName))
	    		{
	    			flagFound=true;
	    			webElement.click();
	    			break;
	    		}
	    		else
	    		{
	    			flagFound=false;
	    		}
	    		
			}
	    	if(!flagFound)
    		{
    			System.out.println(platformName+" platform not available in the list");
    		}
    	}
    	if(by.contains("Platforms"))
    		findElement(TopcoderMain.readObjectDescription.get("imgAddPlatforms").getObjectDescription()).click();
    	else if(by.contains("Technologies"))
    		findElement(TopcoderMain.readObjectDescription.get("imgAddTechnologies").getObjectDescription()).click();
    		
    	}
    	else
    	{
    		TestCase.value.setReason(TestCase.value.getReason()+" Element not visible/available.");
			TestCase.value.setResult("False");
			return false;
    	}
    	return flagFound;
    	
	}
	
	protected boolean selectCheckboxes(String container, String[] checkboxLabels) 
	{
		GeneralUtility.sleep(7000);
		WebElement div=findElement(container);
		List<WebElement> listDiv=div.findElements(By.tagName("label"));
		for (String chkText : checkboxLabels) 
		{
			for (WebElement label : listDiv) 
			{
					if(label.getText().equalsIgnoreCase(chkText))
					{
						sfdcPageEvents.GetParent(label).findElement(By.tagName("input")).click();
						break;
					}
			}
		}
		return true;
	}
	protected boolean verifyUserDetails(LoginData userRegisterData) 
	{
		GeneralUtility.sleep(7000);
		WebElement registerEle=null;
		registerEle = findElement(TopcoderMain.readObjectDescription.get("spanSocialUnavailable").getObjectDescription());
		if(registerEle!=null && registerEle.getText().contains("Social profile already in use. Please use another profile or register below"))
		{
			TestCase.value.setReason(TestCase.value.getReason()+" Social profile already in use. Please use another profile or register below");
			TestCase.value.setResult("False");
			return false;
		}
		else
		{
		registerEle = findElement(TopcoderMain.readObjectDescription.get("txtRegisterFirstName").getObjectDescription());
		boolean error = false;
		if(registerEle.getAttribute("value").equals(""))
		{
			registerEle.sendKeys(userRegisterData.getFirstName());
		}
		else if(registerEle.getAttribute("value").equalsIgnoreCase(userRegisterData.getFirstName()))
		{
			TestCase.value.setReason(TestCase.value.getReason()+" First name is correct.");
			TestCase.value.setResult("True");
		}
		
		registerEle = findElement(TopcoderMain.readObjectDescription.get("txtRegisterLastName").getObjectDescription());
		if(registerEle.getAttribute("value").equals(""))
		{
			registerEle.sendKeys(userRegisterData.getLastName());
		}
		else if(registerEle.getAttribute("value").equalsIgnoreCase(userRegisterData.getLastName()))
		{
			TestCase.value.setReason(TestCase.value.getReason()+" Last name is correct.");
			TestCase.value.setResult("True");
		}
		
		registerEle = findElement(TopcoderMain.readObjectDescription.get("txtRegisterUserName").getObjectDescription());
		List<WebElement> spans= findElement("cssSelector==form#registerForm.register").findElements(By.tagName("span"));
		for (WebElement span : spans) 
		{
			if(span.isDisplayed())
			{
				if(span.getText().contains("Username already exists or is invalid"))
				{
					error=true;
					break;
				}
			}
			else
				continue;
			
		}
		if(registerEle.getAttribute("value").equals("") || error)
		{
			registerEle.clear();
			registerEle.sendKeys(userRegisterData.getUserName());
		}
		else if(registerEle.getAttribute("value").equalsIgnoreCase(userRegisterData.getUserName()))
		{
			TestCase.value.setReason(TestCase.value.getReason()+" User name is correct.");
			TestCase.value.setResult("True");
		}
		error = false;
		registerEle = findElement(TopcoderMain.readObjectDescription.get("txtRegisterEmail").getObjectDescription());
		System.out.println("userRegisterData.getLoginEmail()="+userRegisterData.getLoginEmail());
		System.out.println("registerEle.getAttribute('value')="+registerEle.getAttribute("value"));
		if(registerEle.getAttribute("value").equals("") || !registerEle.getAttribute("value").equalsIgnoreCase(userRegisterData.getLoginEmail()))
		{
			registerEle.clear();
			registerEle.sendKeys(userRegisterData.getLoginEmail());
		}
		else if(registerEle.getAttribute("value").equalsIgnoreCase(userRegisterData.getLoginEmail()))
		{
			TestCase.value.setReason(TestCase.value.getReason()+" Email is correct.");
			TestCase.value.setResult("True");
		}
		System.out.println(userRegisterData.getCountry());
		registerEle = findElement(TopcoderMain.readObjectDescription.get("selRegisterCountry").getObjectDescription());
		GeneralUtility.selectValueInDropDown(registerEle, userRegisterData.getCountry(), fDriver);
		return true;
		}
	}
	protected boolean verifySorting(String Field, String colName) 
	{
		sortByColumn(Field, colName);
		int cnt=0;
		WebElement viewLink = findElement(TopcoderMain.readObjectDescription.get("lnkViewAll").getObjectDescription());
		if(viewLink==null || !viewLink.isDisplayed())
		{
			TestCase.value.setReason(TestCase.value.getReason()+" 'View All' link is not visible when challenges are sorted by '"+colName+"'");
			List<WebElement> divList=fDriver.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRow").getObjectDescription().split("==")[1]));
			//System.out.println(divList.size());
			List<WebElement> challengeNames=null;
			List<String> challengeNamesList= new ArrayList<String>();
		//	while(cnt<divList.size())
			//{
				WebElement ele = divList.get(cnt);
				challengeNames= ele.findElements(By.xpath("//div[contains(@class,'colCh ng-scope')]"));
				//cnt++;
				//ele.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRegistrationDate").getObjectDescription().split("==")[1]));
				//System.out.println("registrationDate="+challengeNames.size());
				for (WebElement challenge : challengeNames) 
				{
					//System.out.println(challenge.findElement(By.tagName("span")).getText());
					challengeNamesList.add(challenge.findElement(By.tagName("span")).getText());
				}
				//divList=fDriver.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRow").getObjectDescription().split("==")[1]));
			//}
		/*	for (WebElement ele : divList) 
			//for (int cnt=0;cnt<divList.size();cnt++) 
			{
				//registrationDate= ele.findElements(By.cssSelector("div > div.ngCell.challengeCell.col3.colt3 > div > div > div:nth-child(4) > div"));
				challengeNames= ele.findElements(By.xpath("//div[contains(@class,'ngCell  challengeCell')]"));
						//findElement("cssSelector=#tableView > div > div.ngViewport.ng-scope > div > div:nth-child("+cnt+") > div > div.ngCell.challengeCell.col3.colt3 > div > div > div:nth-child(4) > div");
				cnt++;
				//ele.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRegistrationDate").getObjectDescription().split("==")[1]));
				//System.out.println("registrationDate="+challengeNames.size());
				for (WebElement challenge : challengeNames) 
				{
					System.out.println(challenge.findElement(By.tagName("span")).getText());
					challengeNamesList.add(challenge.findElement(By.tagName("span")).getText());
				}
			}*/
				if(GeneralUtility.isSorted(challengeNamesList))
				{
					TestCase.value.setReason(TestCase.value.getReason()+" "+colName+" are sorted in correct order.");
					TestCase.value.setResult("True");
					return true;
				}
				else
					return false;
			//return GeneralUtility.isSorted(challengeNamesList);
			//return true;
		}
		else
		{
			TestCase.value.setReason(TestCase.value.getReason()+" 'View All' link is visible when challenges are sorted by '"+colName+"'");
			return false;
		}	 
		
	}
	
	protected boolean selectChallenge(String ChallengeNm)
	{
		boolean flagFound=false;
		try
		{

			do
			{

			List<WebElement> divList=fDriver.findElements(By.xpath(TopcoderMain.readObjectDescription.get("divChallengeRow").getObjectDescription().split("==")[1]));
			System.out.println(divList.size());

			for (WebElement ele : divList) 

			{
				WebElement eleChallengeNm=ele.findElement(By.cssSelector("div>div.colCh.ng-scope>div>a>span"));
				String varChallengeNm= eleChallengeNm.getText();
				if (varChallengeNm.trim().equalsIgnoreCase(ChallengeNm))
				{
					eleChallengeNm.click();
					TestCase.value.setReason("Challenge : "+ChallengeNm+" found.");
					flagFound=true;
					Thread.sleep(5000);
					break;
					//return true;
					
				}
			}
			List<WebElement> NextBtns=findElements(TopcoderMain.readObjectDescription.get("lnkNext_Challenge").getObjectDescription());
			if (!flagFound)
			{
				if (NextBtns.size()>0)
					NextBtns.get(0).click();
				else
				{
					TestCase.value.setReason("Challenge : "+ChallengeNm+" not found.");
				break;
				}
				
			}

			
			}
			while (!flagFound);
		}
		
		catch(NullPointerException e )
		{
			TestCase.value.setReason("Element not found");
			System.out.println( e.getMessage());
		}
		catch(InterruptedException  e )
		{
			System.out.println( e.getMessage());
		}
		//TestCase.value.setReason("No open challenge available.");
		return flagFound;

	}
	
	
	protected boolean verifyChallengeButtons(String BtnNm, String BtnState) 
	{

		String varBtnState="";
		if (BtnState.trim()!="")
		{
			if (BtnState.equalsIgnoreCase("disabled"))
				varBtnState="disabled";
			else if (BtnState.equalsIgnoreCase("enabled"))
				varBtnState="disabledNOT";
		}
		
		List<WebElement> varElements=findElements(TopcoderMain.readObjectDescription.get("divChallengeLeftBtns").getObjectDescription());
		//String s="#tableView > div > article > div.content > h3 > a";
		//String obj=TopcoderMain.readObjectDescription.get("divReplyPost_Footer").getObjectDescription();
		//List <WebElement> varElements=findElement(obj).findElements(By.tagName("a"));
		System.out.println(varElements.size());
		/*		try
		{	*/
		if (varElements.size()>0)
		{
			for (WebElement ele : varElements)
			{

				if (ele.isDisplayed())
				{
					System.out.println(ele.getText());
					System.out.println(ele.getText().length());
					System.out.println("REGISTER FOR THIS CHALLENGE".length());
					String str= ele.getText().replaceAll("[^A-Z\\s]","");  //to remove special characters and numbers
					if (str.trim().equalsIgnoreCase(BtnNm))
					{
						String strClass=ele.getAttribute("class").split(" ")[ele.getAttribute("class").split(" ").length-1];
						System.out.println("strClass"+strClass);
						if (strClass.equalsIgnoreCase(varBtnState))
						{
							TestCase.value.setReason("Button : "+ele.getText()+" is displaying on the page with :"+BtnState+" state.");
							return true;
						}
						else 
						{
							if (BtnState.equalsIgnoreCase("disabled"))
								BtnState="enabled";
							else if (BtnState.equalsIgnoreCase("enabled"))
								BtnState="disabled";
							
							TestCase.value.setReason("Button : "+ele.getText()+" is displaying on the page with :"+BtnState+" state.");
							return false;
						}
					
							
					}
	}
				

/*				System.out.println("element get text"+ele.getAttribute("ng-show"));
				System.out.println("element get text"+ele.getText());
				System.out.println("element get tBuext"+ele.isDisplayed());
				System.out.println("element get text"+ele.isEnabled());
				System.out.println("element get text"+ele.toString());*/
			}
		}

		TestCase.value.setReason("Button : "+BtnNm+" is not displaying on the page.");
		return false;

	}	
	protected boolean completeRegistrationFromMail(LoginData loginData) 
	{
		String url = new GmailPageEvents(fDriver).clickOnLinkInMail(loginData);
		WebElement verifyDiv = findElement(TopcoderMain.readObjectDescription.get("divRegisterComplete").getObjectDescription());
		System.out.println(verifyDiv.getText());
		if(verifyDiv.getText().contains("Registration Complete!"))
		{
			TestCase.value.setReason(TestCase.value.getReason()+"Registration complete.");
			return true;
		}
		else
			return false;
		
	}
	
	protected boolean VerifyChSubmissionDt(String ChllengeRegistrants, LoginData loginValues)
	{
		try
		{
			String varRegistrant="";
			Date currentDate= null;
			int cnt=0;
			List <WebElement> divList=findElements(ChllengeRegistrants);

			if(divList.size()>=1)
			{
				for (WebElement ele : divList) 
				{
					if(ele.isDisplayed())
					{
						varRegistrant=ele.findElement(By.cssSelector("td>span>a")).getText();
						if (varRegistrant.trim().equalsIgnoreCase(loginValues.getUserName()))
						{

							String strchallengeSubmissionrDate=ele.findElement(By.cssSelector("td.subDateColumn")).getText();
							if (!strchallengeSubmissionrDate.equalsIgnoreCase("--"))
							{

								currentDate= GeneralUtility.getCurrentDateInATimezone("IST", "MMM dd, yyyy HH:mm z");
								System.out.println("currentDate="+currentDate);
								Date challengeSubmissionDate= GeneralUtility.convertStringtoDate(strchallengeSubmissionrDate, "MMM dd, yyyy HH:mm z","EDT");
								System.out.println("challengeSubmissionDate="+challengeSubmissionDate);
								int dateDiff=  challengeSubmissionDate.compareTo(currentDate);
								System.out.println("dateDiff="+dateDiff);
								if(dateDiff>=0 && dateDiff<=1)
								{
									System.out.println("Submission date is updated: "+varRegistrant+" as "+challengeSubmissionDate);
									TestCase.value.setReason("Submission date is updated: "+varRegistrant+" as "+challengeSubmissionDate);
									return true;

								}
								else
								{
									TestCase.value.setReason("Submission date is not updated: "+varRegistrant+" as "+strchallengeSubmissionrDate);
									return false;
								}

							}

						}


					}
				}
			}

		}
		catch(NullPointerException e )
		{
			TestCase.value.setReason("Element not found");
			System.out.println( e.getMessage());
		}
		TestCase.value.setReason("User's name is not displaying in the registrants list.");
		return false;

	}


}

