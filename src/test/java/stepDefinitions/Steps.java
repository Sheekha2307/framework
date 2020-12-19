package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObject.Delivery;
import pageObject.Home;
import pageObject.login;
import utility.Log;
import utility.LogHelper;

public class Steps {

	public static WebDriver driver;
	login loginObj;
	PageObjectManager pageObjectManager;
	Home homeObj;
	Delivery deliveryObj;
	static WebDriverManager webDriverManagerObj;
	//Logger log = Logger.getLogger(Steps.class);
//	Logger log1 = Logger.getLogger("devpinoyLogger");
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
	Log.startTestCase("Amazon Home page");
	driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl()); //Open URl
	Log.info("Opening Amazon URL");
	  driver.manage().window().maximize();
	  Reporter.addStepLog("********Reporter class1*********"); //logs inside the report
		/*
		 * log1.info("*******This is through log4j*******");
		 * log1.warn("****Hey this is just warning******");
		 * log1.fatal("*****Hey this is fatal message****");
		 * log1.debug("********This is debug*************");
		 */
	  
	  
		LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Amazon Scenario: 1Browser Launched successfully");
//logs generated separately
		
	 driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	 pageObjectManager = new PageObjectManager(driver);
	 homeObj = pageObjectManager.homeObjMethod();
	 homeObj.homePage();
	 //driver.findElement(By.linkText("Sign in")).click();
	 driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
	loginObj =pageObjectManager.loginObjMethod();
	loginObj.loginpage();
	Log.info("login successful");
	Log.warn("*******This is warning log*******");
	Log.error("*******This is error log*******");
	Log.fatal("*******This is fatal log*******");
	Log.debug("*******This is debug log*******");
	Reporter.addStepLog("********Reporter class*********");
	LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Amazon Scenario: Browser Launched successfully");
	Log.endTestCase("Amazon login page test case ends");
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