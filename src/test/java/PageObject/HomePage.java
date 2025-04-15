package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{
	// page object model with page factory
	// Initialize constructor
	public HomePage(WebDriver driver)
	{
		//Assigning driver to super class
		super(driver);
	}
	// webElements
	@FindBy(xpath = "//span[text()='My Account']") private WebElement LinkMyAccount;
	@FindBy(linkText = "Register") private WebElement LinkRegistration ;
	@FindBy(linkText = "Login") private WebElement LinkLogin;
	
	// action methods
	public void ClickOnMyAccountLink()
	{
		LinkMyAccount.click();
	}
	public void ClickOnRegistrationLink()
	{
		LinkRegistration.click();
	}
	public void ClickOnLoginLink()
	{
		LinkLogin.click();
	}
	
	
	
	
}
	