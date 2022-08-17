package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClickActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		driver.switchTo().frame("iframeResult");
		WebElement textbox1 = driver.findElement(By.xpath("//input[@id='field1']"));
		textbox1.clear();
		textbox1.sendKeys("Welcome to Selenium");
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
		Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
	}

}
