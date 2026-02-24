package corporate_Action;





import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Captured_30 {
		//public static void main(String[] args) throws InterruptedException {
			public static void main(String[] args) throws IOException, InterruptedException {
		    //  Xls_Reader  reader = new Xls_Reader ("\\Master_File_CA.xlsx");
				
		 Xls_Reader_UAT reader =new Xls_Reader_UAT(System.getProperty("user.dir")+"\\Master_File_CA_UAT.xlsx");
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");

			/*	String classPackageName = Thread.currentThread().getStackTrace()[1].getClassName();
				String progPath = System.getProperty("user.dir");*/
			//	System.out.print("progPath");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");

	        WebDriver driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //   driver.get("https://10.150.5.37/shr-web/");  
        
    //driver.get("https://10.150.7.28:446/shr-web/");
	        driver.manage().window().fullscreen();
	   String url = reader.getCellData("login", 1, 11);
//	        
	        driver.get(url);
	        driver.manage().window().fullscreen();
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.findElement(By.xpath("//BUTTON[@CLASS ='secondary-button small-link']")).click();
//	       
	      Thread.sleep(2000);
//	       
	        driver.findElement(By.xpath("//a[@id ='proceed-link']")).click();
	        
	        Thread.sleep(2000);
	        
//	     	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//					driver.findElement(By.id("loginButton")));
	     	 
	     	  Thread.sleep(2000);
	       // Util ut = new Util();
	    	String username1 = reader.getCellData("login", 0, 2);
	    	String password = reader.getCellData("login", 1, 2);
	    	String RTA_Code = reader.getCellData("login", 2, 2);

//	    	String username1 = reader.getCellData("login", 1, 2);
//	    	String password = reader.getCellData("login", 2, 2);
//	    	String RTA_Code = reader.getCellData("login", 3, 2);
//	    	
	    	 driver.findElement(By.xpath("(//input[@class ='textField1'])[1]")).sendKeys(username1);
	         
	         driver.findElement(By.xpath("(//input[@class ='textField1'])[2]")).sendKeys(password);
	         
	         driver.findElement(By.xpath("(//input[@class ='textField1'])[3]")).sendKeys(RTA_Code);

	         Thread.sleep(2000);
	         
	         
	         
	         List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
	           
	          
//	      		
	           Thread.sleep(1000);
	           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      	   radios.get(1).click();
	      		
	      	    
	      	     
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
//     	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
//				driver.findElement(By.id("loginButton")));
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
			     
		 	    WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@accesskey='A'])[1] ")));
			      
		 	   Actions actions = new Actions(driver);
			     actions.moveToElement(element1).build().perform();
			    element1.click();
			    
			    
			    WebDriverWait wait11 = new WebDriverWait(driver ,Duration.ofMillis(20));
			     
		 	    WebElement element110 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='orporate Action']")));
		 	   element110.click();
		 	   
		 	  // Thread.sleep(2000);
		 	   
		 	   
		 	   
		 	   
		 	
		 	   
		 	   //=================================================================================================================================================
  
		        
		
		        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(20));

		        
		        
		 	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New"))).click();


		
			
		 	 int     rowCount= reader.getRowCount("Captured");
	             for (int rowNum = 3 ; rowNum <= rowCount ;rowNum ++) {
//			 
	            	
      //  Xls_Reader  reader1 = new Xls_Reader ("C:\\Users\\pccenter_nageshbapuS\\Desktop\\Master_File_CA.xlsx");

			  
	            	 Thread.sleep(500);
		 	  
		 	 WebElement list_box = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class ='textField'])[1]")));
				
				//	 WebElement list_box = driver.findElement(By.xpath(" "));
	              
	              Select s = new Select (list_box);
	         //     s.selectByVisibleText("OPTION CASES")

	              s.selectByVisibleText("OPTION CASES");
	              ////input[@type='radio']
	       	   List<WebElement> radios1 = driver.findElements(By.xpath("//input[@type='radio']"));
	       	 
	       	 radios1.get(0).click();
	       	 
	      	String day = reader.getCellData("Captured", 4, rowNum);
		driver.findElement(By.xpath(" //input[@name ='execDay']")).clear();
	       	driver.findElement(By.xpath(" //input[@name ='execDay']")).sendKeys(day);
	       	
	       	String month = reader.getCellData("Captured", 5, rowNum);
	       	driver.findElement(By.xpath(" //input[@name ='execMonth']")).clear();
	     	 driver.findElement(By.xpath(" //input[@name ='execMonth']")).sendKeys(month);
	     	String year = reader.getCellData("Captured", 6, rowNum);
	     	 driver.findElement(By.xpath(" //input[@name ='execYear']")).clear();
	     	 driver.findElement(By.xpath(" //input[@name ='execYear']")).sendKeys(year);
	     	 
	     	String allot_day = reader.getCellData("Captured", 7, rowNum);
	     	driver.findElement(By.xpath(" //input[@name ='allotDay']")).clear();
	     	 driver.findElement(By.xpath(" //input[@name ='allotDay']")).sendKeys(allot_day);
	     	 
	      	String allot_months = reader.getCellData("Captured", 8, rowNum);
	      	 driver.findElement(By.xpath(" //input[@name ='allotMonth']")).clear();
	     	 driver.findElement(By.xpath(" //input[@name ='allotMonth']")).sendKeys(allot_months);
	     	String allot_year = reader.getCellData("Captured", 9, rowNum);
	     	 driver.findElement(By.xpath(" //input[@name ='allotYear']")).clear();
	     	 driver.findElement(By.xpath(" //input[@name ='allotYear']")).sendKeys(allot_year);
	     	 
	     	 
	     	String reference = reader.getCellData("Captured", 10, rowNum);
	     	 driver.findElement(By.xpath("(//input[@name ='rtaIntRefNo'])[1]")).clear();
	     	 driver.findElement(By.xpath("(//input[@name ='rtaIntRefNo'])[1]")).sendKeys(reference);
	     	 
	      	String isin = reader.getCellData("Captured", 11, rowNum);
	    	driver.findElement(By.xpath("//input[@name='ISIN']")).clear();
	     	driver.findElement(By.xpath("//input[@name='ISIN']")).sendKeys(isin);
	     	
	     	
	     	String Quantaty = reader.getCellData("Captured", 17, rowNum);
	     	driver.findElement(By.xpath("//input[@name='totalAllotmentQty']")).clear();
	     	 driver.findElement(By.xpath("//input[@name='totalAllotmentQty']")).sendKeys(Quantaty);
	     	 
	     	
	     	 
	     	
	     	 
	     	 WebElement list_box11 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='allotmentDesc'])[1]")));
				
				//	 WebElement list_box = driver.findElement(By.xpath(" "));
	             
	             Select s1 = new Select (list_box11);
	             
	             s1.selectByVisibleText("Allotment of Preference shares");
	             
	   //(//select[@id='stampDutyPayable'])[1]
	             
//=================================================================
		     	 String Stamp_duty = reader.getCellData("Captured", 18, rowNum);

	             if (!Stamp_duty.isEmpty()) {     
	             WebElement list_box1122 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='stampDutyPayable'])[1]")));
					
					//	 WebElement list_box = driver.findElement(By.xpath(" "));
		             
		             Select s1u = new Select (list_box1122);
		             
		             s1u.selectByVisibleText("No");
		                    
	             
//		             WebElement list_box1122II = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='stampDutyCalculation'])[1]")));
//						
//						//	 WebElement list_box = driver.findElement(By.xpath(" "));
//			             
//			             Select s1uII = new Select (list_box1122II);
//			             
//			             s1uII.selectByVisibleText("Yes");
             
	             
	             
	             
//	             WebElement list_box111 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='stampDutyCalculation'])[1]")));
//	 			
//	 			//	 WebElement list_box = driver.findElement(By.xpath(" "));
//	                 
//	                 Select s11 = new Select (list_box111);
//	                 
//	              s11.selectByVisibleText("ISSUED AMOUNT");
	                 //s11.selectByVisibleText("PAIDUP AMOUNT");
	             } else {
				      
	            	 WebElement list_box1122 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='stampDutyPayable'])[1]")));
						
						//	 WebElement list_box = driver.findElement(By.xpath(" "));
			             
			             Select s1u = new Select (list_box1122);
			             
			             s1u.selectByVisibleText("No");
			                      
				        }

	             
	             
//	             WebElement list_box111 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='stampDutyCalculation'])[1]")));
	  	 			
//	 			//	 WebElement list_box = driver.findElement(By.xpath(" "));
//	                 
//	                 Select s11 = new Select (list_box111);
//	                 
//	              s11.selectByVisibleText("NOT APPLICABLE");
	                 //s11.selectByVisibleText("PAIDUP AMOUNT");
	             int rowCount1 = 7; 
	             
	             for (int i = 3; i <= rowCount1; i++) {
	                 String DP_Id = reader.getCellData("Captured", 13, i);
	                 String xpath = String.format("//input[@name ='caDetailsDTO[%d].dpId']", i - 3);
	               //input[@name ='caDetailsDTO[0].dpId']
	                 if (driver.findElements(By.xpath(xpath)).size() > 0) {
	                     driver.findElement(By.xpath(xpath)).clear();
	                     driver.findElement(By.xpath(xpath)).sendKeys(DP_Id);
	                 } else {
	                    
	                 }
	             }
	             
	             
             int rowCount11 = 7; 
	             
	             for (int i = 3; i <= rowCount11; i++) {
	                 String clientID = reader.getCellData("Captured", 14, i);
	                 String xpath = String.format("//input[@name ='caDetailsDTO[%d].clientID']", i - 3);
	               //input[@name ='caDetailsDTO[0].dpId']
	                 if (driver.findElements(By.xpath(xpath)).size() > 0) {
	                     driver.findElement(By.xpath(xpath)).clear();
	                     driver.findElement(By.xpath(xpath)).sendKeys(clientID);
	                 } else {
	                    
	                 }
	             }
	             
          int rowCount111 = 7; 
	             
	             for (int i = 3; i <= rowCount111; i++) {
	                 String altmtQty = reader.getCellData("Captured", 12, i);
	                 String xpath = String.format("//input[@name ='caDetailsDTO[%d].altmtQty']", i - 3);
	               //input[@name ='caDetailsDTO[0].dpId']
	                 if (driver.findElements(By.xpath(xpath)).size() > 0) {
	                     driver.findElement(By.xpath(xpath)).clear();
	                     driver.findElement(By.xpath(xpath)).sendKeys(altmtQty);
	                 } else {
	                  
	                 }
	             }
	             

//=================================================================================================================================================		    	     	
	    	    

	             try {
	             	 JavascriptExecutor js = (JavascriptExecutor) driver;
	              	 
	              	// js.executeScript("Window.scrollBy()0,100)" );
	              	WebElement flag = driver.findElement(By.xpath("//input[@id ='saveButton']"));
	              	 js.executeScript("arguments[0].scrollIntoView()", flag);
	              	flag.click();
	     	 } catch (NoAlertPresentException e) {
	          	   
	          	}
	              try {	
	              	driver.switchTo().alert().accept();
	              } catch (NoAlertPresentException e) {
		          	   
		          	}
	              try {
	               // Thread.sleep(1000);
	              	 WebElement instructionElement = driver.findElement(By.xpath("//td[text() = 'CAPTURED']/preceding-sibling::td[2]")); // Assuming the instruction ID is displayed on the webpage with id "instructionIdElement"
  	   	          String instructionId = instructionElement.getText();

//       	   	          // Write the instruction ID to the Excel sheet
   	   	        System.out.println(instructionId)  ;
   	   	          reader.setCellData("Captured", "Instruction_Id", rowNum, instructionId);       	
	              	
	              } catch (NoAlertPresentException e) {
		          	   
		          	}
             	
	              	
	              	
	              //	driver.navigate().forward();
	              
	         Thread.sleep(1000);
	         try {
	           //   	(//input[@id ='Detail'])[1]
	              		   JavascriptExecutor js1 = (JavascriptExecutor) driver;
	              			WebElement flag1 = driver.findElement(By.xpath("//input[@value ='New']"));
	   	              	 js1.executeScript("arguments[0].scrollIntoView()", flag1);
	   	              	flag1.click();
	         } catch (NoAlertPresentException e) {
	          	   
	          	}
	   	              	
	   	             
	       	}
	             
	        //     driver.close();
	            
}
			


}
		

