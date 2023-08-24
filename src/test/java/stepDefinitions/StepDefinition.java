package stepDefinitions;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver=null;

	@Given("open browser and enter URL")
	public void open_browser() {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		  driver.get("https://www.flipkart.com/");
		  driver.manage().window().maximize();
		  
		
	}
	  	
	@When("search a product from search bar")
	public void i_want_to_search_a_product_from_search_bar() throws Exception {
		AddToCart app=new AddToCart(driver);
		app.searchbar(); 
	  
	}

	@And("click on the product")
	public void click_on_the_product() throws Exception, AWTException {
		AddToCart app=new AddToCart(driver);
		app.productsearch();
	}

	@And("validate mouse hower on image is displaying maximised image")
	public void validate_mouse_hower_on_image_is_displaying_maximised_image() {
	
	}


	@And("Add the product to the cart")
	public void add_the_product_to_the_cart() throws Exception {
		AddToCart app=new AddToCart(driver);
		app.ZoomtheProduct();
		app.addproduct();
	}

	@Then("validate the price on details page with cart price")
	public void validate_the_price_on_cart_with_previous_price() throws Exception {
		AddToCart app=new AddToCart(driver);
	    app.pricevalidation();
	}

}
