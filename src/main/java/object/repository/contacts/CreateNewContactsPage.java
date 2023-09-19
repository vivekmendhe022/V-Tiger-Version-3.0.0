package object.repository.contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utility.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility {

	@FindBy(name = "salutationtype")
	private WebElement FirstNameSalutationTypeDropDownList;

	@FindBy(name = "firstname")
	private WebElement FirstNameTextField;

	@FindBy(name = "lastname")
	private WebElement LastNameTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public CreateNewContactsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getFirstNamealutationTypeDropDownList() {
		return FirstNameSalutationTypeDropDownList;
	}

	public WebElement getFirstNameTextField() {
		return FirstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return LastNameTextField;
	}

	public void createNewContacts(String SalutationType, String FIRSTNAME, String LASTNAME) {
		FirstNameSalutationTypeDropDownList.click();
		handleDropDown(FirstNameSalutationTypeDropDownList, SalutationType);
		FirstNameTextField.clear();
		FirstNameTextField.sendKeys(FIRSTNAME);
		LastNameTextField.clear();
		LastNameTextField.sendKeys(LASTNAME);
		SaveBtn.click();
	}

}
