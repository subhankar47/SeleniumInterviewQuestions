package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		WebElement Inputbox = driver.findElement(By.xpath("//input[@id='age']"));
		String tooltip_text = Inputbox.getAttribute("title");
		System.out.println(tooltip_text);

	}

}
