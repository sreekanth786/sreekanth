package TestCases;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import AutomationFramework.GenericKeywords;
import SWAUT.ApplicationKeywords;
import Utilities.Common;

@Listeners({ Utilities.TestListener.class })
public class TestCases extends Common {

	public static int count1 = 1, count2=1;


	public void TestStart(String curApplication, String testCaseDescription) {

		GenericKeywords.currentStep = 0;
		reportStart(testCaseDescription);

		if (curApplication.toUpperCase().equals("VIBER"))

		{


			if (count1 == 1) {
				GenericKeywords.driver.quit();

				ApplicationKeywords.openApp(getConfigProperty("AppName2"),getConfigProperty("AppPackageName2"),getConfigProperty("AppActivityName2"));
				count1++;
			} else {
				ApplicationKeywords.lanuchApp();
			}


		}
		else if (curApplication.toUpperCase().equals("CALCULATOR"))
		{

			if (count2 == 1) {
				ApplicationKeywords.openApp(getConfigProperty("AppName1"),getConfigProperty("AppPackageName1"),getConfigProperty("AppActivityName1"));
				count2++;
			} else {
				ApplicationKeywords.lanuchApp();
			}


		}else if (curApplication.toUpperCase().equals("CHROME")){
			GenericKeywords.driver.quit();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"");   
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"default");
			capabilities.setCapability("deviceName", "MotoX");
			capabilities.setCapability("platformVersion", "5.1");
			capabilities.setCapability("platformName", "Android");
			try {
				AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				GenericKeywords.driver = driver;
				driver.navigate().to("http://newtours.demoaut.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}




	}

	@Test(alwaysRun = true)
	public void TC1() {
		try {
			TestStart("CALCULATOR","Validate Addition");
			Module.moduleFunctionalities.VerifyAddition();
		} finally {
			TestEnd();
		}
	}


	@Test(alwaysRun = true)
	public void TC2() {
		try {
			TestStart("CALCULATOR","Validate Substraction");
			Module.moduleFunctionalities.VerifySubstraction();
		} finally {
			TestEnd();
		}
	}

	@Test(alwaysRun = true)
	public void TC3() {
		try {
			TestStart("CALCULATOR","Validate Multiplication");
			Module.moduleFunctionalities.VerifyMulti();
		} finally {
			TestEnd();
		}
	}



	@Test(alwaysRun = true)
	public void TC4() {
		try {
			TestStart("CALCULATOR","Validate Division");
			Module.moduleFunctionalities.VerifyDevision();
		} finally {
			TestEnd();
		}
	}


	@Test(alwaysRun = true)
	public void TC5() {
		try {
			TestStart("Viber","Launch & Send Message");
			Module.moduleFunctionalities.ViberTest();
		} finally {
			TestEnd();
		}
	}

	@Test(alwaysRun = true)
	public void TC6() {
		try {
			TestStart("Viber","Viber Menu Navigation");
			Module.moduleFunctionalities.ViberMenuNavitgation();
		} finally {
			TestEnd();
		}
	}


	@Test(alwaysRun = true)
	public void TC7() {
		try {
			TestStart("chrome","Verify Book Flight");
			Module.moduleFunctionalities.loginToApplication();
			Module.moduleFunctionalities.bookFlight();
		} finally {
			//TestEnd();
		}
	}






	public void TestEnd() {
		ApplicationKeywords.clearRequestResponseFromFiddler();
		ApplicationKeywords.closeApp();

	}
}
