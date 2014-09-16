package com.appirio.automation.General;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtility {
	//--------------------------------------------------------------------------
		/**
		 * Forces the thread to sleep for time specified in the variable - Global_Settings.sleep_ms
		 */		
	public static void sleep() {
	    	try {
				Thread.sleep(10000);
			} 
	    	catch(Exception e) {
				e.printStackTrace();
			}
	    }

		public static void sleep(int sleeptime) {
			try {
				Thread.sleep(sleeptime);
			} 
	    	catch(Exception e) {
				e.printStackTrace();
			}
		}
		public static void TakeScreenshot(String filePath, WebDriver driver) throws FileNotFoundException {
			filePath = filePath + "_" + GenerateDateString() + ".png";
	    	try {
	    		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    		FileUtils.copyFile(screenShot, new File(filePath));
	    	}
	    	catch (IOException e) {
	            throw new FileNotFoundException(
	                    "Error in processing path for image files");
	    	}
	    }
		
		public static boolean switchToWindowUsingTitle(WebDriver driver, String title) 
		{ 
			     
	             String currentWindow = driver.getWindowHandle(); 
	             Set<String> availableWindows = driver.getWindowHandles(); 
	             System.out.println("title="+title);
	             if (!availableWindows.isEmpty())
	             { 
	                 for (String windowId : availableWindows) { 
	                	 System.out.println(driver.switchTo().window(windowId).getTitle());
	                     if (driver.switchTo().window(windowId).getTitle().contains(title)) //(driver.switchTo().window(windowId).getTitle().equals(title))||
	                     { 
	                             return true; 
	                     } else { 
	                             driver.switchTo().window(currentWindow); 
	                     } 
	                 } 
	             } 
	             return false; 
	     } 
		
		
		public static String GenerateDateString() {
			Calendar cal = Calendar.getInstance();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
	    	String dateStr = sdf.format(cal.getTime());
	    	return dateStr;
		}	
		
		public static Date getCurrentDateInATimezone(String timezone, String strFormat)/// Did changes in methods getChallengeTimeLine1() and getOpenChallenge() 09/16 Pradeep
		{
			try {
			// Calendar currentdate = Calendar.getInstance();
			 Date date = new Date();  

			 DateFormat formatter = new SimpleDateFormat(strFormat);
			// System.out.println("The current time in India is  :: " +formatter.format(currentdate.getTime()));
			 // Set the formatter to use a different timezone  
			 formatter.setTimeZone(TimeZone.getTimeZone(timezone));  

			 // Prints the date in the EST timezone  
			 //System.out.println("The current time in EST is  :: "+formatter.format(date));  
			 
				return formatter.parse(formatter.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			   
		       
		}
		
		public static Date convertStringtoDate(String dateInString,String format,String timezone)
		{
			DateFormat formatter = new SimpleDateFormat(format);
			try {
					
				Calendar date = Calendar.getInstance();
				 String strdate = null;
		           // DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		           // strdate = formatter.format(date.getTime());
		            TimeZone obj = TimeZone.getTimeZone(timezone);

		            formatter.setTimeZone(obj);
		            //System.out.println(strdate);
		            //System.out.println(formatter.parse(strdate));
		            Date theResult = formatter.parse(dateInString);
				
					//System.out.println("Date="+formatter.format(theResult));
				//	formatter.setTimeZone(TimeZone.getTimeZone(timezone));  
					//System.out.println(date);
					//System.out.println("Date="+formatter.parse(formatter.format(date)));
					//return formatter.parse(formatter.format(date));
					return formatter.parse(formatter.format(theResult));
					
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return null;
		}
		public static void getCurrentDateInEDTFormat1()
		{
			 try {
					 Date date = new Date();  
	
					 DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
	
					 // Set the formatter to use a different timezone  
					 formatter.setTimeZone(TimeZone.getTimeZone("EST"));  
	
					 // Prints the date in the EST timezone  
					 System.out.println(formatter.format(date));  
			            Calendar currentdate = Calendar.getInstance();
			            String strdate = null;
			           // DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			            strdate = formatter.format(currentdate.getTime());
			            TimeZone obj = TimeZone.getTimeZone("EST");
	
			            formatter.setTimeZone(obj);
			            //System.out.println(strdate);
			            //System.out.println(formatter.parse(strdate));
			            Date theResult = formatter.parse(strdate);
	
			            System.out.println("The current time in India is  :: " +currentdate.getTime());
	
			            System.out.println("The date and time in :: "+ obj.getDisplayName() + "is ::" + theResult);
		        } catch (ParseException e) {
		        e.printStackTrace();
		        }
		       
		}
		
		//Method to remove a character from a string from a particular position in the string
		 public static String removeCharAt(String s, int pos) 
		 {
			 if(pos>=0)
				 return s.substring(0, pos) + s.substring(pos + 1);
			 else
				 return s;
		 }
		
		 public static boolean isSorted(List<String> list)
		 {
		     boolean sorted = true;        
		     for (int i = 1; i < list.size(); i++) 
		     {
		    	 //System.out.println(list.get(i-1).toLowerCase().compareTo(list.get(i).toLowerCase()));
		         if (list.get(i-1).toLowerCase().compareTo(list.get(i).toLowerCase()) > 0) sorted = false;
		     }

		     return sorted;
		 }
		 public static boolean selectValueInDropDown(WebElement selectIdentifier, String fieldValue, WebDriver fdriver)
		 {
			 Select selectCountry= new Select(selectIdentifier);
			 selectCountry.selectByValue(fieldValue);
			 //WebElement select=null;
			// select=fdriver.findElement(selectIdentifier);
			/* List<WebElement> allOptions = selectIdentifier.findElements(By.tagName("option"));
			  for (WebElement option : allOptions)
			  {
				  
			       if(option.getAttribute("text").trim().contains(fieldValue))
			       {
			    	   selectIdentifier.click();
			    	   option.click();
			    	   GeneralUtility.sleep(5000);
			    	   break;
			       }
			       else  if(option.getAttribute("value").trim().contains(fieldValue))
			       {
			    	   option.click();
			    	   GeneralUtility.sleep(5000);
			    	   break;
			       }
			  }*/
			return true;
		 }
		 
		 public static boolean uploadFile(WebDriver driver, String fileToUpload) 
		 {
			 //StringSelection ss= new StringSelection("E:\\file1.zip");
			 StringSelection ss= new StringSelection(fileToUpload);
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

			 Robot r;
				try {	 
				r = new Robot();
				 r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
				 r.keyRelease(KeyEvent.VK_ENTER);
				 r.keyPress(KeyEvent.VK_CONTROL);
				 r.keyPress(KeyEvent.VK_V);
				 r.keyRelease(KeyEvent.VK_V);
				 r.keyRelease(KeyEvent.VK_CONTROL);
				 r.keyPress(KeyEvent.VK_ENTER);
				 r.keyRelease(KeyEvent.VK_ENTER);

				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 return true;
		 }
		
		 
			public static WebDriver closeCurrentBrowserTab(WebDriver driver, String title) 
			{ 
		             String currentWindow = driver.getWindowHandle(); 
			             Set<String> availableWindows = driver.getWindowHandles(); 
			             System.out.println("title="+title);
			             if (!availableWindows.isEmpty())
			             { 
			                 for (String windowId : availableWindows) { 
			                	 System.out.println(driver.switchTo().window(windowId).getTitle());
			                     if (driver.switchTo().window(windowId).getTitle().contains(title)) //(driver.switchTo().window(windowId).getTitle().equals(title))||
			                     { 
			                    	 driver.close();
			                            // return true; 
			                    	 break;
			                     } 
			                     //else { 
			                          //   driver.switchTo().window(currentWindow); 
			                   //  } 
			                 }
			                 driver.switchTo().window(currentWindow); 
			             } 
			             return driver; 

		     } 
}
