package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopUp_Notification {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.facebook.com/");
		
		WebElement uid = driver.findElement(By.id("email"));
		uid.sendKeys("*********");
		WebElement upass = driver.findElement(By.id("pass"));
		upass.sendKeys("********");
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();
	}

}
