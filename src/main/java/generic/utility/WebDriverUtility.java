package generic.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	/**
	 * This method will handle the drop down list using visible text.
	 * 
	 * @param element
	 * @param VisibleText
	 */
	public void handleDropDown(WebElement element, String VisibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(VisibleText);
	}

	/**
	 * This method will take screen shot of current web page.
	 * 
	 * @param d
	 * @param scrname
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver d, String scrname) throws IOException {
		String path = ".\\ScreenShots\\" + scrname + ".png";
		TakesScreenshot ts = (TakesScreenshot) d;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		Files.copy(scr, dst);
		return dst.getAbsolutePath();
	}

	/**
	 * This method will wait for element to be clickable state.
	 * 
	 * @param d
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This poup will handle alert popup of JavaScript Pop Up.
	 * 
	 * @param d
	 */
	public void handlePopUp(WebDriver d) {
		d.switchTo().alert().accept();
	}
}
