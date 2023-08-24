package GenericUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utilities {
	public  void scrollAction(WebDriver driver)	
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	public  void windowHandle(WebDriver driver)
	{

	Set<String> window = driver.getWindowHandles();
	List<String> newwin = new ArrayList<String>(window);
	driver.switchTo().window(newwin.get(1));
	}
}
