package com.appirio.automation.Topcoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


import com.appirio.automation.General.GeneralUtility;
import com.appirio.automation.General.LoggerHtmlFormatter;
import com.appirio.automation.General.ReadTestCase;
import com.appirio.automation.General.ReadTopcoderTestSuite;

import com.appirio.automation.General.ReadObjectDescription;
import com.appirio.automation.General.sfdcPageEvents;
import com.appirio.automation.TestcaseFlow.TestCase;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.biff.RowsExceededException;



public class TopcoderMain {
	static WebDriver fDriver;
	public static String userName;
	public static String password;
	public static String URL;
	static String browser;
	public static String fileName;
	public static String tabName;
	//public static List<RecordToCreate> recordToCreate;
	public static List<ReadTopcoderTestSuite> readTopcoderTestSuite;
	public static Map<String,ReadTestCase> recordValues; 
	public static Map<String, ReadObjectDescription> readObjectDescription;
	//private Map<String,ReadTestCase> recordValues;
	public static int counter = 0;
	public static int sleepTime=0;
	//public static boolean gmailLogin=false;
	//public static String adminSecurityToken;
	//**/////////1
	public static void main(String[] args) 
	{
		long lStartTime = new Date().getTime();
		String LogHtmlFilepath = "logs\\test_suite_log_" + GeneralUtility.GenerateDateString() + ".html";
		String LogTxtFilepath = "logs\\test_suite_log_" + GeneralUtility.GenerateDateString() + ".txt";
		//sfdcPageEvents sfEvents;
		Logger logger = Logger.getLogger("com.appirio.automation.trial");
		try {
			// Create a file handler that uses the custom formatter
		    FileHandler fhtml = new FileHandler(LogHtmlFilepath);
		    fhtml.setFormatter(new LoggerHtmlFormatter());
		    logger.addHandler(fhtml);
		    
		    FileHandler ftxt = new FileHandler(LogTxtFilepath);
		    ftxt.setFormatter(new SimpleFormatter());
		    logger.addHandler(ftxt);
		}catch(IOException e){}
		
		logger.setLevel(Level.ALL);
		Properties props= new Properties();
		//	props.load(new FileInputStream("Resources\\filename.properties"));
		if (args.length>0)
			fileName=args[0];
		else
		{
			System.out.println("Please provide the input spreadsheet");
			System.exit(0);
		}
		
		/*catch (IOException e)
		{
			System.out.println("File containing the name of the spreadsheet to be used is not found." +
					" Please make sure that filename.properties exits in Resources folder.\n" +
					"Format of the file \n \t filename=<name_of_spreadsheet> ");
			e.printStackTrace();
			System.exit(0);
		}*/
		try
		{
			Workbook book= null;
			try {
				book = Workbook.getWorkbook(new File(fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}			
			Sheet sheet_summary = book.getSheet("Test Suite");
			URL=sheet_summary.getCell(1,1).getContents();
			userName=sheet_summary.getCell(4,1).getContents();
			password=sheet_summary.getCell(4,2).getContents();
			browser=sheet_summary.getCell(1,2).getContents();
			String sleepTimeString=sheet_summary.getCell(1,4).getContents();
			sleepTime=(sleepTimeString.equals(""))? 5000:Integer.parseInt(sleepTimeString);
			String webdriver_chrome_driver= "drivers\\chromedriver.exe";
			String webdriver_ie_driver="drivers\\IEDriverServer.exe";
			
			if (browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",webdriver_chrome_driver);
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                   ChromeOptions options = new ChromeOptions();
                   options.addArguments("test-type");
                   capabilities.setCapability("chrome.binary",webdriver_chrome_driver);
                   capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                   fDriver = new ChromeDriver(capabilities);
			}
			else if  (browser.equalsIgnoreCase("firefox"))
			{
				fDriver=new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver",webdriver_ie_driver);
				fDriver= new InternetExplorerDriver();
			}
			else if (browser.equalsIgnoreCase("Safari"))
			{
				//System.setProperty("webdriver.ie.driver",webdriver_ie_driver);
				fDriver= new SafariDriver();
			}
			
			fDriver.manage().window().maximize();
			
			readObjectDescription=ReadObjectDescription.readData(fileName);
			sfdcPageEvents sfEvents=new sfdcPageEvents(fDriver);
			readTopcoderTestSuite=ReadTopcoderTestSuite.readData(fileName);
			
			
			try 
			{
				sfEvents.openUrl(URL);

				/*if (!userName.trim().equalsIgnoreCase(""))
				{
					System.out.println("Multiple link exist on the page named \"Log In\"");
				List<WebElement> w=fDriver.findElements(By.linkText("Log In"));
				if (w.size()==1)
				{
					w.get(0).click();
					sfEvents.login_old(userName, password);
					Thread.sleep(20000);
					System.out.println(fDriver.findElement(By.cssSelector("a.btn.btnAlt.btnMyAcc")).toString());
					fDriver.findElement(By.cssSelector("a.btn.btnAlt.btnMyAcc")).click();
				}
				else
					System.out.println("Multiple link exist on the page named \"Log In\"");
				
				}*/
				try {
					Thread.sleep(20000);
 					//sfEvents.assertPageTitleContains("SalesForce");
				}
				catch (AssertionError e) {
					throw new AssertionError(e.getMessage() +"\nLogin Failed");
				}
				//ContactSync contactSync=new ContactSync(fDriver);
				TestCase testCase = new TestCase(fDriver);
				for (ReadTopcoderTestSuite rec:readTopcoderTestSuite)
				{
					counter++;
					String sheetName=rec.getSheetName();
					String testNo=rec.getTestNo();
					String testName=rec.getTestName();
					 recordValues= rec.getRecordValues();
					//System.out.println(testName);
					if (sheetName=="" || sheetName==null)
						continue;
					else if (!sheetName.trim().equalsIgnoreCase(""))
					{
						//Sheet sheetObject_TestCase = book.getSheet(sheetName);
						//new TestCase(fDriver).runTests(sheetObject_TestCase);
						/*******************************Execute testcases**************************************/
						rec.setOverallResult(testCase.runTests());
					}
					
					
					
				}
				
			}
			catch (AssertionError e)
			{
				logger.severe("Assertion Error : " + e.getMessage());
				GeneralUtility.TakeScreenshot(System.getProperty("user.dir") + "\\files\\image_AssertionError", sfEvents.driver);
				//RecordToCreate.writeData(recordToCreate, "output_CS.xls",fileName);
			}
			finally
			{
				ReadTopcoderTestSuite.writeData(readTopcoderTestSuite, "output_TC.xls",fileName);
				//ReadTopcoderTestSuite.writeTCResults(readTopcoderTestSuite,"output_CS.xls", "testResults.csv");
				fDriver.quit();
			}
		}
		catch (FileNotFoundException e)
		{
			logger.severe("File Not Found Exception : " + e.getMessage());
			e.printStackTrace();
			try {
				ReadTopcoderTestSuite.writeData(readTopcoderTestSuite, "output_TC.xls",fileName);
			} catch (RowsExceededException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		catch (Exception e) {
			logger.severe("Unhandled Exception in Main : " + e.getMessage());
			e.printStackTrace();
			try {
				ReadTopcoderTestSuite.writeData(readTopcoderTestSuite, "output_TC.xls",fileName);
			} catch (RowsExceededException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		
		long lEndTime = new Date().getTime(); //end time		 
	    long difference = lEndTime - lStartTime; //check difference 
	    logger.info("Total Time By Script : " + difference/1000 + " secs");
	}

}

	
	
	
	
	
	
	
	
/*	*//**
	 * @param args
	 *//*
	public static Logger logger;
	public static void main(String[] args) {
		
		String LogHtmlFilepath = "logs\\test_suite_log_" + GeneralUtility.GenerateDateString() + ".html";
		String LogTxtFilepath = "logs\\test_suite_log_" + GeneralUtility.GenerateDateString() + ".txt";
		logger = Logger.getLogger("com.appirio.automation");
		try {
			// Create a file handler that uses the custom formatter
			FileHandler fhtml = new FileHandler(LogHtmlFilepath);
		    fhtml.setFormatter(new LoggerHtmlFormatter());
		    logger.addHandler(fhtml);
		    
		    FileHandler ftxt = new FileHandler(LogTxtFilepath);
		    ftxt.setFormatter(new LoggerTextFormatter());
		    logger.addHandler(ftxt);
		}catch(IOException e){}
		logger.setLevel(Level.ALL);
		try{
			//Chrome settings
			//String webdriver_chrome_driver= "E:\\eclipse-workspace\\drivers\\chromedriver.exe";
			//String webdriver_chrome_driver= "D:\\Project\\chromedriver.exe";
			String webdriver_chrome_driver="drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",webdriver_chrome_driver);
			WebDriver fDriver=new ChromeDriver();
			//Firefox settings
			FirefoxProfile fxProfile = new FirefoxProfile();
            fxProfile.setPreference("browser.download.folderList",2);
            fxProfile.setPreference("browser.download.manager.showWhenStarting",false);
            fxProfile.setPreference("browser.download.dir","E:\\CloudWorks\\Auto_DiaGeo\\Downloads");
            fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","image/jpeg");
            fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.ms-powerpoint");
            WebDriver fDriver = new FirefoxDriver(fxProfile);
			fDriver.manage().window().maximize();
			TopcoderMethods topcoder = new TopcoderMethods(fDriver);
			String fileName="Resources\\CS_Diageo.xls";
			long lStartTime = new Date().getTime();
			//diageo.openUrl("test.salesforce.com");
			//List<TestCaseFlow> data=testCaseFlow.readData(fileName);
			//testCaseFlow.PrintValues(data);
			topcoder.defineTestCaseFlow(fileName);
			long lEndTime = new Date().getTime(); //end time		 
		    long difference = lEndTime - lStartTime; //check difference
		    int sec=(int) difference/1000;
		    int min=sec/60;
		    sec=sec%60;
		    logger.info("Total Time By Script : " + min + " mins "+ sec+" secs");
		}
		catch (AssertionError e)
		{
			logger.severe(e.getMessage());

		}
	}

}*/
