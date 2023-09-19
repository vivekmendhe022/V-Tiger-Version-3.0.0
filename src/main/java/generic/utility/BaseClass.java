package generic.utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.repository.HomePage;
import object.repository.LoginPage;

public class BaseClass {

	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();

	public WebDriver d = null;

	@BeforeSuite(groups = { "SmokeSuite", "RegressionSuite" })
	public void BSConfig() {
		System.out.println("***** Database Connected Successfully *****");
	}

//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void BCConfig() throws IOException {
		String BROWSER = putil.readDataFromPropertyFile("browser");
		switch (BROWSER) {
		case "chrome":
			d = new ChromeDriver();
			break;
		case "firefox":
			d = new FirefoxDriver();
			break;
		case "edge":
			d = new EdgeDriver();
			break;
		default:
			System.out.println("INVALID BROWSER NAME: " + BROWSER);
		}

		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		d.get("http://localhost:8888");
	}

	@BeforeMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void BMConfig() {
		String USERNAME = "admin";
		String PASSWORD = "admin";
		LoginPage lp = new LoginPage(d);
		lp.loginToApplication(USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "SmokeSuite", "RegressionSuite" })
	public void AMConfig() {
		HomePage hp = new HomePage(d);
		hp.logoutFromApplication(d);
	}

//	@AfterTest(groups = { "SmokeSuite", "RegressionSuite" })
	@AfterClass(groups = { "SmokeSuite", "RegressionSuite" })
	public void ACConfig() {
		d.quit();
	}

	@AfterSuite(groups = { "SmokeSuite", "RegressionSuite" })
	public void ASConfig() {
		System.out.println("***** Database Closed Successfully *****");
	}

}
