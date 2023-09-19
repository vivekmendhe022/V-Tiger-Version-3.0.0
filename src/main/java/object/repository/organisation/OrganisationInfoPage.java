package object.repository.organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgInfoHeader;

	public OrganisationInfoPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getOrgInfoHeader() {
		return OrgInfoHeader;
	}

	public String getOrgHeaderText() {
		return OrgInfoHeader.getText();
	}

}
