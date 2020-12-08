package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	
	WebDriver driver;
	
	@FindBy(id="ap_email")private WebElement Username;
	@FindBy(id="continue")private WebElement Continue;
	@FindBy(name="password")private WebElement Password;
	@FindBy(id="signInSubmit")private WebElement Submit;
		
			
public void loginpage()
{
	Username.sendKeys("9425104270");
	Continue.click();
	Password.sendKeys("Summer@2020");
	Submit.click();
}
	public login(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
