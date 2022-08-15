package MyPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		// Explicit wait

		driver.findElement(By.name("q")).sendKeys("slenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		By elelocator = By.xpath("//h3[text()='Selenium']");
		waitForElementPresent(driver, elelocator, 10).click();

	}

    // Generic method by we can pass multiple WebElement
	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}

}
