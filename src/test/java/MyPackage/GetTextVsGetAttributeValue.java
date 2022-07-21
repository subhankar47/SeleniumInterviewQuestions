package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextVsGetAttributeValue {
	// user-admin, pass- admin
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/login");
		WebElement e = driver.findElement(By.id("Email"));
		e.sendKeys("mahesh");
		Thread.sleep(2000);
		e.clear();
		e.sendKeys("admin");
		// capturing text from inputbox
		System.out.println("Result from getAttribute(): " + e.getAttribute("value"));
		System.out.println("Result from getText(): " + e.getText());
		// Login Button
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		System.out.println(button.getAttribute("type"));
		System.out.println(button.getAttribute("class"));
		System.out.println(button.getText());
		String title = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
		System.out.println(title);
	}

}