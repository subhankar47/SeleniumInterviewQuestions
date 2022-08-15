package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HadleIFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		// 1st iframe
		driver.switchTo().frame("packageListFrame");// Name of the frame
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		driver.switchTo().defaultContent();//Go back to the main page
		Thread.sleep(3000);
		
		// 2nd iframe
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[text()='WebDriver']")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		//3rd iframe
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Help']")).click();//help
		driver.switchTo().defaultContent();

	}

}
