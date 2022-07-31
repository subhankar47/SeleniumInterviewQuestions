package MyPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		int brokenlinks = 0;
		for (WebElement element : links) {
			String url = element.getAttribute("href");
			
			if (url == null || url.isEmpty()) {
				System.out.println("URL Is Empty");
				continue;
			}
			URL linkUrl = new URL(url);

			try {
				HttpURLConnection httpcon = (HttpURLConnection) linkUrl.openConnection();
				httpcon.connect();
				if (httpcon.getResponseCode() >= 400) {
					System.out.println(httpcon.getResponseCode() + url + " Is broken link");
					brokenlinks++;
				} else {
					System.out.println(httpcon.getResponseCode() + url + " Is valid Link");
				}
			} catch (Exception e) {

				//e.printStackTrace();
			}
		}
		System.out.println("Number of Broken Links: " + brokenlinks);
		driver.quit();
	}

}
