package MyPackage;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookie {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");

		// How to capture Cookies from browser
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of Cookie is: " + cookies.size());

		// How to print cookies from browser
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}

		// How To add cookie To the browser
		Cookie cookie = new Cookie("My cookie123", "789654");
		driver.manage().addCookie(cookie);

		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookie After adding: " + cookies.size());

		// How To delete the Specific Cookie from the browser?
		driver.manage().deleteCookie(cookie);
		//driver.manage().getCookieNamed("My cookie123");

		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookie After deletion: " + cookies.size());

		// How To Delete All the Cookie from the browser?
		driver.manage().deleteAllCookies();

		cookies = driver.manage().getCookies();
		System.out.println("Size of Cookie After deletion: " + cookies.size());
		driver.quit();
	}

}
