package pageObjects;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import GenericUtilities.BaseClass;
import GenericUtilities.Utilities;
import GenericUtilities.Validations;
import GenericUtilities.WebDriverUtilities;
public class AddToCart extends BaseClass{
	//WebDriver driver;
	String Expectedvalue;
    String Actualvalue;
   
    public Properties prop=new Properties();
    
    public AddToCart(WebDriver driver){

		BaseClass.driver=driver;
		PageFactory.initElements(driver,this);
	}
    
	@FindBy(xpath  = "//button[text()='✕']") private WebElement popup;

	@FindBy(xpath = "//input[@title='Search for products, brands and more']") private WebElement searchBar;
	@FindBy(xpath = "//button[@type='submit']") private WebElement enter;
	
	@FindBy(xpath = "//div[.='APPLE iPhone 14 Pro Max (Gold, 128 GB)']") private WebElement product;
	@FindBy(xpath="//span[contains(@class,'1WpvJ7')][1] ")private WebElement priceondetailspage;
	
	@FindBy(xpath ="//li[contains(@class,'col col')][1]") private WebElement addtocart;    
	
    @FindBy(xpath="//div[@class=\"_3fSRat\"]//span[@class=\"_2-ut7f _1WpvJ7\"]")private WebElement priceoncartpage;
    
	@FindBy(xpath="//div[contains(@class,'bXrC_t')]")private WebElement zoomedImage; 
@FindBy(xpath="//img[@loading='eager'][1]")private WebElement normalImage;

	
	public void searchbar() throws InterruptedException, AWTException {
		
		
		if(popup.isDisplayed())
		popup.click();
		
	else {
			System.out.println("popup doesn't exist");
		}

		Thread.sleep(3000);
		searchBar.sendKeys("iphone 14 promax");
		enter.click();
		System.out.println("Aswini");
	
	}
	
	public void productsearch() throws Exception {
			

		Thread.sleep(3000);
		product.click();
//		util.windowHandle(driver);
//		
//		
		}
	
	public void ZoomtheProduct() {
		
		wUtil.switchToWindow(driver, "newwindow");	
		System.out.println("newwindow");
		//WebDriverUtilities.mouseHover( driver,normalImage);
		boolean value=!zoomedImage.isDisplayed();
	Assert.assertTrue(value,"Assertion passed");
		boolean value2=normalImage.isDisplayed();
		Assert.assertTrue(value2);
		Assert.assertEquals(value, value2);
}
		
	public void addproduct() throws Exception {
		wUtil.windowHandle();
    wUtil.waitForElementToLoad(addtocart);
    wUtil.scrollAction(driver);
		addtocart.click();
		
		
	}

	//div[@class=\"_30jeq3 _16Jk6d\"]

	
	
public void  pricevalidation() throws InterruptedException {
	Thread.sleep(3000);	
	
String Expectedvalue = prop.getProperty("Expectedvalue");
	String Actual = priceoncartpage.getText();
	Assert.assertEquals(Actualvalue,Expectedvalue );
	
	
	

}
}



