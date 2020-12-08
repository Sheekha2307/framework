package managers;

import org.openqa.selenium.WebDriver;

import pageObject.Delivery;
import pageObject.FB_Login;
import pageObject.Home;
import pageObject.login;

public class PageObjectManager {
	
	WebDriver driver;
	login loginObj;
	Home homeObj;
	Delivery deliveryObj;
	FB_Login fbloginObj;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	public login loginObjMethod()
	{
		return (loginObj == null)? loginObj = new login(driver) : loginObj;
	}
	public Home homeObjMethod()
	{
		return (homeObj == null)? homeObj = new Home(driver) : homeObj;
	}
	public Delivery deliveryObjMethod()
	{
		return (deliveryObj == null)? deliveryObj = new Delivery(driver) : deliveryObj;
	}
	public FB_Login fbLoginObjMethod()
	{
		return (fbloginObj == null)? fbloginObj = new FB_Login(driver) : fbloginObj;
	}

}
