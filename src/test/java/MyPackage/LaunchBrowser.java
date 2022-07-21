package MyPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void Chrome() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.nopcommerce.com/en");
		driver.manage().window().maximize();
		System.out.println("Title of the Web Page is: " + driver.getTitle());
		System.out.println("Current URL of the Web Page is: " + driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		// driver.quit();
	}

	public static void Firefox() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://amazon.com/");
		driver.manage().window().maximize();
		driver.quit();
	}

	public static void Edge() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.seleniumbymahesh.com/");
		driver.manage().window().maximize();
		driver.quit();
	}

	public static void main(String[] args) {
		Chrome();
		// Firefox();
		// Edge();
	}
}