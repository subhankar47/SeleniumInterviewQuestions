package MyPackage;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();

		// Login
		WebElement username = driver.findElement(By.id("input-username"));
		username.clear();
		username.sendKeys("demo");
		WebElement password = driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		// Sales-->Order
		driver.findElement(By.xpath("//a[contains(text(),'Sales')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();

		// 1. Total no of Pages in a table
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(text);
		int total_pages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println(total_pages);
		// 2.How Many rows exits in each pages

		for (int p = 1; p <= 6; p++) {
			try {
				Thread.sleep(5000);
				WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
				System.out.println("Active Page:" + active_page.getText());
				active_page.click();
				int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr"))
						.size();
				System.out.println("No of rows:-" + rows);
				// 3.Read all the rows from each page

				for (int r = 1; r <= rows; r++) {

					String orderId = driver
							.findElement(By.xpath(
									"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]"))
							.getText();
					String store = driver
							.findElement(By.xpath(
									"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]"))
							.getText();
					String customer = driver
							.findElement(By.xpath(
									"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]"))
							.getText();
					String status = driver
							.findElement(By.xpath(
									"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[5]"))
							.getText();
					if (status.equals("Pending")) {
						System.out.println(orderId + "  " + store + "  " + customer + "  " + status);
					}
				}
				String pageno = Integer.toString(p + 1);
				driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + pageno + "']")).click();

			} catch (Exception e) {

			}

		}
	}

}
