package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Constants;
import junit.framework.Assert;

public class HomePageTest extends BaseTest{
	LoginPage logInPage;
	HomePage homePage;

	@BeforeMethod
	public void setUP() {
		initialization();
		logInPage = new LoginPage();
		homePage = logInPage.login();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void validateAppLogo() {
		Assert.assertTrue(homePage.checkAppLogoIsVisible());
	}
	
	@Test
	public void validateHomePageElements() throws InterruptedException {
		Assert.assertTrue(homePage.checkAppLogoIsVisible());
		Assert.assertTrue(homePage.checkCartIcon());
		Assert.assertTrue(homePage.checkSortContainer());
		Assert.assertTrue(homePage.checkMenuIcon());
		
		
		Thread.sleep(4000);
		Assert.assertEquals(homePage.footerText(), Constants.footerText);
	}
	
	@Test
	public void validateSortContainer() {
		homePage.sortDropDownList();
	}
}
