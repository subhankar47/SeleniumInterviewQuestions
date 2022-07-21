package MyPackage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsFindElements {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		// findelement()-->Single WebElement

		WebElement s = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		s.sendKeys("xyz");
		// findElements--> multiple WebElements
		
		List<WebElement> link = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println("No. of veriable capture: " + link.size());// 22
		for (WebElement elements : link) {
			System.out.println(elements.getText());
		}
	}

}