package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLookUpIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLinkText;

	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLinkText;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLinkText;

	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void logoutFromApplication(WebDriver d) {
		Actions actions = new Actions(d);
		actions.moveToElement(AdministratorLookUpIcon).perform();
		;
		SignOutLinkText.click();
	}

	public void clickOnOrganizationsLinkText() {
		OrganizationsLinkText.click();
	}

	public void clickOnContactsLinkText() {
		ContactsLinkText.click();
	}
}
