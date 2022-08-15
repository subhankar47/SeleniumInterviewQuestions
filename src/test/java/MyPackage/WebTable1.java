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
 5. Print Company name, Contact and country
 */
public class WebTable1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();

		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[4]/td[1]
		// *[@id="customers"]/tbody/tr[7]/td[1]

		// 1. How many rows in a table
		int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		System.out.println("Total rows in a WebTable :" + row);

		System.out.println("********************");

		// 3.Retrieve the Specific row/column data
		String value = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[7]/td[1]")).getText();
		System.out.println(value);

		System.out.println("********************");
		// 3. Retrieve the Specific row data
		String beforexpath = "//*[@id='customers']/tbody/tr[";
		String afterxpath = "]/td[1]";
		for (int i = 2; i <= row; i++) {
			String actualxpath = beforexpath + i + afterxpath;
			WebElement element = driver.findElement(By.xpath(actualxpath));
			System.out.println(element.getText());
			if (element.getText().equals("Island Trading")) {
				System.out.println("Company name: " + element.getText() + "is found" + " at position=" + (i - 1));
				break;
			}
		}
		System.out.println("********************");
		// 3. Retrieve the Specific row data
		// *[@id="customers"]/tbody/tr[2]/td[2]
		String afterxpathcontact = "]/td[2]";
		for (int i = 2; i <= row; i++) {
			String actualxpath = beforexpath + i + afterxpathcontact;
			WebElement element = driver.findElement(By.xpath(actualxpath));
			System.out.println(element.getText());
		}
		System.out.println("********************");
		// 3. Retrieve the Specific row data
		// *[@id="customers"]/tbody/tr[2]/td[3]

		String afterxpathcountry = "]/td[3]";
		for (int i = 2; i <= row; i++) {
			String actualxpath = beforexpath + i + afterxpathcountry;
			WebElement element = driver.findElement(By.xpath(actualxpath));
			System.out.println(element.getText());
		}
		System.out.println("********************");
		// 2. How many columns in a table
		// *[@id="customers"]/tbody/tr[1]/th[1]
		// *[@id="customers"]/tbody/tr[1]/th[2]
		// *[@id="customers"]/tbody/tr[1]/th[3]

		String colbeforexpath = "//*[@id='customers']/tbody/tr[1]/th[";
		String colafterxpath = "]";
		int column = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
		System.out.println("Total rows in a WebTable :" + column);
		System.out.println("Columns Values are:-");
		for (int i = 1; i <= column; i++) {
			String actualxpath = colbeforexpath + i + colafterxpath;
			WebElement element = driver.findElement(By.xpath(actualxpath));
			System.out.println(element.getText());
		}
		System.out.println("********************");
		// 4. Retrieve all the data in a table
		/*
		 * System.out.println("Data from the table:-----"); for (int r = 2; r <= row;
		 * r++) { for (int c = 1; c <= column; c++) { String data =
		 * driver.findElement(By.xpath("//table[@id='customers']//tr[" + r + "]/td[" + c
		 * + "]")) .getText(); System.out.print(data+"  "); } System.out.println(); }
		 */
		// 5.Print Company name, Contact and country
		for (int r = 2; r <= row; r++) {
			String company = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + r + "]/td[1]"))
					.getText();
			if (company.equals("Ernst Handel")) {
				String contact = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + r + "]/td[2]"))
						.getText();
				String country = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + r + "]/td[3]"))
						.getText();
				System.out.println(company + " " + contact + " " + country);
			}
		}
		driver.quit();
	}

}
