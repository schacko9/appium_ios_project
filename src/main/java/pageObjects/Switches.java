package pageObjects;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Switches {
	protected static IOSDriver<MobileElement> driverr;
	
	public Switches(IOSDriver<MobileElement> driver)
	{
		driverr = driver;
		
		try{
			//PageFactory.initElements(driverr, this);
			PageFactory.initElements(new AppiumFieldDecorator(driverr, Duration.ofSeconds(10)), this);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	
	@iOSXCUITFindBy(id="Switches")
	public MobileElement switches;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeApplication[@name=\"UIKitCatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeSwitch")
	public static MobileElement switchBtn;
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='UIKitCatalog']")
	public MobileElement backButton;
	
	
	
	public void getSwitches()
	{	
		switches.click();
	}
	

	public void tapSwitchBtn() {
		IOSTouchAction t = new IOSTouchAction(driverr);
		WebElement tap = (WebElement) switchBtn;
		
		t.tap(tapOptions().withElement(element(tap))).perform();
	}
	
	
	public void getBackButton()
	{	
		backButton.click();
	}
	
	
	
}
