package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOfElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']//img"));
		// Location Method1
		System.out.println("Location of(X,Y):-" + logo.getLocation());// (340,75)
		System.out.println("Location of(X,Y):-" + logo.getLocation().getX());// 340
		System.out.println("Location of(X,Y):-" + logo.getLocation().getY());// 75

		// Location Method2
		System.out.println("Location of(X,Y):-" + logo.getRect().getX());
		System.out.println("Location of(X,Y):-" + logo.getRect().getY());

		// Size()
		System.out.println("Size (Width,Height):-" + logo.getSize());
		System.out.println("Size of(Width):-" + logo.getSize().getWidth());
		System.out.println("Size of(Height):-" + logo.getSize().getHeight());

		// Dimension
		System.out.println("Size of(Width):-" + logo.getRect().getDimension().getWidth());
		System.out.println("Size of(Height):-" + logo.getRect().getDimension().getHeight());

		driver.close();
	}

}
