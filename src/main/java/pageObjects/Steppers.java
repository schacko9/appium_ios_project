package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Steppers {
	protected static IOSDriver<MobileElement> driverr;
	
	public Steppers(IOSDriver<MobileElement> driver)
	{
		driverr = driver;
		
		try{
			//PageFactory.initElements(driverr, this);
			PageFactory.initElements(new AppiumFieldDecorator(driverr, Duration.ofSeconds(10)), this);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	
	@iOSXCUITFindBy(id="Steppers")
	public MobileElement steppers;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeButton[@name=\"Increment\"])[1]")
	public MobileElement increment;
	
	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"0\"])[1]")
	public MobileElement value;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='UIKitCatalog']")
	public MobileElement backButton;
	
	
	
	
	public void getSteppers()
	{	
		steppers.click();
	}
	
	public void getBackButton()
	{	
		backButton.click();
	}
	

	public void incrementBy(int Value) throws InterruptedException
	{	
		for(int i=0; i<Value; i++) {
			increment.click(); 
		}	
	}
	
	
	
}
