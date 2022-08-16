package MyPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		String year = "2022";
		String month = "Dec";
		String date = "10";
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();// Open the DatePicker
		while (true) {
			String monthyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			if (mon.equalsIgnoreCase(month) && (yr.equals(year)))
				break;
			else
				driver.findElement(By.xpath("//td[@class='next']")).click();
		}

		// Date Selcetion
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		for (WebElement ele : alldates) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				ele.click();
				break;
			}

		}

	}

}
