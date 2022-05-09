package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import pageObjects.AlertViews;
import pageObjects.PickerView;
import pageObjects.Sliders;
import pageObjects.Steppers;
import pageObjects.Switches;
import pageObjects.WebView;
import utils.base;

import java.io.IOException;


public class UIKitCatalogTest extends base{
	
	public static IOSDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException, IOException {
		driver = capabilities("UIKitCatalogApp");
		Thread.sleep(5000);
	}
	

	@Test
	public void AlertViewsTest() throws InterruptedException, IOException {
		AlertViews alert = new AlertViews(driver);
		
		alert.getAlertViews();
		alert.getTextEntry();
		alert.getTextbox().sendKeys(getProperty("name"));
		alert.getOk();
		
		alert.getConfirmCancel();
		alert.getConfirm();
		
		alert.getBackButton();
	}
	
	
	@Test(dependsOnMethods = {"AlertViewsTest"})
	public void WebViewTest() throws IOException, InterruptedException{
		WebView web = new WebView(driver);

		scroll(driver, getProperty("direction"), getProperty("selection"));
		web.getwebView();
		
		web.getBackButton();
	}
		
	
	@Test(dependsOnMethods = {"WebViewTest"})
	public void PickerViewTest() throws IOException, InterruptedException{
		PickerView picker = new PickerView(driver);
		
		picker.getPickerView();
		picker.getRedColor().sendKeys(getProperty("red"));
		picker.getGreenColor().sendKeys(getProperty("green"));
		picker.getBlueColor().sendKeys(getProperty("blue"));

		picker.getBackButton();
	}

	
	@Test(dependsOnMethods = {"PickerViewTest"})
	public void SlidersTest() throws IOException, InterruptedException{
		Sliders sliders = new Sliders(driver);

		sliders.getSliders();
		sliders.getSlider().sendKeys(getProperty("percentage"));
		
		sliders.getBackButton();	
	}
	
						
	@Test(dependsOnMethods = {"SlidersTest"})
	public void SteppersTest() throws IOException, InterruptedException{
		Steppers steppers = new Steppers(driver);
		
		steppers.getSteppers();
		steppers.incrementBy(5);
		
		steppers.getBackButton();
	}
	
	
	@Test(dependsOnMethods = {"SteppersTest"})
	public void SwitchesTest() throws IOException, InterruptedException{
		Switches switches = new Switches(driver);
		
		switches.getSwitches();
		switches.tapSwitchBtn();
		
		switches.getBackButton();
	}
	
	
	@AfterTest
	public void teardown() throws IOException, InterruptedException {
		driver.quit();
		stopEmulator();
	}
	
	


}
