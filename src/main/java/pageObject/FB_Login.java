package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FB_Login {

	WebDriver driver;
	
	@FindBy(id="email")private WebElement UserName;
	@FindBy(id="pass") private WebElement Password;
	@FindBy(id="u_0_b") private WebElement Login;
		
	
public void loginPage(String username2, String password2)
{
	UserName.sendKeys(username2);
	Password.sendKeys(password2);
	Login.click();
}
	public FB_Login(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}


