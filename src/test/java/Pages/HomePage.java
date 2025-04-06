package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import Utilities.TestUtil;

public class HomePage extends BaseTest{

	@FindBy(className = "app_logo")
	WebElement appLogo_homePage;
	
	@FindBy(id ="react-burger-menu-btn")
	WebElement menuIcon_homePage;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cart;
	
	@FindBy(className ="product_sort_container")
	WebElement sortContainer;
	
	@FindBy(className = "footer_copy")
	WebElement footer_homePage;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean checkAppLogoIsVisible() {
		return TestUtil.explicitlyWaitForElement(driver, appLogo_homePage, 6).isDisplayed();
	}

	public Boolean checkMenuIcon() {
		return TestUtil.explicitlyWaitForElement(driver, menuIcon_homePage, 6).isDisplayed();
	}
	
	public Boolean checkCartIcon() {
		return TestUtil.explicitlyWaitForElement(driver, cart, 0).isDisplayed();
	}
	
	public Boolean checkSortContainer() {
		return TestUtil.explicitlyWaitForElement(driver, sortContainer, 0).isDisplayed();
	}
	
	public String footerText() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", footer_homePage);
		
//		System.out.println(footer_homePage.getText());
		 return footer_homePage.getText();
	}
	
}

