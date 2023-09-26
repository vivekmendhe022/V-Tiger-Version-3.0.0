package CompatilityTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C_B2 {

	RemoteWebDriver driver;

	public static final String USERNAME = "vivekanandmendhe_67dHA2";
	public static final String AUTOMATE_KEY = "qZKSGzxRBByQXbSzp1ps";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@DataProvider(name = "Data", parallel = true)
	public Object[][] getData() {
		Object[][] test = new Object[][] { { Platform.WINDOWS, "chrome", "109" },
				{ Platform.WINDOWS, "firefox", "116" }, { Platform.MAC, "chrome", "80" } };
		return test;
	}

	@Test(dataProvider = "Data")
	public void browserRun(Platform platform, String BName, String BVersion)
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(platform);
		cap.setBrowserName(BName);
		cap.setVersion(BVersion);
		cap.setCapability("name", BName);
		cap.setCapability("browserstack.debug", true);

		driver = new RemoteWebDriver(new URL(URL), cap);
		driver.get("https://github.com/vivekmendhe022/VTiger-ProjectV3.0.0");
		Thread.sleep(2000);
		driver.quit();

	}
}
