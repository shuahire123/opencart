package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountPage;
import PageObject.HomePage;
import PageObject.RegistrationPage;

public class TC_0001_ValidateRegistaration extends TestBase {
	@Test(invocationCount = 1)
	public void ValiadteRegistration() {
		try {
			log.debug("application log started...........");
			log.info("**************TC_0001_ValidateRegistaration starting***************");
			HomePage hp = new HomePage(driver);
			hp.ClickOnMyAccountLink();
			log.info("click on my account page link");
			hp.ClickOnRegistrationLink();
			log.info("click on my registration link");
			RegistrationPage regPage = new RegistrationPage(driver);
			log.info("Entering user details..");
			regPage.getFirstName(RandomString());
			regPage.getLastName(RandomString());
			String email=RandomString() + "@gmail.com";
			regPage.getEmail(email);
			regPage.getTelephone(RandomNumber());
			String password = RandomAlphaNumeric();
			regPage.getPassword(password);
			regPage.getConfirmPassword(password);
			regPage.clickSubScribeYes();
			regPage.clickPrivacyPolicy();
			log.info("Clicked on continue");
			regPage.clickContinueButton();
			AccountPage ap = new AccountPage(driver);
			// System.out.println(ap.MessageConfirmation());
			log.info("validating confirmation message");
			Assert.assertEquals(ap.MessageConfirmation(), "Your Account Has Been Created!");
			System.out.println(password+"  "+email);
			//Thread.sleep(10000);
		} catch (Exception e) {
			log.error("test failed..",e);
			Assert.fail("exception occured " + e.getMessage());
		}
		log.debug("application log end...........");
		log.info("**************TC_0001_ValidateRegistaration ending***************");

	}

}
