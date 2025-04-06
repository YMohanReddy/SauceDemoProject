package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	public static long implicitly_Wait = 0;
//	public static long explicit_Wait = 6;
	public static long pageLoadTimeOut = 10;
	
	public static WebElement explicitlyWaitForElement(WebDriver driver, WebElement element, int explicit_Wait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicit_Wait));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
}
