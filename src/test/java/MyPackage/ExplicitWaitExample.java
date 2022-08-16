package MyPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		// Explicit wait
		WebDriverWait myWait= new WebDriverWait(driver,Duration.ofSeconds(10));
	
		driver.findElement(By.name("q")).sendKeys("slenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		WebElement element = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium']")));
		element.click();
	}

}
