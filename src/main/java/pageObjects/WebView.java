package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WebView{

	protected static IOSDriver<MobileElement> driverr;
	
	public WebView(IOSDriver<MobileElement> driver)
	{
		driverr = driver;
		
		try{
			//PageFactory.initElements(driverr, this);
			PageFactory.initElements(new AppiumFieldDecorator(driverr, Duration.ofSeconds(10)), this);
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	@iOSXCUITFindBy(id="Web View")
	public MobileElement webView;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name='UIKitCatalog']")
	public MobileElement backButton;
	
	
	public void getwebView() throws InterruptedException
	{	
		webView.click();
		Thread.sleep(1000);
	}
	
	public void getBackButton()
	{	
		backButton.click();
	}
	
	
}
