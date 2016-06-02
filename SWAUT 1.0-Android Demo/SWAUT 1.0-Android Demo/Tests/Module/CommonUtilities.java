package Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import SWAUT.ApplicationKeywords;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;

public class CommonUtilities extends ApplicationKeywords {
	static List<String> requestHeaderSession = new ArrayList();
	static List<String> requestHeaders = new ArrayList();
	static List<String> responseHeaders = new ArrayList();
	static List<String> responseHeaderSession = new ArrayList();
	static int temp = 0;

	public static void verifyAdRequestUrlQueryString(String queryParameter) {

		url = url.replace("%3A", ":");
		url = url.replace("%2F", "/");
		url = url.replace("+", " ");
		url = url.replace("%28", "(");
		url = url.replace("%3B", ";");
		url = url.replace("%29", ")");
		url = url.replace("%2C", ",");

		if (url.contains(queryParameter)) {
			testStepPassed("Verified the given '" + queryParameter
					+ "' querystring is present in AdRequest url");
		} else {
			testStepFailed("Verified the given '" + queryParameter
					+ "' querystring is not present in the AdRequest url-'"
					+ url + '"');
		}
	}

	public static void getRequestAndReponseHeaderFromFiddler() {
		try {
			Robot robot = new Robot();
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			Thread.sleep(2000);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			String value = (String) clipboard.getData(DataFlavor.stringFlavor);
			String lines[] = value.split("\\r?\\n");
			for (int i = 0; i < lines.length; i++) {
				if (!lines[i].equalsIgnoreCase("")) {
					if (temp == 0) {
						requestHeaderSession.add(lines[i]);
					}
					if (temp == 2) {
						responseHeaderSession.add(lines[i]);
					}
				} else {
					temp++;
				}
			}

			for (int i = 0; i < requestHeaderSession.size(); i++) {
				if (requestHeaderSession.get(i).contains("X-VSERV")) {
					requestHeaders.add(requestHeaderSession.get(i).trim());
				}
			}

			for (int i = 0; i < responseHeaderSession.size(); i++) {
				if (responseHeaderSession.get(i).contains("X-VSERV")) {
					responseHeaders.add(responseHeaderSession.get(i).trim());
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());

		}

	}

	public static String getHeaderName(String headerName) {
		String header = "";
		getRequestAndReponseHeaderFromFiddler();
		for (int i = 0; i < responseHeaders.size(); i++) {

			if (responseHeaders.get(i).contains(headerName)) {
				header = responseHeaders.get(i);
				break;
			}
			if (i == (responseHeaders.size() - 1)) {
				if (!headerName.contains("ORIENTATION")) {
					testStepFailed("'"
							+ headerName
							+ "' the given header name doesn't match in response headers name--'"
							+ responseHeaders.toString() + "'");
				}
			}
		}
		return header;
	}

	public static String getRandomText(String strCaseChoose, int numLenthOfText)
	{
		
		  String nums = "";
		  String possible = "";
		  if(strCaseChoose == "lowercase")
		  {
			     possible = "abcdefghijklmnopqrstuvwxyz"; 
			  }
			  else if(strCaseChoose == "uppercase"){
				 possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			  } 
		  for( int i=0; i < numLenthOfText; i++ )
		  {
		    char num = possible.charAt((int) Math.floor(Math.random()*possible.length()));
		    
		
		    nums = (String) (nums + num); 
		  }
		  return nums;	
	}

	
	
	public static void swipe(int startx,int starty,int endx,int endy,int milliseconds){
		
		try {
			driver.swipe(startx, starty, endx, endy, milliseconds);
			testStepPassed("Perfomed swipe successfully");
		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}
	
	public static void swipe()
    {  
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HashMap<String, Double> swipeObject = new HashMap<String, Double>();
    swipeObject.put("startX", 0.95);
    swipeObject.put("startY", 0.5);
    swipeObject.put("endX", 0.05);
    swipeObject.put("endY", 0.5);
    swipeObject.put("duration", 1.8);
    js.executeScript("mobile: swipe", swipeObject);
     }
	
public static void scrollToElement(String text){
		
		try {
			driver.scrollTo(text);
			testStepPassed("Perfomed Scroll to the element successfully");
		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}
	
}
