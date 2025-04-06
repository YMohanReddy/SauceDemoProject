package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;

public class LoginPage extends BaseTest {
	@FindBy(id = "user-name")
	WebElement userIdTextBox;

	@FindBy(id = "password")
	WebElement passwordTextBox;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public HomePage login() {
		userIdTextBox.click();

		userIdTextBox.sendKeys(properties.getProperty("UserId"));
		userIdTextBox.submit();


		passwordTextBox.sendKeys(properties.getProperty("Password"));
		passwordTextBox.submit();

		//after login we will land in home page, so we are creating home page obj and sending from here
		return new HomePage();
	}
	public void loginWithValidCredentials(String userName, String password) {
		userIdTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
	}
}
