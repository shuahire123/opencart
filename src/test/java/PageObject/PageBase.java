package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	WebDriver driver;
	public PageBase(WebDriver driver) {
		// Assign web driver object to local driver 
		this.driver=driver;
		// Initialize driver to initElement method that will automatically initialize driver to FindBy annotation
		PageFactory.initElements(driver, this);
	}

}
