package MyPackage;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// Full page screenshot
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\ScreenShot\\homepage.png");
		FileUtils.copyFile(src, trg);*/
		
		//Screenshot of some portion of page
		/*WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src = section.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\ScreenShot\\featured_products.png");
		FileUtils.copyFile(src, trg);*/
		
		//Capture the screenshot of specific WebElement
		WebElement ele = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src = ele.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\ScreenShot\\logo.png");
		FileUtils.copyFile(src, trg);
	}

}
