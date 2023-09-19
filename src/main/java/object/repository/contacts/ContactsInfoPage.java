package object.repository.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactsHeaderTextInfo;

	public ContactsInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getContactsHeaderTextInfo() {
		return ContactsHeaderTextInfo;
	}

	public String getContactsHeaderText() {
		return ContactsHeaderTextInfo.getText();
	}
}
