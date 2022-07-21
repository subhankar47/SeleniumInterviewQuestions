package MyPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Verify_All_Browser {

	public static WebDriver driver;

	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.quit();
	}

	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://amazon.com/");
		driver.manage().window().maximize();
		driver.quit();
	}

	public static void Ie() {
		System.setProperty("webdriver.edge.driver", "D:\\Library\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("http://www.seleniumbymahesh.com/");
		driver.manage().window().maximize();
		driver.quit();
	}

	public static void main(String[] args) {
		Chrome();
		Firefox();
		Ie();
	}
}