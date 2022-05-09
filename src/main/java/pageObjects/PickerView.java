package pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PickerView {
	
	protected static IOSDriver<MobileElement> driverr;
	
	public PickerView(IOSDriver<MobileElement> driver)
	{
		driverr = driver;
		
		try{
			//PageFactory.initElements(driverr, this);
			PageFactory.initElements(new AppiumFieldDecorator(driverr, Duration.ofSeconds(10)), this);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	@iOSXCUITFindBy(id="Picker View")
	public MobileElement pickerView;
	
	@iOSXCUITFindBy(id="Red color component value")
	public MobileElement redColor;
	
	@iOSXCUITFindBy(id="Green color component value")
	public MobileElement greenColor;
	
	@iOSXCUITFindBy(id="Blue color component value")
	public MobileElement blueColor;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='UIKitCatalog']")
	public MobileElement backButton;
	
	
	public void getPickerView()
	{	
		pickerView.click();
	}
	
	public MobileElement getRedColor()
	{	
		return redColor;
	}
	
	public MobileElement getGreenColor()
	{	
		return greenColor;
	}
	
	public MobileElement getBlueColor()
	{	
		return blueColor;
	}
	
	public void getBackButton()
	{	
		backButton.click();
	}
	
}
