package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	WebDriver driver;
	
	@FindBy(linkText="Sign in")private WebElement Sign_In;
	@FindBy(xpath="//*[@id='twotabsearchtextbox']") private WebElement Enter_Product;
	@FindBy(xpath="//*[@value='Go']") private WebElement Go_Button;
	@FindBy(xpath="//*[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]//h2") private WebElement Select_Product;
	@FindBy(id="submit.add-to-cart") private WebElement Add_ToCart;
	@FindBy(xpath= "//*[@id='hlb-ptc-btn']") private WebElement pesronalDetails;
	
	
	
public void homePage()
{
	Sign_In.click();
}

public void SearchProductPage(WebDriver driver)
{

Enter_Product.sendKeys("mask");
Go_Button.click();
}
public void selectProduct()
{
	Select_Product.click();

}
public void AddToCart()
{
    Add_ToCart.click();
}
public void personalDetails()
{
	pesronalDetails.click();
}

	public Home(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
