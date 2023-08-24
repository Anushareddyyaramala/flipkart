package GenericUtilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/**
 * This class contains all the assertions to validating the functonalities
 * @author 
 *
 */
public class Validations {
	public WebDriver driver;
	public String actualValue;
	public String expected;

	public Validations(WebDriver driver)
	{
		this.driver=driver;
	}

	/**
	 * This method is used to verify between the two strings partially
	 * @param element
	 * @param expected
	 * @param message
	 */
	public void contains(String actualValue,String expected,String message) throws InterruptedException
	{
		
		Assert.assertTrue(actualValue.contains(expected),message);
		System.out.println("Validated succesfully");
	}
	/**
	 * This method is used to verify the element displayed or not by using Select class
	 * @param element
	 */
	public void displayed(WebElement element) throws InterruptedException
	{
		
		Assert.assertTrue(element.isDisplayed());
	}
	/**
	 * This method is used to verify between the elements by using tittle
	 * @param element
	 */
	public void containsTittle(WebElement element) throws InterruptedException
	{
		actualValue=getTitle();
		expected=getText(element);
		assertTrue(expected.contains(actualValue));
	}
	/**
	 * This method is used to verify between the elements by using url based
	 * @param driver
	 */
	public void containsUrl(WebDriver driver) throws InterruptedException
	{
		actualValue=getTitle();
		expected=getCurrentUrl();
		assertTrue(expected.contains(actualValue));
	}
	/**
	 * This method is used to get the text of a webElement
	 * @param element
	 */
	public String getText(WebElement element)
	{
		return element.getText();
	}
	/**
	 * This method is used to get the title of a respective window
	 */
	public String getTitle()
	{
		return driver.getTitle();
	}
	/**
	 * This method is used to get the url of a respective window
	 */
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();

	}
}
