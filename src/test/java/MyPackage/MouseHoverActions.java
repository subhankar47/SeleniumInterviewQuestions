package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
        WebElement desk_menu = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement mac_menu = driver.findElement(By.xpath("//a[text()='Mac (1)']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(desk_menu).moveToElement(mac_menu).click().perform();
		
	}

}
