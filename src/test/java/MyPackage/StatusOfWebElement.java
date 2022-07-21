package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register/");
		// isDisplayed() isEnabled()
		WebElement searchStore = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Display Status: " + searchStore.isDisplayed());// True
		System.out.println("Display Status: " + searchStore.isEnabled());// True
		// isSelected()
		WebElement male = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female = driver.findElement(By.xpath("//input[@id='gender-female']"));
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		Thread.sleep(5000);
		male.click();
		System.out.println(male.isSelected());//true
		System.out.println(female.isSelected());//false
		Thread.sleep(5000);
		female.click();
		System.out.println(male.isSelected());//false
		System.out.println(female.isSelected());//true
	}

}