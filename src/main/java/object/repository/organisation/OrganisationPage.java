package object.repository.organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utility.WebDriverUtility;

public class OrganisationPage extends WebDriverUtility {

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationsLookUpImg;

	@FindBy(id = "selectCurrentPageRec")
	private WebElement SelectAllCheckBox;

	@FindBy(id = "selectAllRec")
	private WebElement SelectAllRecordsText;

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement DeleteBtn;

	public OrganisationPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateOrganizationsLookUpImg() {
		return createOrganizationsLookUpImg;
	}

	public void clickOnCreateOrganizationsLookUpImg() {
		createOrganizationsLookUpImg.click();
	}

	public void deleteAllOrgData(WebDriver d) throws InterruptedException {
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
