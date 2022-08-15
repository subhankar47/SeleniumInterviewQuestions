package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIFrame1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
		WebElement outerframe = driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		driver.switchTo().frame(outerframe);// Here we are passing frame as WebElement

		WebElement innerframe = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(innerframe);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");

	}

}
