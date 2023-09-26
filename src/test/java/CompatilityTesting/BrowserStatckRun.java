package CompatilityTesting;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

public class BrowserStatckRun {

	RemoteWebDriver d;

	public static final String BROWSERSTACK_USERNAME = "vivekanandmendhe_LdGfVP";
	public static final String BROWSERSTACK_ACCESS_KEY = "qf5gxy97MXP5m2axrgz7";
	public static final String BROWSERSTACK_END_POINT = "@hub-cloud.browserstack.com/wd/hub";
	public static final String URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	
//	public static final String USERNAME = "vivekanandmendhe_67dHA2";
//	public static final String AUTOMATE_KEY = "qZKSGzxRBByQXbSzp1ps";
//	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//

//	@DataProvider(name = "Data", parallel = true)
//	public Object[][] getData() {
//		Object[][] test = new Object[][] { { Platform.WINDOWS, "chrome", "117" },
//				{ Platform.WINDOWS, "firefox", "117" }, { Platform.MAC, "chrome", "80" } };
//		return test;
//	}
	
	

	@Test(dataProvider = "Data")
	public void browserRun(Platform platform, String BName, String BVersion)
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(platform);
		cap.setBrowserName(BName);
		cap.setVersion(BVersion);
		cap.setCapability("name", BName);
		cap.setCapability("browserstack.debug", true);

		d = new RemoteWebDriver(new URL(URL), cap);
//		d.get("https://github.com/vivekmendhe022/V-Tiger-Version-3.0.0.git");
		d.get("https://www.google.com");
		Thread.sleep(2000);
		d.quit();
	}
	
	@DataProvider(name = "Data", parallel = true)
	public Object[][] getData() {
		Object[][] test = new Object[][] { 
			{ Platform.WINDOWS, "chrome", "109" },
			{ Platform.WINDOWS, "firefox", "110" }, 
			{ Platform.MAC, "chrome", "80" } };
		return test;
	}
}
