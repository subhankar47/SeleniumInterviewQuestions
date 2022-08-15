package MyPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKartWebTableHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		Actions a = new Actions(driver);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Home')]"));
		a.moveToElement(element).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._2IjXr8")));
		
		String str = driver.findElement(By.cssSelector("div._2IjXr8")).getText();
		System.out.println(str);
		String[] s = str.split("\n");
		
		System.out.println("No. of value in Web table" + " " + s.length);

	}

}
