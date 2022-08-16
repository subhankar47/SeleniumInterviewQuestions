package MyPackage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_DropDown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='departon']")).click();
		// Month and year Selection
		Select month_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month_drp.selectByVisibleText("Dec");
		Select year_drp = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year_drp.selectByVisibleText("2022");

		String date = "15";
		//Date Selction
		
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement ele : alldates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				ele.click();
				break;
			}

		}

	}

}
