package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObject.Delivery;
import pageObject.Home;
import pageObject.login;
import utility.LogHelper;

public class Steps {

	public static WebDriver driver;
	login loginObj;
	PageObjectManager pageObjectManager;
	Home homeObj;
	Delivery deliveryObj;
	static WebDriverManager webDriverManagerObj;
	//static ConfigFileReader configFileReader1;
	
	/*
	 * public static WebDriver getConnection() throws Throwable {
	 * 
	 * //System.setProperty("webdriver.chrome.driver",
	 * FileReaderManager.getInstance().getConfigReader().getDriverPath());
	 * 
	 * //configFileReader1 = new ConfigFileReader(); //
	 * System.setProperty("webdriver.chrome.driver",
	 * configFileReader1.getDriverPath()); //driver = new ChromeDriver(); return
	 * driver; }
	 */
	
	 public static void switchTab()
	 {
		 String MainWindow = driver.getWindowHandle();
		 System.out.println("Main window is " +MainWindow);
		 
		 Set<String> windowHandles = driver.getWindowHandles();
		 Iterator<String> itr = windowHandles.iterator();
		 while(itr.hasNext())
		 {
			 String childWindow = itr.next();
		  if (!MainWindow.equalsIgnoreCase(childWindow))
		 {
			 System.out.println("This is child window");
			 
			 driver.switchTo().window(childWindow);
		 
		 }
		 }
	 }

@Given("^user is on Amazon Home Page$")
public void user_is_on_Amazon_Home_Page() throws Throwable {
	webDriverManagerObj = new WebDriverManager();
	driver =webDriverManagerObj.getDriver();
	 driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());  //Open URl
	  driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	 pageObjectManager = new PageObjectManager(driver);
	 homeObj = pageObjectManager.homeObjMethod();
	 homeObj.homePage();
	 //driver.findElement(By.linkText("Sign in")).click();
	 driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	loginObj =pageObjectManager.loginObjMethod();
	loginObj.loginpage();
	LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Amazon Scenario: Browser Launched successfully");
}
	 /*driver.findElement(By.id("ap_email")).sendKeys("9425104270");
	 driver.findElement(By.id("continue")).click();
	 driver.findElement(By.name("password")).sendKeys("Summer@2020");
	 driver.findElement(By.id("signInSubmit")).click();
}*/

@When("^he search for “masks”$")
public void he_search_for_masks() throws Throwable {
	 homeObj.SearchProductPage(driver);
	 driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	 LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Mask searched successfully");
}

@When("^choose to buy the first item$")
public void choose_to_buy_the_first_item() throws Throwable {
	//Home homeObj = new Home(driver);
	 homeObj.selectProduct();
	switchTab();
	LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Buying first item");
	 	 }	 


@When("^moves to checkout from mini cart$")
public void moves_to_checkout_from_mini_cart() throws Throwable {
	driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	homeObj.AddToCart();
	 Thread.sleep(2000); 
	 LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Checking out to cart");
}

@When("^enter personal details on checkout page$")
public void enter_personal_details_on_checkout_page() throws Throwable {
	homeObj.personalDetails();
	// Thread.sleep(3000);
	driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Entering personal details");
}

@When("^select same delivery address$")
public void select_same_delivery_address() throws Throwable {
	pageObjectManager = new PageObjectManager(driver);
	deliveryObj = pageObjectManager.deliveryObjMethod();
	deliveryObj.deliveryAddress();
	 Thread.sleep(2000);
	 LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Selecting delivery address");
	 }

@When("^place the order$")
public void place_the_order() throws Throwable {
	deliveryObj.PlaceOrder();
	LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"order placed");
	}
}