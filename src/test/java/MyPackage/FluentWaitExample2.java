package MyPackage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("slenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		By elelocator = By.xpath("//h3[text()='Selenium']");
		waitForElementWithFluent( driver,  elelocator).click();
	}

	// Generic method by we can pass multiple WebElement
	public static WebElement waitForElementWithFluent(WebDriver driver, final By locator) {
		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class);

		WebElement element = myWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}
}
