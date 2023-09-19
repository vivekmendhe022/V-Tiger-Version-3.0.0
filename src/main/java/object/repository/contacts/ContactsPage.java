package object.repository.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateNewContactsLookUpImg;

	public ContactsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateNewContactsLookUpImg() {
		return CreateNewContactsLookUpImg;
	}

	public void clickOnCreateNewContactsLookUpImg() {
		CreateNewContactsLookUpImg.click();
	}

}
