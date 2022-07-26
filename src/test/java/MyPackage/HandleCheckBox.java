package MyPackage;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		// 1) Select Specific check-Box
		// driver.findElement(By.xpath("//input[@id='monday']")).click();

		// 2) Select All the check boxes
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total no of check boxes: " + checkboxes.size());
		// using for() loop
		/*
		 * for (int i = 0; i < checkboxes.size(); i++) { 
		 * checkboxes.get(i).click(); 
		 * }
		 */
		// using for each loop
		/*
		 * for(WebElement cbox:checkboxes) { 
		 * cbox.click(); 
		 * }
		 */
		// 3) select multiple check boxes by choice
		// Monday and SundayS
		/*for (WebElement cbox : checkboxes) {
			String checkboxname = cbox.getAttribute("id");
			if (checkboxname.equals("monday") || checkboxname.equals("sunday")) {
				cbox.click();
			}
		}*/
		//4) Select Last 2 Check Boxes
		//Total no of check boxes-no of check boxes want to select=starting index
		//7-2=5
		int totalcheckboxes=checkboxes.size();
		/*for(int i=totalcheckboxes-2;i<totalcheckboxes;i++) {
			checkboxes.get(i).click();
		}*/
		//5) Select First 2 check Boxes
		//
		for(int i=0;i<totalcheckboxes;i++) {
			if(i<3) {
			checkboxes.get(i).click();
			}
		}

	}
}
