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

public class JavaScriptsExecutorDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// Drawing border and Take screenshot
		/*WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptsUtil.drawBorder(logo, driver);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\ScreenShot\\draw_logo.png");
		FileUtils.copyFile(src, trg);*/

		// getting the title of the WebPage
		//String title = JavaScriptsUtil.getTitleByJs(driver);
		//System.out.println(title);

		//Click Action
		//WebElement reglink = driver.findElement(By.xpath("//a[text()='Register']"));
		//JavaScriptsUtil.clickElementByJS(reglink, driver);
		
		//Generate Alert
		//JavaScriptsUtil.generateAlert(driver, "This is my Alert");
		
		//Refresh the Page
		//JavaScriptsUtil.refreshBrowserByJS(driver);
		
		//Scrolling Page Down
		//JavaScriptsUtil.scrollPageDown(driver);
		//Thread.sleep(4000);
		
		//Scrolling Page Up
		//JavaScriptsUtil.scrollPageUP(driver);
		
		//Zoom Page
		//JavaScriptsUtil.zoomPageByJS(driver);
		
		//flash an Element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptsUtil.flash(logo, driver);
		
	}

}
