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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DM_4_Checker {

	
	public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
       // Util ut = new Util();
     //   Xls_Reader  ut = new Xls_Reader ("C:\\Users\\pccenter_nageshbapuS\\Desktop\\Master_File_CA.xlsx");
   	 Xls_Reader_UAT ut =new Xls_Reader_UAT(System.getProperty("user.dir")+"\\Master_File_CA_UAT.xlsx");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

      // driver.get("https://10.150.5.31/dm-web/");
       // driver.get(url);
       String url = ut.getCellData("login", 1, 17);
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
       
       // Util ut = new Util();
    	String user1 = ut.getCellData("login", 0, 5);
    	String passrd = ut.getCellData("login", 1, 5);
    	//String RTA_Code = ut.getDataFromExcel("login", 1, 2);

        
    	 driver.findElement(By.xpath("//input[@name='userID']")).sendKeys(user1);
         
         driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(passrd);
         
       //  driver.findElement(By.xpath("(//input[@class ='textField1'])[3]")).sendKeys(RTA_Code);

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
	   radios.get(1).click();
		
	     WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(20));
	     
	   //  driver.findElement(By.xpath("//*[@id=\"captch-refresh-btn\"]")).click();

//---------------------------------------------------1 approach-----------7
	    // driver.findElement(By.xpath("//*[@id=\"captch-refresh-btn\"]")).click();
	     try{
				driver.findElement(By.id("verificationCode"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", 
						driver.findElement(By.xpath("//img[@src='/dm-web/images/captcha_refresh_icon.gif']")));
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
//     ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//				driver.findElement(By.id("loginButton")));
//			
				//------------------
			
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
		           
				
				for (String handle : driver.getWindowHandles()) {

		            driver.switchTo().window(handle);

		        }


				 WebDriverWait wait1 = new WebDriverWait(driver ,Duration.ofMillis(20));
			     
			 	   WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@accesskey='A'])[1] ")));
			 	   element1.click();
		//driver.findElement(By.xpath("//a[@accesskey ='A']")).click();
			 	   
			 	 ////*[text() ='iew Corporate Action Details']  
			 	   
			 	   
			  WebElement element11 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() ='iew Corporate Action Details'] ")));
			 	  element11.click();
			 	   
			 	  
			 	 int     rowCount= ut.getRowCount("Captured");
			 	for (int rowNum = 3 ; rowNum <= rowCount ;rowNum ++) {
			 	  try {
			 	  
			 	   
//			     String Dm_order = ut.getCellData("Captured", 16, rowNum);
//			     driver.findElement(By.xpath("//input[@name ='orderNum']")).clear();
//			  driver.findElement(By.xpath("//input[@name ='orderNum']")).sendKeys(Dm_order);
			  
//			 	    String ISIN_C1 = ut.getCellData("Captured", 11, rowNum);
//		 	   driver.findElement(By.xpath("//input[@name ='creditISIN']")).clear();
//		 		 driver.findElement(By.xpath("//input[@name ='creditISIN']")).sendKeys(ISIN_C1);
					 WebDriverWait wait001 = new WebDriverWait(driver ,Duration.ofMillis(20));

			 		 WebElement list_11 = wait001.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name ='castatus']")));
		 			
		 			//	 WebElement list_box = driver.findElement(By.xpath(" "));
		                 
		                 Select s10011 = new Select (list_11);
		                 
		                 s10011.selectByVisibleText("Verified & Accepted By NSDL");
		              //input
		                 
		                 driver.findElement(By.xpath("//img[@src ='/dm-web/images/Calendar.gif']")).click();
			               //a[@class ='TESTcpTodayText']
		                
			                 driver.findElement(By.xpath("//a[@class ='TESTcpTodayText']")).click();

					Thread.sleep(1000);
					//----------------------------------------------------------------------------------------------------------------------------------------------
	                 
//	                 String ISIN_C = ut.getCellData("Captured", 11, rowNum);
//	                 
//	                 if (!ISIN_C.isEmpty()) {
//	                	 driver.findElement(By.xpath("//input[@name ='creditISIN']")).clear();
//	                     driver.findElement(By.xpath("//input[@name ='creditISIN']")).sendKeys(ISIN_C);
//	                     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1] "))).click();
//	                 } else {
//	                    
//	                     System.out.println("ISIN Field is empty");
//	                 }  
					
					
					 String indicator = ut.getCellData("Captured", 24, rowNum);
	                 String ISIN_C = ut.getCellData("Captured", 11, rowNum);
	                 if (indicator.equalsIgnoreCase("C")) {
	                    
	                     if (!ISIN_C.isEmpty()) {
	                         driver.findElement(By.xpath("//input[@name ='creditISIN']")).clear();
	                       
	                         driver.findElement(By.xpath("//input[@name ='creditISIN']")).sendKeys(ISIN_C);
	                         wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1] "))).click();
	                     } else {
	                         System.out.println("ISIN Field is empty");
	                     }
	                 } else if (indicator.equalsIgnoreCase("D")) {
	                	 driver.findElement(By.xpath("//input[@name ='debitISIN']")).sendKeys(ISIN_C);
	                	 
                         wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1] "))).click();

	                 } else {
	                     System.out.println("Invalid indicator value in Excel sheet");
	                 }  
//-----------------------------------------------------------------------------------------------------------------------------------------
			 			
			 		 
				//  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1] "))).click();
				 	  
		           //    WebDriverWait wait111 = new WebDriverWait(driver ,Duration.ofMillis(20));

			   	driver.findElement(By.xpath("//input[@name ='selCheckList']")).click();
			   	 	   
			   driver.findElement(By.xpath("(//input[@name ='button'])[2]")).click();
			   
			   try {
             	    driver.switchTo().alert().accept();
             	    
             	} catch (NoAlertPresentException e) {
             	  
             	}
             	 Thread.sleep(500);
             	//driver.switchTo().alert().accept();
             	
             	try {
             	    driver.switchTo().alert().accept();
             	   
             	} catch (NoAlertPresentException e) {
             	   
             	}
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1]"))).click();
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='button']"))).click();
             // String Dm_order1 = ut.getDataFromExcel("Output", 1, 9);

//			 driver.findElement(By.xpath("//input[@name ='orderNum']")).sendKeys(Dm_order1);
//					 		 
//			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1] "))).click();
//						 	  
			    String Dm_order1 = ut.getCellData("Captured", 16, rowNum);
			 //
			 			  driver.findElement(By.xpath("//input[@name ='orderNum']")).sendKeys(Dm_order1);
			 
//			  String ISIN_C11 = ut.getCellData("Captured", 11, rowNum);
////
//	 		 driver.findElement(By.xpath("//input[@name ='creditISIN']")).sendKeys(ISIN_C11);
	 		 
				 WebDriverWait wait0011 = new WebDriverWait(driver ,Duration.ofMillis(20));
		 		 WebElement list_111 = wait0011.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name ='castatus']")));
	 			
	 			//	 WebElement list_box = driver.findElement(By.xpath(" "));
	                 
	                 Select s100111 = new Select (list_111);
	                 
	                 s100111.selectByVisibleText("Released & Accepted By NSDL");
	              //input
	                 
	                 driver.findElement(By.xpath("//img[@src ='/dm-web/images/Calendar.gif']")).click();
		               //a[@class ='TESTcpTodayText']
		                 Thread.sleep(1000);
		                 driver.findElement(By.xpath("//a[@class ='TESTcpTodayText']")).click();
	//----------------------------------------------------------------------------------------------------------------------------------------------
		                 
//		                 String ISIN_C1 = ut.getCellData("Captured", 11, rowNum);
//		                 
//		                 if (!ISIN_C1.isEmpty()) {
//		                	   driver.findElement(By.xpath("//input[@name ='creditISIN']")).clear();
//		                     driver.findElement(By.xpath("//input[@name ='creditISIN']")).sendKeys(ISIN_C1);
//		                     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1] "))).click();
//		                 } else {
//		                    
//		                     System.out.println("ISIN Field is empty");
//		                 }  
		                 
		                 
		                 String indicator1 = ut.getCellData("Captured", 24, rowNum);
		                 String ISIN_C1 = ut.getCellData("Captured", 11, rowNum);
		                 if (indicator1.equalsIgnoreCase("C")) {
		                    
		                     if (!ISIN_C1.isEmpty()) {
		                         driver.findElement(By.xpath("//input[@name ='creditISIN']")).clear();
		                       
		                         driver.findElement(By.xpath("//input[@name ='creditISIN']")).sendKeys(ISIN_C1);
		                         wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1] "))).click();
		                     } else {
		                         System.out.println("ISIN Field is empty");
		                     }
		                 } else if (indicator1.equalsIgnoreCase("D")) {
		                	 driver.findElement(By.xpath("//input[@name ='debitISIN']")).sendKeys(ISIN_C1);
		                	 
	                         wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1] "))).click();

		                 } else {
		                     System.out.println("Invalid indicator value in Excel sheet");
		                 }  
//-----------------------------------------------------------------------------------------------------------------------------------------
				 	
		                 
		                 
		                 
		                 
		                 
		                // (//input[@name ='button'])[1]
		    			//32 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name ='button'])[1]"))).click();

			 driver.findElement(By.xpath("//input[@name ='selCheckList']")).click();
						   	 	   
			driver.findElement(By.xpath("(//input[@name ='button'])[3]")).click();
				             	//input[@name ='button']
			try {
          	    driver.switchTo().alert().accept();
          	    
          	} catch (NoAlertPresentException e) {
          	  
          	}
          	 Thread.sleep(500);
          	//driver.switchTo().alert().accept();
          	
          	try {
          	    driver.switchTo().alert().accept();
          	   
          	} catch (NoAlertPresentException e) {
          	   
          	}
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name ='button']"))).click();
			//input[@name ='button']
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name ='button']"))).click();
			 		} catch (Exception e) {
		                   
	                    continue;
	                }

}}}
