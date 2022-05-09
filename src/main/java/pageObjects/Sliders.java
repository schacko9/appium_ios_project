package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Sliders {
	protected static IOSDriver<MobileElement> driverr;
	
	public Sliders(IOSDriver<MobileElement> driver)
	{
		driverr = driver;
		
		try{
			//PageFactory.initElements(driverr, this);
			PageFactory.initElements(new AppiumFieldDecorator(driverr, Duration.ofSeconds(10)), this);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	@iOSXCUITFindBy(id="Sliders")
	public MobileElement sliders;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSlider")
	public WebElement slider;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='UIKitCatalog']")
	public MobileElement backButton;
	
	
	
	
	public void getSliders()
	{	
		sliders.click();
	}
	
	public WebElement getSlider()
	{	
		return slider;
	}
	
	public void getBackButton()
	{	
		backButton.click();
	}
	
	
}
