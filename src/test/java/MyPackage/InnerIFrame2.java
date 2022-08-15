package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerIFrame2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.manage().window().maximize();

		driver.switchTo().frame("iframeResult");// switch to Outer iframe
		driver.switchTo().frame(0);// switch to inner iframe
		System.out.println("Text inside the inner Iframe :- " + driver.findElement(By.xpath("//h1")).getText());
		driver.switchTo().parentFrame();// Go to the parent iframe/outer iframee
		String text = driver.findElement(By.xpath("//body//p")).getText();
		System.out.println("Text present in outer iframe is:- "+text);

	}

}
