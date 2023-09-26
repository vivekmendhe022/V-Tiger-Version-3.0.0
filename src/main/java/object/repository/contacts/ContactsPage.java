package object.repository.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement CreateNewContactsLookUpImg;

	@FindBy(id = "selectCurrentPageRec")
	private WebElement SelectAllCheckBox;

	@FindBy(id = "selectAllRec")
	private WebElement SelectAllRecordsText;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement DeleteBtn;

	public ContactsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateNewContactsLookUpImg() {
		return CreateNewContactsLookUpImg;
	}

	public void clickOnCreateNewContactsLookUpImg() {
		CreateNewContactsLookUpImg.click();
	}

	public void deleteAllCotactsData(WebDriver d) throws InterruptedException {
		SelectAllCheckBox.click();
		boolean displayed = SelectAllRecordsText.isDisplayed();
		if (displayed == true) {
			waitForElementToBeClickAble(d, SelectAllRecordsText);
		}
		DeleteBtn.click();
		Thread.sleep(3000);
		handlePopUp(d);
	}
}
