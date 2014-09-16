package com.appirio.automation.General;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appirio.automation.TestcaseFlow.TopCoderActions;
//import com.appirio.automation.CloudSync.CloudSyncMain;
import com.appirio.automation.Topcoder.TopcoderMain;
import com.appirio.automation.General.GeneralUtility;




public class sfdcPageEvents {

	public WebDriver driver;
	int timeOutCounter;
	public int TIMEOUT = 5;
	
	public sfdcPageEvents(WebDriver driver) {
        this.driver = driver;
        //this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

	public long getLoadingTime(String identifier)
	{
		long startTime = System.currentTimeMillis()/1000;  
		long loadTime =0;
		 //System.out.println("The startTime is "+startTime);  
		 //Set the acceptable Page load time to 60 sec  
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);   
		 WebElement search = new TopCoderActions(driver).findElement(identifier);
		 System.out.println((System.currentTimeMillis()/1000)-startTime);
		 //Iterate through the loop as long as time(60sec) is with in the acceptable Page load time  
		 while(((System.currentTimeMillis()/1000)-startTime)<=2)
		 {  
		         if(search.isDisplayed())
		         {  
		  long endTime = System.currentTimeMillis()/1000;  
		 // System.out.println("The endTime is "+endTime);  
		  loadTime = endTime - startTime;  
		  System.out.println("Totaltime: " +loadTime + " seconds");
		  return loadTime;
		      //break;  
		  }    
		   }
		return loadTime;   
	}
    public boolean openUrl(String url){
    	//System.out.println(driver.toString());
    	System.out.println("url="+url);
    	//Thread.sleep(20000);
        driver.get(url);
        //driver.navigate().to("www.topcoder.com");
        //driver.get("www.topcoder.com");
		return true;
    }

    /**
     * asserts page title
     * waits till TIMEOUT for the title to load
     * 
     * @param title
     * @throws AssertionError
     * @throws InterruptedException
     */
    public void assertPageTitleContains(String title) throws AssertionError,InterruptedException{
        if(!driver.getTitle().trim().toLowerCase().contains(title.trim().toLowerCase())){
            //wait for page load
            try{
                 mWait("timed out after "+TIMEOUT+" sec");
                 assertPageTitleContains(title);
            }catch (TimeoutException e) {
                throw new AssertionError("Expected page title to contain : "
                        + title + " , found : " + driver.getTitle());
            }
        }else
            //reset timeoutCounter
            timeOutCounter=0;
    }
    
    /**
     * asserts page title not to contain a string
     * waits till TIMEOUT for title to load
     *
     * @param notInTitle
     * @throws AssertionError
     * @throws InterruptedException
     */
    public void assertPageTitleDoesNotContain(String notInTitle) throws AssertionError,InterruptedException{
        if(driver.getTitle().trim().toLowerCase().contains(notInTitle.trim().toLowerCase())){
            //wait for page load
            try{
                 mWait("timed out after "+TIMEOUT+" sec");
                 assertPageTitleDoesNotContain(notInTitle);
            }catch (TimeoutException e) {
                throw new AssertionError("Expected page title should not contain : "
                        + notInTitle + " , found : " + driver.getTitle());
            }
        }else
            //reset timeoutCounter
            timeOutCounter=0;
    }
    
    /**
     * waits for 1 second.Timeouts if it has already waited
     * TIMEOUT sec. in the calling function, and fails with @timeoutMessage
     * 
     * @param timeoutMessage
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public void mWait(String timeoutMessage) throws TimeoutException,InterruptedException{
            if (timeOutCounter > TIMEOUT) {
                timeOutCounter = 0;
                throw new TimeoutException(timeoutMessage);
            }
            Thread.sleep(1000);
            timeOutCounter++;        
    }
    
    /**
     * finds a WebElement based on By selector.
     * 
     * This method will wait for the element to load and will timeout after the
     * value of TIMEOUT class variable.
     * 
     * use this method instead of driver.findElement(By) to wait for the element
     * to load till TIMEOUT class variable
     * 
     * @param by
     *            - selector
     * @return - WEbElement
     */
    public WebElement findElement1(final By by) throws AssertionError{
    	try{
        WebElement element = (new WebDriverWait(driver, TIMEOUT))
        		              .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(by);
                    }
                });

        return element;
    	}
    	catch(Exception e)
    	{
    		throw new AssertionError(by.toString()+ "-Element not found.");
    	}
    }
    public WebElement findElement(By id) throws AssertionError{
		List<WebElement> eles = driver.findElements(id);
		if (eles.isEmpty())
		{
			try
			{
				mWait("");
				findElement(id);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (TimeoutException e) {
                throw new AssertionError(id.toString()+":Element not found after "+TIMEOUT+" sec");
            }
		}
		return eles.get(0);
	}
    public void clickElement(By by) {
    	findElement(by).click();
    }

    /**
     * clicks the button with the given label.
     * 
     * It waits for the given button to load and timeouts after the value of
     * TIMEOUT class variable
     * 
     * @param btn
     *            - label on button
     * @throws InterruptedException 
     * @throws TimeoutException 
     */
    public void clickBtn(String btn) throws TimeoutException, InterruptedException {
        getBtn(btn).click();
    }

    /**
     * gets the button with the specified label.
     * 
     * It waits for the given button to load and timeouts after the value of
     * TIMEOUT class variable
     * 
     * @param btn
     *            - label on button
     * @return - WebElement : button with the given label
     * @throws InterruptedException 
     * @throws TimeoutException 
     * 
     */
    public WebElement getBtn(String btn) throws TimeoutException, InterruptedException {
        List<WebElement> buttons = driver.findElements(By.className("btn"));
        for (WebElement button : buttons) {
            if (button.getAttribute("value").trim().equalsIgnoreCase(btn.trim())) {
                timeOutCounter = 0;
                return button;
            }
        }

        mWait("TimeOut after waiting " + TIMEOUT
                + " sec. for the button with text " + btn + " to appear");

        return getBtn(btn);

    }

    public void acceptAlert() throws TimeoutException, InterruptedException {
    	try {
            driver.switchTo().alert().accept();
            timeOutCounter = 0;
        } catch (NoAlertPresentException e) {
            mWait("TimeOut after waiting " + TIMEOUT + " sec. for the alert to appear");
            acceptAlert();
        }
    }
    
    /**
     * @throws InterruptedException 
     * perform the log in actions.
     * 
     * @param userName
     * @param password
     * @throws  
     * 
     */
    
   
    public void login(String username, String password)throws AssertionError, InterruptedException
    {
    	try 
		{
			//System.out.println(props.getPropertiesFile().getProperty("URL"));
			//openUrl(props.getPropertiesFile().getProperty("URL"));
			//GeneralUtility.sleep();
			//assertPageTitleContains("Salesforce.com - Customer Secure Login Page");
			WebElement login_page_ctrl=null;
		        
		    //WebElement userNameTxt = driver.findElement(By.name("username"));
		    login_page_ctrl = findElement(By.id("user-signin"));  
		    login_page_ctrl.clear();
		    //login_page_ctrl.sendKeys(props.getPropertiesFile().getProperty("Username"));
		    login_page_ctrl.sendKeys(username);
		    
		    //WebElement passwordTxt = driver.findElement(By.name("pw"));
		    login_page_ctrl = findElement(By.id("pass-signin"));
		    login_page_ctrl.clear();
		    //login_page_ctrl.sendKeys(props.getPropertiesFile().getProperty("Password"));
		    login_page_ctrl.sendKeys(password);
		    
		    //login_page_ctrl = findElement(By.name("Login"));
		    login_page_ctrl = findElement(By.id("signin-button"));
		    login_page_ctrl.click();
		    GeneralUtility.sleep(10000);
		    
		//	assertPageTitleDoesNotContain("Salesforce.com - Customer Secure Login Page");
		//	assertPageTitleContains("Appirio - My Applications");
			GeneralUtility.sleep();
			login_page_ctrl= findElement(By.xpath("//div[@id='app-links']/ul[@id='app-link-list']/li[2]/a"));
			login_page_ctrl.click();
			GeneralUtility.sleep(10000);
			GeneralUtility.switchToWindowUsingTitle(driver, "salesforce.com - Unlimited Edition");
			System.out.println(driver.getTitle());
		}
		catch (AssertionError e) 
		{
			throw new AssertionError("Login Failed");
		} /*catch (InterruptedException e) {
			throw new InterruptedException();
		}*/
    }
    
    /**
     * finds all elements based on By selector
     * It willl wait for the @minimumElements to load which matches selection criteria
     * will timeout after TIMEOUT if it does not find elemnets >= @minimumElements that matches selection criteria
     * 
     * @param by - By Selector
     * @return - list of web elemnts matching criteria
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public List<WebElement> findElements(By by) {
        List<WebElement> elements  = driver.findElements(by);
        return elements;    
    }
    
    /**
     * finds all elements based on By selector
     * It willl wait for the @minimumElements to load which matches selection criteria
     * will timeout after TIMEOUT if it does not find elemnets >= @minimumElements that matches selection criteria
     * 
     * @param by - By Selector
     * @return - list of web elemnts matching criteria
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public List<WebElement> findChildElements(By byChild, By byParent) {
        WebElement ParentElement = findElement(byParent);
    	List<WebElement> elements  = ParentElement.findElements(byChild);
    	return elements;    
    }

    public void selectDropDownItem(By byChild, By byParent, String ItemName) {
    	WebElement ParentElement = findElement(byParent);
    	List<WebElement> elements  = ParentElement.findElements(byChild);
    	for (WebElement CurrentElement : elements) {
			if (CurrentElement.getText().equals(ItemName)) {
				CurrentElement.click();
				return;
			}
		}
    	assertCondition(false, "Drop Down Item Not Found : " + ItemName);
    }
    
    public void multiSelectSelectAll(By by) {
    	WebElement MultiSelectElement = findElement(by);
    	Select MultiSelectSelectionBox = new Select(MultiSelectElement);
    	MultiSelectSelectionBox.deselectAll();
    	List<WebElement> MultiSelectItemsList = MultiSelectSelectionBox.getOptions();
    	for (WebElement CurrentItem : MultiSelectItemsList) {
    		MultiSelectSelectionBox.selectByVisibleText(CurrentItem.getText());
		}
    }
    
    public void selectRadioButton(By by, String option)
    {
    	List<WebElement> RadioButtons= findElements(by);
    	for (WebElement RadioButton:RadioButtons)
    	{
    		String value=RadioButton.getAttribute("value");
    		if (value.equals(option))
    		{
    			RadioButton.click();
    			break;
    		}
    	}
    	
    	
    }
    
    public String selectedOptionInRadioButton(By by)
    {
    	List<WebElement> RadioButtons= findElements(by);
    	for (WebElement RadioButton:RadioButtons)
    	{
    		if (RadioButton.isSelected())
    		{	
    			return RadioButton.getAttribute("value");
    		}
    	}
		return null;
    	
    	
    }
    
    /**
     * quits the test and closes all browser windows
     */
    public void cleanUp() {
        driver.quit();
    }
    
    public void assertCondition(boolean condition,String failureMsg) throws AssertionError{
        if(!condition)
            throw new AssertionError(failureMsg);
    }

  
    public void openTab(String tabName) throws InterruptedException
	{
    	GeneralUtility.sleep(10000);
		WebElement tabBar=findElement(By.id("tabContainer"));
		List<WebElement> tabs=tabBar.findElements(By.tagName("a"));
		for (WebElement tab:tabs)
		{
			String tabText=tab.getText();
		//	System.out.println(tab);
			if (tabText.equals(tabName))
			{
				tab.click();
				break;
				
			}
		}
		GeneralUtility.sleep(TopcoderMain.sleepTime*6);
		WebElement frame=findElement(By.id("itarget"));
		this.driver.switchTo().frame(frame);
	}
    
    public boolean logOut()
    {
    	driver.switchTo().defaultContent();
    	WebElement userNavArrow=findElement(By.id("userNav-arrow"));
    	userNavArrow.click();
    	List<WebElement> menuLinks=findChildElements(By.cssSelector("a.menuButtonMenuLink"), By.id("userNav-menuItems"));
    	for (WebElement menuLink:menuLinks)
    	{
    		String title=menuLink.getAttribute("title");
    		if (title.equalsIgnoreCase("Logout"))
    		{
    			menuLink.click();
    			GeneralUtility.sleep();
    			return true;
    		}
    	}		
    	GeneralUtility.sleep();
    	return false;
    }
    public static WebElement GetParent(WebElement e)
    {
       return e.findElement(By.xpath(".."));
    }
}
