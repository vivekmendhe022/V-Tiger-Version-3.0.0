package object.repository.organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utility.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility {

	@FindBy(name = "accountname")
	private WebElement OrgNameTextField;

	@FindBy(name = "industry")
	private WebElement IndustryDropDownList;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewOrganisationPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getOrgNameTextField() {
		return OrgNameTextField;
	}

	public WebElement getIndustryDropDownList() {
		return IndustryDropDownList;
	}

	public void createOrgWithIndustry(WebDriver d, String ORGNAME, String INDUSTRYNAME) {
		OrgNameTextField.clear();
		OrgNameTextField.sendKeys(ORGNAME);
		IndustryDropDownList.click();
		handleDropDown(IndustryDropDownList, INDUSTRYNAME);
		SaveBtn.click();
	}

}
