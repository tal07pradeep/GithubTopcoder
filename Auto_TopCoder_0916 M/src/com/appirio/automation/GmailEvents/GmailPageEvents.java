package com.appirio.automation.GmailEvents;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FlagTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.appirio.automation.DataValues.LoginData;
import com.appirio.automation.General.GeneralUtility;
import com.appirio.automation.General.sfdcPageEvents;



public class GmailPageEvents extends sfdcPageEvents{

   public GmailPageEvents(WebDriver driver) {
		super(driver);
	}



/**
    * waits for the chat to load after Gmail page opens to be sure that the page has loaded completely  
    * @return boolean
    */
    public boolean waitForInboxToLoad()
    {
    
    	WebElement chat= findElement(By.cssSelector("table.vH"));
    	if (chat!=null)
    	{
    		return true;
    	}
    	return false;
    }
    
    
  
    /**
     * perform the log in actions.
     * 
     * @param userName
     * @param password
     * @throws InterruptedException 
     * 
     */
    public void login(String userName, String password) throws InterruptedException
    {
//    	findElement(By.id("gmail-sign-in")).click();
    	//GeneralUtility.sleep();
        WebElement userNameTxt = findElement(By.id("Email"));
        WebElement passwordTxt = findElement(By.id("Passwd"));
        
        userNameTxt.clear();
        userNameTxt.sendKeys(userName);
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        WebElement loginBtn = findElement(By.id("signIn"));
        loginBtn.click();
       // GeneralUtility.sleep();
        //if(LoginAutomateMain.browser.equalsIgnoreCase("chrome"))
        //	findElement(By.id("no-button")).click();
     }
    
    /**
     * Logs the user out of gmail
     */
    public void logOutGmail() {
    	 WebElement logout = findElement(By.cssSelector("span.gbmai"));
    	 logout.click();
    	 this.findElement(By.id("gb_71")).click();
    	 
     }
    
  
    /**
     * Finds email based on From Id and Subject.
     * To find from just one parameter, pass the other as NULL. Example: to find an email from xyz@gmail.com use findEmail("xyz@gmail.com", NULL)
     * 
     * @param id - id from which the email to be searched was sent
     * @param subject - subject of the email to be searched
     * @return the first email that matches the criteria else NULL
     */
    public WebElement findEmail(String id, String subject)
	{
		List<WebElement> table_rows=this.findChildElements(By.tagName("tr"), By.cssSelector("table.F.cf.zt"));
		for(WebElement trElement : table_rows)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            WebElement column5= td_collection.get(4).findElement(By.tagName("span"));
            WebElement column6= td_collection.get(5).findElement(By.tagName("span"));
            if (id==null)
            {
            	if (column6.getText().contains(subject) )
            		return trElement;
            }
            else 
            {
            	if (subject==null)
            	{
            		if (column5.getAttribute("email").equalsIgnoreCase(id))
            				return trElement;
            	}
            	else
            	{
            		if (column5.getAttribute("email").equalsIgnoreCase(id) && column6.getText().contains(subject) )
                       	return trElement;
                }
            }
            
        }
		return null;
	}
    
    public void openEmail(String fromId, String sub){
		
		WebElement email = findEmail(fromId, sub);
		if (email==null)
		{
			throw new AssertionError("Email not found"); 
		}
		email.click();
		//EmailHeader emailHeader=captureEmailHeaderInfo();
		//emailHeader.print();
		try 
		{
			//GeneralUtility.sleep(LoginAutomateMain.sleepTime*12);
			assertPageTitleContains(sub);
			//GeneralUtility.sleep(LoginAutomateMain.sleepTime*6);
		}
		catch (InterruptedException e)
		{
			throw new AssertionError("Email with subject \'"+sub+"\' didnt open properly");
		}
		catch (AssertionError e) {
			throw new AssertionError("Email with subject \'"+sub+"\' didnt open properly");
		}
	}	
    /**
     * capture EmailHeader information of the email that is currently open in the browser
     * @return	EmailHeaader	header information like to, cc, bcc, from, subject etc
     * @see EmailHeader 
     */
    public EmailHeader captureEmailHeaderInfo()
    {
    	EmailHeader email = null;
    	List<WebElement> table_rows=this.findChildElements(By.xpath("tbody/tr"), By.cssSelector("table.cf.gJ"));
    	List<WebElement> row1_cols=table_rows.get(0).findElements(By.xpath("td"));
    	WebElement more= row1_cols.get(3).findElements(By.tagName("div")).get(1);
    	more.click();
    	this.findElement(By.xpath("//*[text()='Show original']")).click();
    	String winHandleBefore = driver.getWindowHandle();
		BufferedReader reader =null;
    	for (String s:driver.getWindowHandles())
    	{
    		System.out.println("s\t"+s);
    		if (!winHandleBefore.equalsIgnoreCase(s))
    		{
    			driver.switchTo().window(s);
    			String temp=this.findElement(By.tagName("html")).getText();
    			String text=temp.replaceAll(" \n ", " ");
    			reader = new BufferedReader(new StringReader(text));
    			driver.close();
       		}
    	}
    	driver.switchTo().window(winHandleBefore);
    	Properties props= new Properties();
    	try {
			props.load(reader);
			String date=props.getProperty("Date");
			String sub=props.getProperty("Subject");
			String to=props.getProperty("To");
			String cc=props.getProperty("Cc");
			String bcc=props.getProperty("Bcc");
			String msgId=props.getProperty("Message-ID");
			String from=props.getProperty("From");
			String replyTo=props.getProperty("Return-Path");
			
			email=new EmailHeader(from, to,cc,bcc, sub,date,msgId,replyTo);
			
		} catch (IOException e) {
			//
		}
    	return email;
  }
    public void backToInbox()
    {
    	driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.lS.T-I-ax7.ar7")).click();
    }
    public void openTab(String tabName)
    {
    	WebElement apps=driver.findElement(By.cssSelector("a.gb_n.gb_d"));
    	apps.click();
    	List<WebElement> appsList=driver.findElement(By.cssSelector("div.gb_o.gb_p")).findElements(By.cssSelector("a.gb_b"));
    	for (WebElement app:appsList)
		{
			if (app.getText().equalsIgnoreCase(tabName))
			{
				app.click();
				return;
			}
		}
    	/*List<WebElement> tabs=driver.findElements(By.cssSelector("li.gbt"));
    		for (WebElement tab:tabs)
    		{
    			WebElement gbts=tab.findElement(By.cssSelector("span.gbts"));
    			if (gbts.getText().equalsIgnoreCase(tabName))
    			{
    				tab.findElement(By.cssSelector("a.gbzt")).click();
    				return;
    			}
    		}
    		*/
    }
    public void clickCalendarButton(String btnName)
    {
    	List<WebElement> gButtons= driver.findElements(By.cssSelector("div.goog-imageless-button-content"));
		for (WebElement gButton:gButtons)
		{
			if (gButton.getText().equalsIgnoreCase(btnName))
			{
				gButton.click();
				break;
			}
		}
    }
    
    public boolean searchEmail(String userName,String password, final String subjectKeyword, final String fromEmail, final String bodySearchText) throws IOException {
        Properties properties = new Properties();
        boolean val = false;
        // server setting
        properties.put("mail.imap.host", "imap.gmail.com");
        properties.put("mail.imap.port", 993);
        // SSL setting
        properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",String.valueOf(993));
        Session session = Session.getDefaultInstance(properties);
        try {
            // connects to the message store
            Store store = session.getStore("imaps");
            store.connect(userName, password);
            System.out.println("Connected to Email server….");
            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);
            //create a search term for all "unseen" messages
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, true);
            //create a search term for all recent messages
            Flags recent = new Flags(Flags.Flag.RECENT);
            FlagTerm recentFlagTerm = new FlagTerm(recent, false);
            SearchTerm searchTerm = new OrTerm(unseenFlagTerm,recentFlagTerm);
            // performs search through the folder
            Message[] foundMessages = folderInbox.search(searchTerm);
            System.out.println("Total Messages Found :"+foundMessages.length);
            for (int i=foundMessages.length-1 ; i>=foundMessages.length-10;i--) 
            {
                    Message message = foundMessages[i];
                    Address[] froms = message.getFrom();
					String email = froms == null ? null : ((InternetAddress)froms[0]).getAddress();
					if(message.getSubject()==null){
					continue;
					}
					Date date = new Date();//Getting Present date from the system
					long diff = date.getTime()-message.getReceivedDate().getTime();//Get The difference between two dates
					long diffMinutes = diff / (60 * 1000) % 60; //Fetching the difference of minute
					// if(diffMinutes>2){
					// diffMinutes=2;
					// }
					System.out.println("Difference in Minutes b/w present time & Email Recieved time :" +diffMinutes);
					try {
					if(message.getSubject().contains(subjectKeyword) &&email.equals(fromEmail) && getText(message).contains(bodySearchText) && diffMinutes<=3){
					String subject = message.getSubject();
					// System.out.println(getText(message));
					System.out.println("Found message #" + i + ": ");
					System.out.println("At "+ i + " :"+ "Subject:"+ subject);
					System.out.println("From: "+ email +" on : "+message.getReceivedDate());
					if(getText(message).contains(bodySearchText)== true){
					System.out.println("Message contains the search text "+bodySearchText);
					val=true;
					}
					else{
					val=false;
					}
					break;
					}
					} catch (NullPointerException expected) {
					// TODO Auto-generated catch block
					expected.printStackTrace();
					}
					System.out.println("Searching.…" +"At "+ i );
					            }
					            // disconnect
					            folderInbox.close(false);
					            store.close();
					        } catch (NoSuchProviderException ex) {
					            System.out.println("No provider.");
					            ex.printStackTrace();
					        } catch (MessagingException ex) {
					            System.out.println("Could not connect to the message store.");
					            ex.printStackTrace();
					        }
					return val;
    }
    private boolean textIsHtml = false;
    /**
* Return the primary text content of the message.
*/
    private String getText(Part p) throws MessagingException,IOException {
        if (p.isMimeType("text/*")) 
        {
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }
        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            Multipart mp = (Multipart)p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart)p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }
        return null;
    }
    
    public String getRestTokenInMail(String userName,String password)
    {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", userName, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] msgArray = inbox.getMessages();
            for (int i = msgArray.length-1; i >=0; i--) 
            {
            	Message msg= msgArray[i];
            //for (Message msg : msgArray) 
          //  {
            	 if (msg.getContent() instanceof String)  
                 {  
                     String body = (String)msg.getContent();
                     System.out.println(body);
                     if(body.contains("Please confirm your email address by clicking this"))
                     {
                    	 System.out.println("Mail found");
                    	 String str1=body.substring(body.indexOf("token"), body.indexOf("to continue"));
                    	 System.out.println(str1);
                    	 System.out.println(str1.split(" ")[1]);
                    	 return str1.split(" ")[1];
                     }
                 }  
                 else if (msg.getContent() instanceof Multipart)  
                 {  
                     Multipart mp = (Multipart)msg.getContent();  
                   
                // Multipart mp = (Multipart) msg.getContent();
                 BodyPart bp = mp.getBodyPart(0);
                 System.out.println("SENT DATE:" + msg.getSentDate());
                 System.out.println("SUBJECT:" + msg.getSubject());
                 System.out.println("CONTENT:" + bp.getContent().toString());
                 
                 if(bp.getContent().toString().contains("We have received a request to recover your password"))
                 {
                	 System.out.println("Mail found");
                	 String str1= bp.getContent().toString().substring(bp.getContent().toString().indexOf("token"), bp.getContent().toString().indexOf("to continue"));
                	 System.out.println(str1);
                	 System.out.println(str1.split(" ")[1]);
                	 return str1.split(" ")[1];
                	// break;
                 }
                 }
			/*	if(msg.getContent().toString().contains("Please confirm your email address by clicking this"))
				{
				
            //Message msg = inbox.getMessage(inbox.getMessageCount()-2);
            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            Object content = msg.getContent();

        	/*
        	 * Using isMimeType to determine the content type avoids
        	 * fetching the actual content data until we need it.
        	 */
        	/*if (msg.isMimeType("text/plain")) {
        	    System.out.println("This is plain text");
        	    //pr("---------------------------");
        	    //if (!showStructure && !saveAttachments)
        		System.out.println((String)msg.getContent());
        	} else if (msg.isMimeType("multipart/*")) {
        	   System.out.println("This is a Multipart");
        	    //pr("---------------------------");
        	    Multipart mp = (Multipart)msg.getContent();
        	   // level++;
        	    int count = mp.getCount();
        	    //for (int i = 0; i < count; i++)
        		//dumpPart(mp.getBodyPart(i));
        	    //level--;
        	} else if (msg.isMimeType("message/rfc822")) {
        	    System.out.println("This is a Nested Message");
        	    //pr("---------------------------");
        	    //level++;
        	    //dumpPart((Part)p.getContent());
        	    //level--;
        	} else {
        	    //if (!showStructure && !saveAttachments) {
        		/*
        		 * If we actually want to see the data, and it's not a
        		 * MIME type we know, fetch it and check its Java type.
        		 
        		Object o = p.getContent();
        		if (o instanceof String) {
        		    pr("This is a string");
        		    pr("---------------------------");
        		    System.out.println((String)o);
        		} else if (o instanceof InputStream) {
        		    pr("This is just an input stream");
        		    pr("---------------------------");
        		    InputStream is = (InputStream)o;
        		    int c;
        		    while ((c = is.read()) != -1)
        			System.out.write(c);
        		} else {
        		    pr("This is an unknown type");
        		    pr("---------------------------");
        		    pr(o.toString());
        		}
        	    } else {
        		// just a separator
        		pr("---------------------------");
        	    }
        	}*/
           
        	}
        	//break;
     
    
        }
            catch (Exception mex) 
            {
            mex.printStackTrace();
        }
		return "";
    }
    public String clickOnLinkInMail(LoginData loginData)
    {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            System.out.println("Gmail username="+loginData.getLoginEmail());
            System.out.println("Pwd="+loginData.getEmailPassword());
            store.connect("imap.gmail.com", loginData.getLoginEmail(), loginData.getEmailPassword());
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] msgArray = inbox.getMessages();
            for (int i = msgArray.length-1; i >=0; i--) 
            {
            	Message msg= msgArray[i];
            //for (Message msg : msgArray) 
          //  {
            	 if (msg.getContent() instanceof String)  
                 {  
                     String body = (String)msg.getContent();
                   // System.out.println(body);
                     if(body.contains("Please confirm your email address by clicking this") && body.contains(loginData.getUserName()))
                     {
                    	 System.out.println("Mail found");
                    	 String str1=body.substring(body.indexOf("clicking this"), body.indexOf("and"));
                    	 System.out.println(str1);
                    	 System.out.println(str1.split(" ")[1]);
                    	 String url=str1.split(" ")[1];
                    	 openUrl(url);
                    	 return url;
                     }
                 }  
                 else if (msg.getContent() instanceof Multipart)  
                 {  
                     Multipart mp = (Multipart)msg.getContent();  
                   
                // Multipart mp = (Multipart) msg.getContent();
                 BodyPart bp = mp.getBodyPart(0);
                 System.out.println("SENT DATE:" + msg.getSentDate());
                 System.out.println("SUBJECT:" + msg.getSubject());
                 System.out.println("CONTENT:" + bp.getContent().toString());
                 
                 String body = bp.getContent().toString();
                // System.out.println(body);
                 if(body.contains("Please confirm your email address by visiting this")  && body.contains(loginData.getUserName()))
                 {
                	 System.out.println("Mail found");
                	 String str1=body.substring(body.indexOf("link:"), body.indexOf("and"));
                	 System.out.println(str1);
                	 System.out.println(str1.split(" ")[1]);
                	 String url=str1.split(" ")[1];
                	 openUrl(url);
                	 return url;
                 }
                 }
			
           
        	}
        	//break;
     
    
        }
            catch (Exception mex) 
            {
            mex.printStackTrace();
        }
		return "";
    }
    
    public void ReadingEmail() {
        
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");
            try {
                Session session = Session.getInstance(props, null);
                Store store = session.getStore();
                store.connect("imap.gmail.com", "nishtha@cloudworks-qa2.com", "appirio123");
                Folder inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_ONLY);
                Message msg = inbox.getMessage(inbox.getMessageCount()-1);
                System.out.println(msg.getContent().toString().split(":"));
                Address[] in = msg.getFrom();
                for (Address address : in) {
                    System.out.println("FROM:" + address.toString());
                }
                Multipart mp = (Multipart) msg.getContent();
                BodyPart bp = mp.getBodyPart(0);
                System.out.println("SENT DATE:" + msg.getSentDate());
                System.out.println("SUBJECT:" + msg.getSubject());
                System.out.println("CONTENT:" + bp.getContent());
            } catch (Exception mex) {
                mex.printStackTrace();
            }
        }
    
}

