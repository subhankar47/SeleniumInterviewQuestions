package MyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDropImages {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		WebElement img1 = driver.findElement(By.xpath("//li[1]"));
		WebElement img2 = driver.findElement(By.xpath("//li[2]"));
		WebElement img3 = driver.findElement(By.xpath("//li[3]"));
		
		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
		Actions actions=new Actions(driver);
		//Move the images into Trash....
		actions.dragAndDrop(img1, trash).perform();
		actions.dragAndDrop(img2, trash).perform();
		actions.dragAndDrop(img3, trash).perform();
		
	}

}
