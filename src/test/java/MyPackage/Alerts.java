package MyPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		// Alert Window with OK Button
		/*
		 * driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		 * Thread.sleep(3000);
		 * driver.switchTo().alert().accept();
		 */
		// Alert Window with OK and cancel Button
		/*
		 * driver.findElement(By.
		 * xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		 * //driver.switchTo().alert().accept();// Close alert by using OK button
		 * Thread.sleep(3000); 
		 * driver.switchTo().alert().dismiss();// dismiss alert by using cancel button
		 */
		// Alert Window With Input Box, Capture Text From Alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Thread.sleep(3000);
		Alert alertwindow = driver.switchTo().alert();
		System.out.println("The message displayed on alert is:- " + alertwindow.getText());
		alertwindow.sendKeys("Welcome");
		alertwindow.accept();
		
	}

}
