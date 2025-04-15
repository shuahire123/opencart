package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase
{
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	 @FindBy(xpath = "//input[@id='input-firstname']") private WebElement txtFirstName;
	 @FindBy(xpath ="//input[@id='input-lastname']") private WebElement txtLastName;
	 @FindBy(xpath="//input[@id='input-email']") private WebElement txtEmail;
	 @FindBy(xpath="//input[@id='input-telephone']") private WebElement txtTelephone;
	 @FindBy(xpath = "//input[@id='input-password']") private WebElement txtPassword;
	 @FindBy(xpath="//input[@id='input-confirm']") private WebElement txtConPassword;
	 @FindBy(xpath="//label[normalize-space()='Yes']") private WebElement rdbtnYes;
	 @FindBy(xpath = "//label[normalize-space()='No']") private WebElement rdbtnNo;
	 @FindBy(xpath = "//input[@name='agree']") private WebElement chkPrivacyPolicy;
	 @FindBy(xpath = "//input[@value='Continue']") private WebElement btnContinue;
	 
	 public void getFirstName(String FN)
	 {
		 txtFirstName.clear();
		 txtFirstName.sendKeys(FN);
	 }
	 public void getLastName(String LN)
	 {
		 txtLastName.clear();
		 txtLastName.sendKeys(LN);
	 }
	 public void getEmail(String Email)
	 {
		 txtEmail.clear();
		 txtEmail.sendKeys(Email);
	 }
	 public void getTelephone(String Telephone)
	 {
		 txtTelephone.clear();
		 txtTelephone.sendKeys(Telephone);
	 }
	 public void getPassword(String PWD)
	 {
		 txtPassword.clear();
		 txtPassword.sendKeys(PWD);
	 }
	 public void getConfirmPassword(String PWD) {
		 txtConPassword.clear();
		 txtConPassword.sendKeys(PWD);
	}
	 public void clickSubScribeYes()
	 {
		 rdbtnYes.click();
	 }
	 public void clickSubScribeNo()
	 {
		 rdbtnNo.click();
	 }
	 public void clickPrivacyPolicy()
	 {
		 chkPrivacyPolicy.click();
	 }
	 public void clickContinueButton()
	 {
		 btnContinue.click();
	 }
 
}
