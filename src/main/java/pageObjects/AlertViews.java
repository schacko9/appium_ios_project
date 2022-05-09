package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews {
	
	protected static IOSDriver<MobileElement> driverr;
	
	public AlertViews(IOSDriver<MobileElement> driver)
	{
		driverr = driver;
		
		try{
			//PageFactory.initElements(driverr, this);
			PageFactory.initElements(new AppiumFieldDecorator(driverr, Duration.ofSeconds(10)), this);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	
	@iOSXCUITFindBy(id="Alert Views")
	public MobileElement alertViews;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name='Text Entry']")
	public MobileElement textEntry;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeAlert")
	public MobileElement textBox;
	
	@iOSXCUITFindBy(id="OK")
	public MobileElement ok;
	
	@iOSXCUITFindBy(id="Confirm / Cancel")
	public MobileElement confirmCancel;
	
	@iOSXCUITFindBy(id="Confirm")
	public MobileElement confirm;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='UIKitCatalog']")
	public MobileElement backButton;
	
	
	public void getAlertViews()
	{	
		alertViews.click();
	}
	
	public void getTextEntry()
	{	
		textEntry.click();
	}
	
	public MobileElement getTextbox()
	{	
		return textEntry;
	}
	
	public void getOk()
	{	
		ok.click();
	}
	
	public void getConfirmCancel()
	{	
		confirmCancel.click();
	}
	
	public void getConfirm()
	{	
		confirm.click();
	}
	
	public void getBackButton()
	{	
		backButton.click();
	}
}

