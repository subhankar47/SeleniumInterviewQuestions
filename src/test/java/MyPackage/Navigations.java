package MyPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.snapdeal.com");
		//driver.get("https://www.amazon.com");
		driver.navigate().to("https://www.amazon.com");
		driver.navigate().back();// snapdeal page
		driver.navigate().forward();// amazon
		
		driver.navigate().refresh();// Refresh or reload the page
	}
}