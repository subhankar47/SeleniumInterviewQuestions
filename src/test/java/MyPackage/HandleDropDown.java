package MyPackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		WebElement we = driver.findElement(By.id("input-country"));
		Select s = new Select(we);
		// s.selectByVisibleText("Denmark");
		// s.selectByValue("10");// Argentina
		// s.selectByIndex(13);//Australia

		// Selecting Option from DropDown without using option
		List<WebElement> alloptions = s.getOptions();
		for (WebElement e : alloptions) {
			if (e.getText().equals("Cuba")) {
				e.click();
				break;
			}
		}
	}

}