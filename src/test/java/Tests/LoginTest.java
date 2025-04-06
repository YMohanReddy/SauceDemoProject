package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Utilities.Constants;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
	public LoginTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Parameters({"username", "password"})
	@Test
	public void validateLogin(@Optional("standard_user") String username,@Optional("secret_sauce") String password) {
		loginPage.loginWithValidCredentials(username, password);
	}
	
	@Test
	public void validateInvalidLogin() {
		loginPage.loginWithValidCredentials("standard_user", "secret_sauce123");
		Assert.assertEquals(loginPage.checkErrorMessage(), Constants.errorMessage);
	}
}
