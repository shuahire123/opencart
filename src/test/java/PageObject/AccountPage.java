package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageBase
 {
	public AccountPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath = "//h1[contains(text(),'Created!')]") private WebElement ConfirmMessage;
	@FindBy(xpath = "//h2[text()='My Account']") private WebElement AccountText;
	@FindBy(linkText="Logout") private WebElement btnLogout;
	public String MessageConfirmation()
	{
		return ConfirmMessage.getText();
	}
	public void ClickOnLogoutButton()
	{
		btnLogout.click();
	}
	public boolean ValidateMyAccountTxt()
	{
		try
		{
			return AccountText.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
