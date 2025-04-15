package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@id='input-email']") private WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-password']") private WebElement txtPassword;
	@FindBy(xpath = "//input[@value='Login']") private WebElement btnLogin;
	public void getEmail(String Email)
	{
		txtEmail.clear();
		txtEmail.sendKeys(Email);
	}
	public void getPassword(String PWD)
	{
		txtPassword.clear();
		txtPassword.sendKeys(PWD);
	}
	public void ClickOnLoginButton() {
		btnLogin.click();
	}

}
