package MyPackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropDown {
	// public static Select s, s1, s2;
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.kalyanmatrimony.com/");

		// Approach-1
		/*
		 * Select s = new Select(driver.findElement(By.name("profileForId")));
		 * s.selectByVisibleText("Myself"); Select s1 = new
		 * Select(driver.findElement(By.name("gender")));
		 * s1.selectByVisibleText("Male"); Select s2 = new
		 * Select(driver.findElement(By.name("motherTongueId")));
		 * s2.selectByVisibleText("Hindi");
		 */
		// Approach-2
		WebElement we = driver.findElement(By.name("profileForId"));
		selectOptionFromDropDown(we, "Myself");
		WebElement we1 = driver.findElement(By.name("gender"));
		selectOptionFromDropDown(we1, "Male");
		WebElement we2 = driver.findElement(By.name("motherTongueId"));
		selectOptionFromDropDown(we2, "Hindi");
	}

	public static void selectOptionFromDropDown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List<WebElement> alloptions = drp.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}