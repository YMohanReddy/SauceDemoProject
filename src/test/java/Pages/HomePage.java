package Pages;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseTest;
import Utilities.TestUtil;

public class HomePage extends BaseTest{

	@FindBy(className = "app_logo")
	WebElement appLogo_img;
	
	@FindBy(id ="react-burger-menu-btn")
	WebElement menuIcon_icon;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cart_icon;
	
	@FindBy(className ="product_sort_container")
	WebElement sortContainer;
	
	@FindBy(className = "footer_copy")
	WebElement footer_text;
	
	@FindBy(id = "inventory_sidebar_link")
	WebElement allItems_Link;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean checkAppLogoIsVisible() {
		return TestUtil.explicitlyWaitForElement(driver, appLogo_img, 6).isDisplayed();
	}

	public Boolean checkMenuIcon() {
		return TestUtil.explicitlyWaitForElement(driver, menuIcon_icon, 6).isDisplayed();
	}
	
	public Boolean checkCartIcon() {
		return TestUtil.explicitlyWaitForElement(driver, cart_icon, 0).isDisplayed();
	}
	
	public Boolean checkSortContainer() {
		return TestUtil.explicitlyWaitForElement(driver, sortContainer, 0).isDisplayed();
	}
	
	public String footerText() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", footer_text);
		
//		System.out.println(footer_homePage.getText());
		 return footer_text.getText();
	}
	
	public void sortDropDownList() {
		
		Select select = new Select(sortContainer);
		for(int i = 3; i>=0; i--) {
			sortContainer.click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			select.selectByIndex(i);
		}
	}
	
}

