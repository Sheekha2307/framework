package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Delivery {
	
	WebDriver driver;
	@FindBy(partialLinkText="Deliver to this address") private WebElement DeliveryAddress;
	@FindBy(xpath="//*[@class='order-display']/following-sibling::div//span[1]/span/input[@value='Continue']") private WebElement Continue_Button;
	
		 
public void deliveryAddress()
{
	
	DeliveryAddress.click();
}
public void PlaceOrder()
{
	
	Continue_Button.click();
}

	public Delivery(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
