package MyPackage;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

	public static void main(String[] args) {

		String location = System.getProperty("user.dir") + "\\Downloads\\";
		// Chrome
		/*
		 * HashMap preferences = new HashMap();
		 * preferences.put("download.default_directory", location);
		 * 
		 * ChromeOptions options = new ChromeOptions();
		 * options.setExperimentalOption("prefs", preferences);
		 */
		// Edge
		/*
		 * HashMap preferences = new HashMap();
		 * preferences.put("download.default_directory", location);
		 * 
		 * EdgeOptions options = new EdgeOptions();
		 * options.setExperimentalOption("prefs", preferences);
		 */

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		try {
			driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
