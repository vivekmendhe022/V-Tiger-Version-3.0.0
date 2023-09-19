package object.repository.organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationsLookUpImg;

	public OrganisationPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getCreateOrganizationsLookUpImg() {
		return createOrganizationsLookUpImg;
	}

	public void clickOnCreateOrganizationsLookUpImg() {
		createOrganizationsLookUpImg.click();
	}

}
