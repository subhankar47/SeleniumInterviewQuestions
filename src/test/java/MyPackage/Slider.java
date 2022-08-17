package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();

		WebElement min_slider = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Location of the min Slider:- " + min_slider.getLocation());
		System.out.println("Height and Width of the min Element:- " + min_slider.getSize());
		
		WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location of the max Slider:- " + max_slider.getLocation());
		System.out.println("Height and Width of the max Element:- " + max_slider.getSize());
		
		Actions actions= new Actions(driver);
		actions.dragAndDropBy(min_slider, 100, 250).perform();
		System.out.println("Location of the min Slider:- " + min_slider.getLocation());
		System.out.println("Height and Width of the min Element:- " + min_slider.getSize());
		actions.dragAndDropBy(max_slider, -100, 250).perform();
	}

}
