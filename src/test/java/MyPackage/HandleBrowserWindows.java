package MyPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Part-15
public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		// getWindowHandle()
		// String windowID = driver.getWindowHandle();
		// System.out.println(windowID);//return ID of the single browser window
		
		// getWindowHandles()
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();//opens the another window-child window
		Set<String> windowIDs= driver.getWindowHandles();//return Is's of multiple browser windows
		//First method - iterator()
		/*Iterator<String> it = windowIDs.iterator();
		String parentwindowID = it.next();
		String childwindowID = it.next();
		System.out.println("Parent Window ID "+parentwindowID);
		System.out.println("Child Window ID "+childwindowID);*/
		
		//Second Method- using List/ArrayList
		List<String> windowIDList = new ArrayList(windowIDs);//Converting Set to List
		
		/*String parentwindowID = windowIDList.get(0);
		String childwindowID=windowIDList.get(1);
		
		System.out.println("Parent Window ID "+parentwindowID);
		System.out.println("Child Window ID "+childwindowID);
		
		//How to use window ID's for Switching
		driver.switchTo().window(parentwindowID);
		System.out.println("Parent Window Title:- "+ driver.getTitle());
		
		driver.switchTo().window(childwindowID);
		System.out.println("Child Window Title:- "+ driver.getTitle());*/
		
		//for each loop for capturing in oneshot
		/*for(String winid:windowIDList) {
			//System.out.println(winid);
			String title = driver.switchTo().window(winid).getTitle();
			System.out.println(title);
		}*/
		//driver.close();//It is close single browser driver
		//driver.quit();//It is close all the browser driver
		for(String winid:windowIDList) {
			//System.out.println(winid);
			String title = driver.switchTo().window(winid).getTitle();
			if(title.equals("OrangeHRM")) {
				driver.close();
			}
		}
	}

}
