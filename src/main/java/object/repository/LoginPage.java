package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement username;
	
	@FindBy(name = "user_password")
	private WebElement password;
	
	@FindBy(id = "submitButton")
	private WebElement LoginBtn;

	public LoginPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}
	
	public void loginToApplication(String USERNAME, String PASSWORD) {
		username.clear();
		username.sendKeys(USERNAME);
		password.clear();
		password.sendKeys(PASSWORD);
		LoginBtn.click();
	}
	
}
