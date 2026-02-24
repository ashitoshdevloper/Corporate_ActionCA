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


public class All_captured {
		//public static void main(String[] args) throws InterruptedException {
			public static void main(String[] args) throws IOException, InterruptedException {
		    //  Xls_Reader  reader = new Xls_Reader ("\\Master_File_CA.xlsx");
				
		 Xls_Reader_UAT reader =new Xls_Reader_UAT(System.getProperty("user.dir")+"\\Master_File_CA_UAT.xlsx");
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");//"D:\chromedriver.exe" D:\chromedriver-win64\chromedriver-win64\chromedriver.exe
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
	      	   radios.get(2).click();
	      		
	      	    
	      	     
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
	     //  try {     	
      //  Xls_Reader  reader1 = new Xls_Reader ("C:\\Users\\pccenter_nageshbapuS\\Desktop\\Master_File_CA.xlsx");

			  
					
//		 	  
//		 	 WebElement list_box = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class ='textField'])[1]")));
//				
//				//	 WebElement list_box = driver.findElement(By.xpath(" "));
//	              
//	              Select s = new Select (list_box);
//	         //     s.selectByVisibleText("OPTION CASES")
//
//	              s.selectByVisibleText("OPTION CASES");
	              ////input[@type='radio']
	            	 
	            	 
	              
//------------------------------------------------------------------------------------------------------------------------------------
	              String Ca_Type = reader.getCellData("Captured", 23, rowNum);
	            	
	     	 	 WebElement list_box1 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class ='textField'])[1]")));
	     	 	 Select s1 = new Select (list_box1);
	     	 	//list_box1.click();
	     	     // s1.selectByIndex(6);
	     	 s1.selectByVisibleText(Ca_Type);            

//---------------------------------------------------------------------------------------------------------------------------------------------------
//	       	String radioValue = reader.getCellData("Captured", 24, rowNum);
//  // driver.findElement(By.name("crdbtIndicator")).sendKeys(radioValue) ;   	 
//	       	 
//	   //for dbt   
//	       	driver.findElement(By.xpath("(//input[@name ='crdbtIndicator'])[2]")).click();
	      //  driver.findElement(By.xpath("(//input[@name ='crdbtIndicator'])[2]")).sendKeys(radioValue);
	       	
	       	
	       	String radioValue = reader.getCellData("Captured", 24, rowNum);
	        
	  
	     if (radioValue.equals("C")) {
	     driver.findElement(By.name("crdbtIndicator")).click();
	     }
	    
	     else if (radioValue.equals("D")) {
	        
	         driver.findElement(By.xpath("(//input[@name='crdbtIndicator'])[2]")).click();
	     }    	
	       	
//--------------------------------------------------------------------------------------------------------------------------------------		       	 
	       	 
	    	 
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
	     	
	     	//input[@name ='rtaIntRefNo']
	     	String reference = reader.getCellData("Captured", 10, rowNum);
	     	 driver.findElement(By.xpath("//input[@name ='rtaIntRefNo']")).clear();
	     	 driver.findElement(By.xpath("//input[@name ='rtaIntRefNo']")).sendKeys(reference);	
	     	 
	     	 
//	     	String reference = reader.getCellData("Captured", 10, rowNum);
//	     	 driver.findElement(By.xpath("(//INPUT[@CLASS='textField CorporateActionNewInstruction0 '])[1]")).clear();
//	     	 driver.findElement(By.xpath("(//INPUT[@CLASS='textField CorporateActionNewInstruction0 '])[1]")).sendKeys(reference);
	     	
	      	String isin = reader.getCellData("Captured", 11, rowNum);
	    	driver.findElement(By.xpath("//input[@name='ISIN']")).clear();
	     	driver.findElement(By.xpath("//input[@name='ISIN']")).sendKeys(isin);
	     
	     	
	     
	     	String Quantaty = reader.getCellData("Captured", 12, rowNum);
	     	driver.findElement(By.xpath("//input[@name='totalAllotmentQty']")).clear();
	     	 driver.findElement(By.xpath("//input[@name='totalAllotmentQty']")).sendKeys(Quantaty);
	     	 
	     	
	     	
	     	 
	      	String allotmentDesc = reader.getCellData("Captured", 25, rowNum);
	     	 
	     	 WebElement list_box11 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='allotmentDesc'])[1]")));
				
				//	 WebElement list_box = driver.findElement(By.xpath(" "));
	             
	             Select s11 = new Select (list_box11);
	             
	             s11.selectByVisibleText(allotmentDesc);
	     	 
	   //(//select[@id='stampDutyPayable'])[1]
//	             String Stamp_duty = reader.getCellData("Captured", 26, rowNum);
//	             
//	          //   
//	             
//	             WebElement list_box1122 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='stampDutyPayable'])[1]")));
//	             Select s1u = new Select(list_box1122);
//	              
//	             if ("Y".equalsIgnoreCase(Stamp_duty)) {
//	                 s1u.selectByVisibleText("Yes");
//	                
////	                 String stampDutyCalculation = reader.getCellData("Captured", 27, rowNum);
////		             WebElement list_box111 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='stampDutyCalculation'])[1]")));
////		 			
////		 		
////		                 
////		                 Select s111 = new Select (list_box111);
////		                 
////		              s111.selectByVisibleText(stampDutyCalculation);
//	                 
//	                 
//	             } else if ("N".equalsIgnoreCase(Stamp_duty)) {
//	                 s1u.selectByVisibleText("No");
//	             } else {
//	                 // Handle the case when neither 'Y' nor 'N' is provided, you might want to add appropriate handling or default behavior here
//	             }
	             
//=================================================================
	     	 String Stamp_duty = reader.getCellData("Captured", 26, rowNum);
	        

	          if (!Stamp_duty.isEmpty()) {     
	             WebElement list_box1122 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='stampDutyPayable'])[1]")));
					
					//	 WebElement list_box = driver.findElement(By.xpath(" "));
		             
		             Select s1u = new Select (list_box1122);
		             
		             s1u.selectByVisibleText(Stamp_duty);
	          } else {} 
	          	   
        
	     	 
	     	String stampDutyCalculation = reader.getCellData("Captured", 27, rowNum);
	     	 
	  
	     	  
	     	    if (!stampDutyCalculation.isEmpty()) {
	     	     
	     	        WebElement list_box111 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='stampDutyCalculation'])[1]")));
	     	        
	     	      
	     	        Select s111 = new Select(list_box111);
	     	 
	     	       
	     	        s111.selectByVisibleText(stampDutyCalculation);
	     	    } else {
	     	      
	     	    }
	     	
	             
//		             WebElement list_box1122II = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='stampDutyCalculation'])[1]")));
//						
//						//	 WebElement list_box = driver.findElement(By.xpath(" "));
//			             
//			             Select s1uII = new Select (list_box1122II);
//			             
//			             s1uII.selectByVisibleText("Yes");

//	             String stampDutyCalculation = reader.getCellData("Captured", 27, rowNum);
//	     try {     if (!stampDutyCalculation.isEmpty()) {
//	             
//	             WebElement list_box111 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='stampDutyCalculation'])[1]")));
//	 			
//	 		
//	                 
//	                 Select s111 = new Select (list_box111);
//	                 
//	              s111.selectByVisibleText(stampDutyCalculation);
////	                 //s11.selectByVisibleText("PAIDUP AMOUNT");
//             } 
	     
	    // else {
//	            	  String stampDutyPayable = reader.getCellData("Captured", 26, rowNum);
//	            	 WebElement list_box1122 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='stampDutyPayable'])[1]")));
//						
//						//	 WebElement list_box = driver.findElement(By.xpath(" "));
//			             
//			             Select s1u = new Select (list_box1122);
//			             
//			             s1u.selectByVisibleText(stampDutyPayable);
			                      
//				     }
//	     } catch (NoAlertPresentException e) {
//          	   
//          	}
	          	//===============================================================                
	                 
//------------------------------------------------------------------------------------------------------	             
	             
	             
	             
	             
	             
	             
	                String DP_Id = reader.getCellData("Captured", 13, rowNum);
	                 driver.findElement(By.xpath("//input[@id ='dpId0']")).clear();
	             	 driver.findElement(By.xpath("//input[@id ='dpId0']")).sendKeys(DP_Id);
	             
	          
	             	 String Client_id = reader.getCellData("Captured", 14, rowNum);
	             	driver.findElement(By.xpath("//input[@id ='clientID0']")).clear();
	             	 driver.findElement(By.xpath("//input[@id ='clientID0']")).sendKeys(Client_id);
	             
	         
	             	String altmtQty = reader.getCellData("Captured", 12, rowNum);
	    	     	driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].altmtQty']")).clear();
	    	     	 driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].altmtQty']")).sendKeys(altmtQty);
	             
//--------------------------------------------------------------------------------------------------------------------------------------------
		         //    	if (!DP_Id1.isEmpty() && !Client_id1.isEmpty() && !altmtQty1.isEmpty() && !DP_Id11.isEmpty()) {
 
	    	     	 
	    	     	 
//	    	     	for (int i = 0; i < 4; i++) {
//	    	     	    String DP_Id = reader.getCellData("Captured", 13, rowNum + i);
//	    	     	    String Client_id = reader.getCellData("Captured", 14, rowNum + i);
//	    	     	    String altmtQty = reader.getCellData("Captured", 12, rowNum + i);
//	    	     	 
//	    	     	    if (driver.findElements(By.xpath("//input[@id ='dpId0']")).size() > 0) {
//	    	     	        driver.findElement(By.xpath("//input[@id ='dpId0']")).clear();
//	    	     	        driver.findElement(By.xpath("//input[@id ='dpId0']")).sendKeys(DP_Id);
//	    	     	    }
//	    	     	 
//	    	     	    if (driver.findElements(By.xpath("//input[@id ='clientID0']")).size() > 0) {
//	    	     	        driver.findElement(By.xpath("//input[@id ='clientID0']")).clear();
//	    	     	        driver.findElement(By.xpath("//input[@id ='clientID0']")).sendKeys(Client_id);
//	    	     	    }
//	    	     	 
//	    	     	    if (driver.findElements(By.xpath("//input[@name ='caDetailsDTO[0].altmtQty']")).size() > 0) {
//	    	     	        driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].altmtQty']")).clear();
//	    	     	        driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].altmtQty']")).sendKeys(altmtQty);
//	    	     	    }
//	    	     	}
//------------------------------------------------------------------------------------------------------------------------------------------	    	     	 
	     
	             	String quanty = reader.getCellData("Captured", 3, rowNum);
	             	String lockin_day = reader.getCellData("Captured", 0, rowNum);
	             	String lockin_month = reader.getCellData("Captured", 1, rowNum);
	             	String lockin_year = reader.getCellData("Captured", 2, rowNum);
	             	String lock_in_reason = reader.getCellData("Captured", 28, rowNum); 
	             	// Check if the data is present in the Excel sheet
	             	if (!quanty.isEmpty() && !lockin_day.isEmpty() && !lockin_month.isEmpty() && !lockin_year.isEmpty()) {
	             	    // Perform actions
	             	    driver.findElement(By.xpath("//input[@name ='lockinAllotmentQty']")).clear();
	             	    driver.findElement(By.xpath("//input[@name ='lockinAllotmentQty']")).sendKeys(quanty);
	             	 
	             	     WebElement list_box111 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name ='caDetailsDTO[0].lockInReasonCode']")));
	             	    Select s7 = new Select(list_box111);
	             	    s7.selectByVisibleText(lock_in_reason);
	             	 
	             	    driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].lockinDay']")).clear();
	             	    driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].lockinDay']")).sendKeys(lockin_day);
	             	 
	             	    driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].lockinMonth']")).clear();
	             	    driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].lockinMonth']")).sendKeys(lockin_month);
	             	 
	             	    driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].lockinYear']")).clear();
	             	    driver.findElement(By.xpath("//input[@name ='caDetailsDTO[0].lockinYear']")).sendKeys(lockin_year);
	             	} else {
	             	    // Data not present, do nothing or handle as per your requirement
	             	}
	             	 
	     	
	      //===========================================================================================================
//	             	JavascriptExecutor js1P = (JavascriptExecutor) driver;
//	             	
//	             	String STAMP = reader.getCellData("Captured", 17, rowNum);
//	             	
//          			WebElement flag1T = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].issuePrice'])[1]"));
//	              	 js1P.executeScript("arguments[0].scrollIntoView()", flag1T);
//	              	flag1T.sendKeys(STAMP);
//	              	
//	             JavascriptExecutor js1P1 = (JavascriptExecutor) driver;
//             	
//             	String STAMP1 = reader.getCellData("Captured", 18, rowNum);
//             	
//   			WebElement flag1T1 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].paidUpPrice'])[1]"));
//          	 js1P1.executeScript("arguments[0].scrollIntoView()", flag1T1);
//          	flag1T1.sendKeys(STAMP1);
//          	
//          	 JavascriptExecutor js1P11 = (JavascriptExecutor) driver;
//             	
//             	String STAMP11 = reader.getCellData("Captured", 19, rowNum);
//             	
//			WebElement flag1T11 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].issuedAmount'])[1]"));
//       	 js1P11.executeScript("arguments[0].scrollIntoView()", flag1T11);
//       	flag1T11.sendKeys(STAMP11);
//       	
//      // 	(//input[@name='caDetailsDTO[0].paidUpAmount'])[1]
//       	
//        JavascriptExecutor js1P111 = (JavascriptExecutor) driver;
//     	
//     	String STAMP111 = reader.getCellData("Captured", 20, rowNum);
//     	
//	WebElement flag1T111 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].paidUpAmount'])[1]"));
//	 js1P111.executeScript("arguments[0].scrollIntoView()", flag1T111);
//	flag1T111.sendKeys(STAMP111);
	
	
	
// 	----------------------------------------------------------------------------------------------------------------
	
//	String STAMP = reader.getCellData("Captured", 19, rowNum);
//	String STAMP1 = reader.getCellData("Captured", 20, rowNum);
//	String STAMP11 = reader.getCellData("Captured", 21, rowNum);
//	String STAMP111 = reader.getCellData("Captured", 22, rowNum);
//	try { 
//	// Check if the data is present in the Excel sheet
//	if (!STAMP.isEmpty() && !STAMP1.isEmpty() && !STAMP11.isEmpty() && !STAMP111.isEmpty()) {
//	    // Perform actions
//	   
//		JavascriptExecutor js1P = (JavascriptExecutor) driver;
// 	
// 	//String STAMP = reader.getCellData("Captured", 17, rowNum);
// 	
//		WebElement flag1T = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].issuePrice'])[1]"));
// 	 js1P.executeScript("arguments[0].scrollIntoView()", flag1T);
// 	flag1T.clear();
// 	flag1T.sendKeys(STAMP);
// 	
//JavascriptExecutor js1P1 = (JavascriptExecutor) driver;
//	
////	String STAMP1 = reader.getCellData("Captured", 18, rowNum);
//	
//WebElement flag1T1 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].paidUpPrice'])[1]"));
// js1P1.executeScript("arguments[0].scrollIntoView()", flag1T1);
// flag1T1.clear();
//flag1T1.sendKeys(STAMP1);
//
// JavascriptExecutor js1P11 = (JavascriptExecutor) driver;
//	
//	//String STAMP11 = reader.getCellData("Captured", 19, rowNum);
//	
//WebElement flag1T11 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].issuedAmount'])[1]"));
//js1P11.executeScript("arguments[0].scrollIntoView()", flag1T11);
//flag1T11.clear();
//flag1T11.sendKeys(STAMP11);
//
////	(//input[@name='caDetailsDTO[0].paidUpAmount'])[1]
//
//JavascriptExecutor js1P111 = (JavascriptExecutor) driver;
//
////String STAMP111 = reader.getCellData("Captured", 20, rowNum);
//
//WebElement flag1T111 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].paidUpAmount'])[1]"));
//js1P111.executeScript("arguments[0].scrollIntoView()", flag1T111);
//flag1T111.clear();
//flag1T111.sendKeys(STAMP111);
//		
//		
//	} else {
//	    // Data not present, do nothing or handle as per your requirement
//	}
//	
//	 } catch (NoAlertPresentException e) {
//	   
//	}
	
	     	
	     	
	     	String STAMP = reader.getCellData("Captured", 19, rowNum);
	     	String STAMP1 = reader.getCellData("Captured", 20, rowNum);
	     	String STAMP11 = reader.getCellData("Captured", 21, rowNum);
	     	String STAMP111 = reader.getCellData("Captured", 22, rowNum);
	     	 
	    
	     	    // Check if the data is present in the Excel sheet
	     	    if (!STAMP.isEmpty() && !STAMP1.isEmpty() && !STAMP11.isEmpty() && !STAMP111.isEmpty()) {
	     	        
	     	        JavascriptExecutor js1P = (JavascriptExecutor) driver;
	     	        
	     	        // Handle STAMP
	     	        WebElement flag1T = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].issuePrice'])[1]"));
	     	        if (flag1T.isEnabled()) {
	     	            js1P.executeScript("arguments[0].scrollIntoView()", flag1T);
	     	            flag1T.clear();
	     	            flag1T.sendKeys(STAMP);
	     	        }
	     	 
	     	        // Handle STAMP1
	     	        JavascriptExecutor js1P1 = (JavascriptExecutor) driver;
	     	        WebElement flag1T1 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].paidUpPrice'])[1]"));
	     	        if (flag1T1.isEnabled()) {
	     	            js1P1.executeScript("arguments[0].scrollIntoView()", flag1T1);
	     	            flag1T1.clear();
	     	            flag1T1.sendKeys(STAMP1);
	     	        }
	     	 
	     	        // Handle STAMP11
	     	        JavascriptExecutor js1P11 = (JavascriptExecutor) driver;
	     	        WebElement flag1T11 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].issuedAmount'])[1]"));
	     	        if (flag1T11.isEnabled()) {
	     	            js1P11.executeScript("arguments[0].scrollIntoView()", flag1T11);
	     	            flag1T11.clear();
	     	            flag1T11.sendKeys(STAMP11);
	     	        }
	     	 
	     	        // Handle STAMP111
	     	        JavascriptExecutor js1P111 = (JavascriptExecutor) driver;
	     	        WebElement flag1T111 = driver.findElement(By.xpath("(//input[@name='caDetailsDTO[0].paidUpAmount'])[1]"));
	     	        if (flag1T111.isEnabled()) {
	     	            js1P111.executeScript("arguments[0].scrollIntoView()", flag1T111);
	     	            flag1T111.clear();
	     	            flag1T111.sendKeys(STAMP111);
	     	        }
	     	    } else {
	     	        // Data not present, do nothing or handle as per your requirement
	     	    }
	     	
//===========================================================================================================	              
	     	 
	             	 JavascriptExecutor js = (JavascriptExecutor) driver;
	              	 
	          //   js.executeScript("Window.scrollBy()0,100)" );
	              	WebElement flag = driver.findElement(By.xpath("//input[@id ='saveButton']"));
	              	 js.executeScript("arguments[0].scrollIntoView()", flag);
	              	flag.click();
	            
	              	try {
	              	driver.switchTo().alert().accept();
	              	 } catch (NoAlertPresentException e) {
	  	          	   
	 	          	}
	            Thread.sleep(500);
	      
	              	 WebElement instructionElement = driver.findElement(By.xpath("//td[text() = 'CAPTURED']/preceding-sibling::td[2]")); // Assuming the instruction ID is displayed on the webpage with id "instructionIdElement"
   	   	          String instructionId = instructionElement.getText();

//        	   	          // Write the instruction ID to the Excel sheet
    	   	        System.out.println(instructionId)  ;
    	   	          reader.setCellData("Captured", "Instruction_Id", rowNum, instructionId);       	
	              	
	          	
              	
	              	
	              	
	              //	driver.navigate().forward();
	              
	         Thread.sleep(1000);
	         
	       
	           //   	(//input[@id ='Detail'])[1]
	              		   JavascriptExecutor js1 = (JavascriptExecutor) driver;
	              			WebElement flag1 = driver.findElement(By.xpath("//input[@value ='New']"));
	   	              	 js1.executeScript("arguments[0].scrollIntoView()", flag1);
	   	              	flag1.click();
	
	   	             Thread.sleep(3000);  
//	       } catch (Exception e) {
//                   
//                continue;
//            }
	   	         // Thread.sleep(2000);      
	       	}
	             
	            // driver.close();
	            
}
			


}
		








