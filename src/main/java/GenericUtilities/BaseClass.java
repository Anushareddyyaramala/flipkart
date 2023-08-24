package GenericUtilities;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;
	public WebDriverUtilities wUtil=new WebDriverUtilities(driver);
	public Utilities util=new Utilities();
	public Validations val=new Validations(driver);
}
