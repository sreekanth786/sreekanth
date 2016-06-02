package Module;


import io.appium.java_client.AndroidKeyCode;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class moduleFunctionalities extends CommonUtilities {


	public static void validLogin(){

		clickOn(OR.btn_home_signIn);
		//waitForElement(OR.txt_username);
		typeIn(OR.txt_username,retrieve("txtUsername"));
		waitTime(2);
		typeIn(OR.txt_password,retrieve("txtPassword"));
		clickOn(OR.btn_signIn);
		testStepPassed("Home Page Loaded Successfully");
		waitTime(5);

	}


	public static void TweetMessage(){

		String txtmessage=retrieve("txtTweetText")+getRandomText("lowercase",3);

		clickOn(OR.btn_tweet);
		typeIn(OR.txt_tweetbox,txtmessage);
		clickOn(OR.btn_post);
		clickOn(OR.btn_overflow);
		waitTime(3);
		clickOn(OR.btn_overflowitemtitle);
		testStepPassed("Profile loadded successfully");
		/*
		String strMsg=getText(OR.txt_validmsg);
		testStepPassed(strMsg);
		String strMsgNew1=getAttributeValue(OR.txt_validmsg,"name");
		testStepPassed(strMsgNew1);
		String strMsgNew=driver.findElementByXPath("//*[@class='android.view.View']").getAttribute("content-desc");

		//String strMsgNew=getAttributeValue(OR.txt_validmsg,"content-desc");
		testStepPassed(strMsgNew);*/

		/*	if(strMsg.contains(txtmessage)){
			testStepPassed("Validated the text message matches");
		}
		else{
			testStepFailed("Validated the text message does not matches");	
		}*/

	}



	public static void InvalidLogin(){

		try {

			clickOn(OR.btn_home_signIn);
			waitForElement(OR.txt_username);
			typeIn(OR.txt_username,retrieve("txtUsername"));
			typeIn(OR.txt_password,retrieve("txtPassword"));
			clickOn(OR.btn_signIn);
			waitTime(5);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(outputDirectory+"\\Screenshots\\InvalidCredentials.png"));
			if(elementPresent(OR.btn_tweet)){
				testStepPassed("Invalid credentials not validated");
			}
			else{
				testStepFailed("Validated invalid credentials");
			}

		} catch (Exception e) {
			testStepPassed(e.toString());
		}

	}


	public static void VerifyAddition(){

		try {
			String integer1 = retrieve("Integer1");
			String integer2 = retrieve("Integer2");
			String[] int1 = integer1.split("");
			String[] int2 = integer2.split("");
			for(int i=0;i<int1.length;i++){
				driver.findElementByName(int1[i]).click();
			}
			testStepPassed("Entered the integer1 ->"+retrieve("Integer1"));
			driver.findElementByName("+").click();
			for(int i=0;i<int2.length;i++){
				driver.findElementByName(int2[i]).click();
			}
			testStepPassed("Entered the integer2 ->"+retrieve("Integer2"));		
			String ans = driver.findElementById("com.android.calculator2:id/result").getText();
			if(ans.equals(retrieve("Result"))){
				testStepPassed("Expected ->"+retrieve("Result") +", Actual->"+ans);				
			}else{
				testStepFailed("Expected ->"+retrieve("Result") +", Actual->"+ans);
			}		
		} catch (Exception e) {
			testStepFailed(e.toString());
		}

	}

	public static void VerifySubstraction(){

		try {
			String integer1 = retrieve("Integer1");
			String integer2 = retrieve("Integer2");
			String[] int1 = integer1.split("");
			String[] int2 = integer2.split("");
			for(int i=0;i<int1.length;i++){
				driver.findElementByName(int1[i]).click();
			}
			testStepPassed("Entered the integer1 ->"+retrieve("Integer1"));
			driver.findElementById("com.android.calculator2:id/op_sub").click();			

			for(int i=0;i<int2.length;i++){
				driver.findElementByName(int2[i]).click();
			}
			testStepPassed("Entered the integer2 ->"+retrieve("Integer2"));		
			String ans = driver.findElementById("com.android.calculator2:id/result").getText();
			if(ans.equals(retrieve("Result"))){
				testStepPassed("Expected ->"+retrieve("Result") +", Actual->"+ans);
			}else{
				testStepFailed("Expected ->"+retrieve("Result") +", Actual->"+ans);
			}	

		} catch (Exception e) {
			testStepFailed(e.toString());
		}

	}

	public static void VerifyMulti(){

		try {
			String integer1 = retrieve("Integer1");
			String integer2 = retrieve("Integer2");
			String[] int1 = integer1.split("");
			String[] int2 = integer2.split("");
			for(int i=0;i<int1.length;i++){
				driver.findElementByName(int1[i]).click();
			}
			testStepPassed("Entered the integer1 ->"+retrieve("Integer1"));
			
			driver.findElementById("com.android.calculator2:id/op_mul").click();			
						
			for(int i=0;i<int2.length;i++){
				driver.findElementByName(int2[i]).click();
			}
			testStepPassed("Entered the integer2 ->"+retrieve("Integer2"));		
			String ans = driver.findElementById("com.android.calculator2:id/result").getText();
			if(ans.equals(retrieve("Result"))){
				testStepPassed("Expected ->"+retrieve("Result") +", Actual->"+ans);
			}else{
				testStepFailed("Expected ->"+retrieve("Result") +", Actual->"+ans);
			}	

		} catch (Exception e) {
			testStepFailed(e.toString());
		}

	}

	public static void VerifyDevision(){

		try {
			String integer1 = retrieve("Integer1");
			String integer2 = retrieve("Integer2");
			String[] int1 = integer1.split("");
			String[] int2 = integer2.split("");
			for(int i=0;i<int1.length;i++){
				driver.findElementByName(int1[i]).click();
			}
			testStepPassed("Entered the integer1 ->"+retrieve("Integer1"));
			driver.findElementById("com.android.calculator2:id/op_div").click();
			for(int i=0;i<int2.length;i++){
				driver.findElementByName(int2[i]).click();
			}
			testStepPassed("Entered the integer2 ->"+retrieve("Integer2"));		
			String ans = driver.findElementById("com.android.calculator2:id/result").getText();
			if(ans.equals(retrieve("Result"))){
				testStepPassed("Expected ->"+retrieve("Result") +", Actual->"+ans);
			}else{
				testStepFailed("Expected ->"+retrieve("Result") +", Actual->"+ans);
			}	

		} catch (Exception e) {
			testStepFailed(e.toString());
		}

	}


	public static void MenuNavitgation(){

		clickOn(OR.btn_bell);
		waitTime(5);
		clickOn(OR.btn_backward);
		clickOn(OR.btn_msg);
		waitTime(5);
		clickOn(OR.btn_backward);
		clickOn(OR.btn_findppl);
		waitTime(5);
		clickOn(OR.btn_backward);
		clickOn(OR.btn_search);
		waitTime(5);

		//	waitForElement(OR.btn_backward);
		//	clickOn(OR.btn_backward);
	}


	public static void ViberTest(){

		String strMessage=retrieve("txtText")+getRandomText("lowercase",5);
		clickOn(OR.btn_messages);
		clickOn(OR.btn_messageFrom);
		typeIn(OR.txt_sendText,strMessage);
		clickOn(OR.btn_sendExtra);

	}


	public static void ViberMenuNavitgation(){

		clickOn(OR.btn_messages);
		waitTime(3);
		clickOn(OR.btn_contacts);
		waitTime(3);
		clickOn(OR.btn_keypad);
		waitTime(3);
		clickOn(OR.btn_groups);
		waitTime(3);

	}


	public static void loginToApplication() {
		driver.findElementByXPath("//*[@name='userName']").sendKeys(retrieve("Username"));
		driver.findElementByXPath("//*[@name='password']").sendKeys(retrieve("Password"));
		testStepPassed("Entered userName and password");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElementByXPath("//*[@name='password']").sendKeys(Keys.TAB);
		driver.findElementByXPath("//*[@name='password']").sendKeys(Keys.ENTER);
		/*driver.findElementByXPath("//*[@name='login']").click();
		driver.findElementByLinkText("Sign-In").click();*/
		
		testStepPassed("Clicked on sign in button");		
	}
	
	
	public static void bookFlight() {
		  try{
		  
		   WebElement elem = driver.findElementByXPath("//*[@name='passCount']");
		   Select sel = new Select(elem);
		   sel.selectByIndex(1);
		   
		   WebElement elem1 = driver.findElementByXPath("//*[@name='airline']");
		   Select sel1 = new Select(elem1);
		   sel1.selectByIndex(3);
		   
		   
		   WebElement elem2 = driver.findElementByXPath("//*[@name='findFlights']");
		   elem2.click();
		   
		   WebElement elem3 = driver.findElementByXPath("//*[@name='reserveFlights']");
		   elem3.click();
		   
		   WebElement weFirstName1 = driver.findElementByXPath("//*[@name='passFirst0']");
		   weFirstName1.sendKeys(retrieve("FirstName"));
		   WebElement weLastName1 = driver.findElementByXPath("//*[@name='passLast0']");
		   weLastName1.sendKeys(retrieve("LastName"));
		  
		   WebElement weCreditnumber = driver.findElementByXPath("//*[@name='creditnumber']");
		   weCreditnumber.sendKeys(retrieve("CreditNumber"));
		   weCreditnumber.sendKeys(Keys.TAB);
		   testStepPassed("Enterd all the details");
		   Thread.sleep(1000);
		   
		   Thread.sleep(4000);
		   WebElement weSecurePurchase = driver.findElementByXPath("//*[@name='buyFlights']");		   
		   weSecurePurchase.click();
		   weSecurePurchase.sendKeys(Keys.ENTER);
		   if(elementPresent(OR.verify)){
			   testStepPassed("Flight Ticket has been booked successfully");
			}
			else{
				testStepFailed("Unable to book the flight");
			}
		  
		  }catch(Exception ex){
		   testStepFailed("UnableToBookFlight");
		   writeToLogFile("ERROR", ex.getMessage());
		  }

	}
}
