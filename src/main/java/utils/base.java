package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	public static IOSDriver driver;

	public static IOSDriver capabilities(String appName) throws IOException, InterruptedException {

		File appDir = new File("src/main/java/resources");
		File app = new File(appDir, base.getProperty(appName));
		String deviceName = System.getProperty("deviceName");
		String udid = System.getProperty("udid");

		startEmulator();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability("udid", udid);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, 50000);
		cap.setCapability("commandTimeouts", "12000");

		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Driver Running");

		return driver;
	}

	public static String getProperty(String value) throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		return (String) prop.get(value);
	}

	public static void scroll(IOSDriver<MobileElement> driver, String direction, String value)
			throws InterruptedException {
		HashMap<String, Object> scroll = new HashMap<>();
		scroll.put("direction", direction);
		scroll.put("name", value);

		driver.executeScript("mobile:scroll", scroll);
		Thread.sleep(1000);
	}

	public static void getScreenshot(String testName) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/reports/" + testName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}

	
	
	
	public static void startEmulator() throws IOException, InterruptedException {

		String type = System.getProperty("type");
		if (type.equalsIgnoreCase("emulator")) {
			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/main/java/resources/startIOSEmulator.bat");
			System.out.println("Emulator Started");
			Thread.sleep(25000);
		}
	}

	public static void stopEmulator() throws IOException, InterruptedException {

		String type = System.getProperty("type");
		if (type.equalsIgnoreCase("emulator")) {
			Runtime.getRuntime().exec("killall Simulator");
			System.out.println("Emulator Stopped");
		}
	}
}
