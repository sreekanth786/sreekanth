package SWAUT;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;


import AutomationFramework.GenericKeywords;

public class ApplicationKeywords extends GenericKeywords {

	public static String url = "";
	public static String sessionLog = "";

	public static void scrollToExact(String text) {
		try {
			driver.scrollToExact(text);
			testStepPassed("Scroll to exact '" + text + "' text");
		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}

	public static void lanuchApp() {
		try {
			driver.launchApp();
		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}

	public static void closeApp() {
		try {
			driver.closeApp();
		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}

	public static void getSessionFromFiddler() {
		try {
			sessionLog = "";
			Robot robot = new Robot();
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_S);
			Thread.sleep(2000);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			sessionLog = (String) clipboard.getData(DataFlavor.stringFlavor);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_SHIFT);
		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}

	public static void getHttpUrlFromFiddler(String type) {
		try {
			url = "";
			Robot robot = new Robot();
			robot.delay(5000);
			if (type.contains("request")) {
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.delay(1000);
				robot.keyPress(KeyEvent.VK_DOWN);
			}
			if (type.contains("adimageurl")) {
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.delay(1000);
			}
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_U);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			url = (String) clipboard.getData(DataFlavor.stringFlavor);

		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}

	public static void clearRequestResponseFromFiddler() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			testStepFailed(e.toString());
		}
	}
}
