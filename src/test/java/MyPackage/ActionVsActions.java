package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Action;

public class ActionVsActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

		WebElement features = driver.findElement(By.xpath("//a[text()='Women']"));
		Actions actions = new Actions(driver);
		//actions.moveToElement(features).perform();
		// If we use build().perform() method then build() is calling 2 times bcoz
		// inside perform() is include->build().perform() is present.
		//build()-> is just create an action
		
		actions.moveToElement(features).build().perform();
		Action act=actions.moveToElement(features).build();
		act.perform();
	}

}
