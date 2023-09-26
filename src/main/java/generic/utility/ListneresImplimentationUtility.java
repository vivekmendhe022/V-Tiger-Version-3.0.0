package generic.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListneresImplimentationUtility implements ITestListener {

	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "***** Test Execution Start Successfull *****");

		test = reports.createTest(methodName);
		test.log(Status.INFO, methodName + " execution start.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "***** TestScript Passed *****");
		test.log(Status.PASS, methodName + " script passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "***** TestScript Failed *****");
		test.log(Status.FAIL, methodName + " test script failed.");
		test.log(Status.WARNING, result.getThrowable());

		// Take Failed Test Scripts Script Screenshot
		String src = methodName + " - " + new JavaUtility().getDateInFormate();
		WebDriverUtility wutil = new WebDriverUtility();
		try {
			String path = wutil.takeScreenShot(BaseClass.SDriver, src);
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "***** TestScript Skipped *****");
		test.log(Status.SKIP, methodName + " test script skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("***** Execution Start *****");
		String path = ".\\ExtentReports\\Report\\" + new JavaUtility().getDateInFormate() + ".html";
		ExtentSparkReporter html = new ExtentSparkReporter(path);

		// Document Title
		html.config().setDocumentTitle("My Automation Report");
		// Set the title of the report document

		// Report Name
		html.config().setReportName("Web Automation Results");
		// Set the name of the report

		// Theme
		html.config().setTheme(Theme.DARK);
		// Set the theme of the report. Options include: DARK, STANDARD

		// Timestamp Format
		html.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		// Set the format of the timestamp

		// Add custom CSS
		html.config().setCss(".r-img { width: 50%; }");
		// You can inject custom CSS to style the report according to your needs

		// Add custom JavaScript
		html.config().setJs("$('.brand-logo').text('My Company');");
		// You can inject custom JavaScript for more dynamic behaviors

		// Set Encoding
		html.config().setEncoding("utf-8");
		// Set the character encoding for the report

		// Set Protocol for resources
		html.config().setProtocol(Protocol.HTTPS);
		// Set the protocol for resources (scripts, stylesheets, etc.). Options include:
		// HTTP, HTTPS

		// Initialize the ExtentReports object
		reports = new ExtentReports();
		reports.attachReporter(html);
		reports.setSystemInfo("Browser name", "Chrome");
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Base Platform", "Windows 11");
		reports.setSystemInfo("Reporter name", "Test Engineer");
		reports.setSystemInfo("Environment", "Production");
		reports.setSystemInfo("Sprint", "Sprint 12");
		reports.addTestRunnerOutput("Tag: Regression");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("***** Execution Finished *****");
		reports.flush(); // responsible for report ganeration
	}

}
