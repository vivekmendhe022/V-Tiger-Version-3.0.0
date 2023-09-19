package generic.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	public void handleDropDown(WebElement element, String VisibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(VisibleText);
	}

}
