package corporate_Action;



import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import project_no1.Xls_Reader;

public class Verify_2_Release_shr_C {
	
	public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        
    //    Xls_Reader  ut = new Xls_Reader ("C:\\Users\\pccenter_nageshbapuS\\Desktop\\Master_File_CA.xlsx");
        Xls_Reader_UAT ut =new Xls_Reader_UAT(System.getProperty("user.dir")+"\\Master_File_CA_UAT.xlsx");

      //  Util ut = new Util();
    	
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

   //  driver.get("https://10.150.5.37/shr-web/");
        //driver.get("https://10.150.7.28:446/shr-web/");
       // driver.get(url);
       String url = ut.getCellData("login", 1, 11);
//        
       driver.get(url);
       driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
       // driver.navigate().refresh();
        
        
//       Thread.sleep(2000);
//       
     driver.findElement(By.xpath("//BUTTON[@CLASS ='secondary-button small-link']")).click();
//       
      Thread.sleep(2000);
//       
        driver.findElement(By.xpath("//a[@id ='proceed-link']")).click();
//        Thread.sleep(1000);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//				driver.findElement(By.id("loginButton")));
        
//        driver.findElement(By.xpath("(//input[@class ='textField1'])[1]")).sendKeys("nageshm");
//        
//        driver.findElement(By.xpath("(//input[@class ='textField1'])[2]")).sendKeys("tcsnsdl");
//        
//        driver.findElement(By.xpath("(//input[@class ='textField1'])[3]")).sendKeys("IN000018");
//        
       
      //  Util ut = new Util();
    	String username1 = ut.getCellData("login", 0, 3);
    	String password = ut.getCellData("login", 1, 3);
    	String RTA_Code = ut.getCellData("login", 2, 3);

        
    	 driver.findElement(By.xpath("(//input[@class ='textField1'])[1]")).sendKeys(username1);
         
         driver.findElement(By.xpath("(//input[@class ='textField1'])[2]")).sendKeys(password);
         
         driver.findElement(By.xpath("(//input[@class ='textField1'])[3]")).sendKeys(RTA_Code);

        Thread.sleep(2000);
  
   
     
   List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
     
     //-----------------------------------------------------------------------------------------
     
//     WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
//     
//       WebElement radios = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='radio'] ")));
     
   //  radios.get
//	System.out.println("total radio button:"+radios.size());
//	System.out.println(radios.get(1).isEnabled());
//	System.out.println(radios.get(0).isDisplayed());
//		
//		System.out.println(radios.get(2).isSelected());
//		
     Thread.sleep(1000);
     // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   radios.get(2).click();
		
	     WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	     
	   
	     try{
	    	 driver.findElement(By.id("verificationCode"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", 
						driver.findElement(By.xpath("//img[@src='/shr-web/images/captcha_refresh_icon.gif']")));
				driver.findElement(By.id("verificationCode")).sendKeys("");
				String captcha_value = driver.findElement(By.id("verificationCode")).getAttribute("value");
				//System.out.println(captcha_value);
				
				while(true) 
		    	 { 
		    		 captcha_value = driver.findElement(By.id("verificationCode")).getAttribute("value");
		    		 int captcha_value_length = captcha_value.length();
		    		 if(captcha_value_length==6) 
		    		 {
		    			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		    					 driver.findElement(By.id("loginButton")));
		    			 break;
		    		 }
		    	 }
				}catch(Exception captcha) { 
					((JavascriptExecutor) driver).executeScript("arguments[0].click();",
							driver.findElement(By.id("loginButton")));
				}
				
//	     ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//					driver.findElement(By.id("loginButton")));
//		
//		
			
	 	    Thread.sleep(3000);
	 	    
	 	    
	       String windowid = driver.getWindowHandle();
           
           System.out.print(windowid);   //8013855BDFDADC71D3B3BEA4127D93B6
           
           //getWindows
           
           Set<String> windowid1 = driver.getWindowHandles();
           
            Iterator<String> it = windowid1.iterator();
             String parantwindowid = it.next();
           String childwindowid = it.next();
           
           System.out.print("parent window id"   +parantwindowid);
           System.out.print("child window id " +childwindowid);
           
           driver.switchTo().window(childwindowid);
           
           
           WebDriverWait wait1 = new WebDriverWait(driver ,Duration.ofMillis(20));
		     
	 	    WebElement elementC1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@accesskey='A'])[1] ")));
		      
	 	   Actions actions = new Actions(driver);
		     actions.moveToElement(elementC1).build().perform();
		     elementC1.click();
		    
		    
		    WebDriverWait wait11 = new WebDriverWait(driver ,Duration.ofMillis(20));
		     
	 	    WebElement element11 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='orporate Action']")));
	 	   element11.click();
	 	   
	 	  int     rowCount= ut.getRowCount("Captured");
	 		for (int rowNum = 3 ; rowNum <= rowCount ;rowNum ++) {
	 		
	 			try {
//	 			ut.addColumn("Captured", "Status");
//                ut.setCellData("Captured", "Status", rowNum, "Verify release CA");

	 			String instruction = ut.getCellData("Captured", 15, rowNum);

	 	 	   
	 			driver.findElement(By.xpath("//input[@name ='corporateActionNo']")).clear();
       	
       	 		 WebElement name1 = driver.findElement(By.xpath("//input[@name ='corporateActionNo']"));		 	   
               	 	  name1.sendKeys(instruction);
               	 
//               	 	 String isin_crd2 = ut.getCellData("Captured", 11, rowNum);
//               	 	 driver.findElement(By.xpath("//input[@name ='creditIsin']")).clear();
//               			 WebElement name11 = driver.findElement(By.xpath("//input[@name ='creditIsin']"));
//               			 	   
               	//	 name11.sendKeys(isin_crd2);
               			 	  Thread.sleep(1000);
               			 	 WebElement list_bo11 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name ='status']")));
               		 			
               		 			//	 WebElement list_box = driver.findElement(By.xpath(" "));
               		                 
               		                 Select s11 = new Select (list_bo11);
               		                 
               		                 s11.selectByVisibleText("Captured");
               		               //input[@name ='selCheckList']
               		                 
//               		       	 	  String filereference = ut.getCellData("Captured", 10, rowNum);
//               		       	 	 driver.findElement(By.xpath("//input[@name ='rtaIntRefNo']")).clear();

               		               	// driver.findElement(By.xpath("//input[@name ='rtaIntRefNo']")).sendKeys(filereference);

               			 	  
//               			 	 String exe_day = ut.getCellData("Captured", 4,rowNum);
//               			 	String exe_month = ut.getCellData("Captured", 5, rowNum);
//               			 	String exe_year = ut.getCellData("Captured", 6,rowNum);
//               			 	 driver.findElement(By.xpath("//input[@name ='execDate']")).clear();
//               			 	 driver.findElement(By.xpath("//input[@name ='execDate']")).sendKeys(exe_day);
//               			 	driver.findElement(By.xpath(" //input[@name ='execMonth']")).clear();
//               	       	 driver.findElement(By.xpath(" //input[@name ='execMonth']")).sendKeys(exe_month);
//               	       	driver.findElement(By.xpath(" //input[@name ='execYear']")).clear();
//               	       	        	 driver.findElement(By.xpath(" //input[@name ='execYear']")).sendKeys(exe_year);

               	       	       Thread.sleep(2000);
               	       
               	             	WebElement checkbox = driver.findElement(By.xpath("(//input[@name ='button'])[1]"));
               	             	 
               	             	checkbox.click();
                
            
               WebDriverWait wait111 = new WebDriverWait(driver ,Duration.ofMillis(20));
   		     
   	 	    WebElement element111 = wait111.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='chkBox'])[1]")));
   	 	   element111.click();
   	 	   
             	driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();
             	
            //	driver.switchTo().alert().accept();
             	try {
              	    driver.switchTo().alert().accept();
              	   
              	} catch (NoAlertPresentException e) {
              	   
              	} try {
              	    driver.switchTo().alert().accept();
              	    
              	} catch (NoAlertPresentException e) {
              	   
              	}
              	Thread.sleep(500); 
              	 try {
	              	    driver.switchTo().alert().accept();
	              	    
	              	} catch (NoAlertPresentException e) {
	              	   
	              	}
	              		
            	//input[@name ='stampDutyRcvdFlag1']/preceding-sibling::a
            	
            	     		
	 			} catch (Exception e) {
	                   
	                 //   continue;
	                }   	
            
             

}}}
