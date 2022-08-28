package MyPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class uploadFile {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'Upload Resume')]")).click();
		
		//Using SendKeys()
		
		//driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("D:\\Xpath generate.txt");
		
		//Using Robot Class()
		WebElement button=driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);//Click action on the button
	
		Robot rb = new Robot();
		rb.delay(3000);
		
		//Put Path to file in clipboard
		
		StringSelection ss=new StringSelection("D:\\Xpath generate.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//CTRL+V
		
		rb.keyPress(KeyEvent.VK_CONTROL);// This command is Press on CTRL key in my Keyboard
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(3000);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(3000);
		
		//Enter Key Press
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		driver.close();
	}

}
