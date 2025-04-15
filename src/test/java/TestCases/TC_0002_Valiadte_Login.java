package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;

import PageObject.HomePage;
import PageObject.LoginPage;

public class TC_0002_Valiadte_Login extends TestBase
{
	@Test
	public void ValidateLoginTest()
	{
		HomePage hp = new HomePage(driver);
		hp.ClickOnMyAccountLink();
		hp.ClickOnLoginLink();
		LoginPage lp= new LoginPage(driver);
		lp.getEmail(p.getProperty("EMAIL"));
		lp.getPassword("PWD");
		lp.ClickOnLoginButton();
	}

}
