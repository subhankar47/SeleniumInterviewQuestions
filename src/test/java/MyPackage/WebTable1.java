package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 1. How many rows in a table
 2. How many columns in a table
 3. Retrieve the Specific row/column data
 4. Retrieve all the data in a table
 5. Print release date, Version no of java language of selenium
 */
public class WebTable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();

		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]

		String beforexpath = "//*[@id='customers']/tbody/tr[";
		String afterxpath = "]/td[1]";
		for (int i = 2; i <= 7; i++) {
			String actualxpath = beforexpath + i+ afterxpath;
            WebElement element=driver.findElement(By.xpath(actualxpath));
            System.out.println(element.getText());
            
		}

	}

}
