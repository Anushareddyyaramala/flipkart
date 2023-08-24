package GenericUtilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class WebDriverUtilities {
	
	ExtentSparkReporter spark;

    ExtentReports extent;

    ExtentTest test;

    public WebDriverWait wait;
    public static WebDriver driver;
    
    WebDriverUtilities(WebDriver driver){
    	this.driver = driver;
    }
    
	/*
	 * Actions class mousehover
	 */
	public static void mouseHover( WebDriver driver,WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

	}
    
		public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public  void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public  void windowHandle()
	{

	Set<String> window = driver.getWindowHandles();
	List<String> newwin = new ArrayList<String>(window);
	driver.switchTo().window(newwin.get(1));
	}
	
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//Step 1: get all window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//Step 2: iterate thru all the windowIds
		Iterator<String> it = windowIds.iterator();
		
		//Step 3: navigate inside the windows
		while(it.hasNext())//loop untill windowidSs exist
		{
			//capture all the window ids
			String winId = it.next();
			
			//switch to the window and capture the title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			if(currentTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	public void screenshots(WebDriver driver, String screenShotName) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = ".\\ScreenShots\\" + screenShotName + ".png" + new JavaUtilities().getSystemDateInFormat();
        File dst = new File(path);

        try {

            FileUtils.copyFile(src, dst);

        } catch (IOException e) {
            e.printStackTrace();

        }

    }public void screenshot(WebDriver driver, String screenShotName) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = ".\\ScreenShots\\" + screenShotName + ".png" + new JavaUtilities().getSystemDateInFormat();

        File dst = new File(path);

        try {

            FileUtils.copyFile(src, dst);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
    public void extentReports() {

        spark = new ExtentSparkReporter(

                ".\\ExtentReports\\Reports.html" + new JavaUtilities().getSystemDateInFormat() + ".html");

        spark.config().setTheme(Theme.STANDARD);

        spark.config().setReportName("Report of Flipkart");

        spark.config().setDocumentTitle("Flipkart extentReport");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("BrowserName", "chrome");
        extent.setSystemInfo("Browser url", "Flipkart");
        extent.setSystemInfo("ReporterName", "Uday");
        test = extent.createTest("Scenarios working ");
        test.log(Status.INFO, "Test is starting");
        test.log(Status.PASS, "Testcases passed");
      extent.flush();

    }
    public void waitForElementToLoad( WebElement element)
	{
		wait = new WebDriverWait(driver,3000);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void javascriptclick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0],click;", ele);
	}
  public void sleep() throws InterruptedException {
	Thread.sleep(3000);
}

}
