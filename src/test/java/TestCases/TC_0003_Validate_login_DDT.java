package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.AccountPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import Utility.dataProvider;

public class TC_0003_Validate_login_DDT extends TestBase {
	/*@Test(dataProvider = "LoginData",dataProviderClass  = dataProvider.class )
	public void testDDTLogin(String email, String password, String validation) {
		try {
			log.info("*******************starting TC_0003_Validate_login_DDT*************************");
			HomePage hp = new HomePage(driver);
			hp.ClickOnMyAccountLink();
			hp.ClickOnLoginLink();
			LoginPage lp = new LoginPage(driver);
			lp.getEmail(email);
			lp.getPassword(password);
			lp.ClickOnLoginButton();
			AccountPage ap = new AccountPage(driver);
			boolean target = ap.ValidateMyAccountText();

			if (validation.equalsIgnoreCase("valid")) {
				if (target) {
					ap.ClickOnLogoutButton();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (validation.equalsIgnoreCase("invalid")) {
				if (target) {
					ap.ClickOnLogoutButton();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		log.info("*******************starting TC_0003_Validate_login_DDT*************************");
	}*/
}
