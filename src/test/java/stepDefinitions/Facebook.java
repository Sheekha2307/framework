package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObject.FB_Login;
import utility.LogHelper;

public class Facebook {
	public static WebDriver driver;
	PageObjectManager pageObjectManager1;
	WebDriverManager webDriverManagerObj1;
	FB_Login fbLoginObj1;

	@Given("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		webDriverManagerObj1 = new WebDriverManager();
		driver = webDriverManagerObj1.getDriver();

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\IB\\Downloads\\chromDriver\\chromedriver.exe"); driver = new
		 * ChromeDriver();
		 */
		// driver.get("https://facebook.com/");
		driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getFBUrl());
		driver.manage().window().maximize();
		LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"FB scenario: Browser Launched successfully");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"User is navigated to Home Page");
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		pageObjectManager1 = new PageObjectManager(driver);
		fbLoginObj1 = pageObjectManager1.fbLoginObjMethod();
		String username = arg1;
		String password = arg2;
		fbLoginObj1.loginPage(username, password);
		LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Credentials entered successfully");

	}

	/*
	 * @When("^User enters UserName and Password$") public void
	 * user_enters_UserName_and_Password() throws Throwable { pageObjectManager1 =
	 * new PageObjectManager(driver);
	 * fbLoginObj1=pageObjectManager1.fbLoginObjMethod(); fbLoginObj1.loginPage();
	 * 
	 * driver.findElement(By.id("email")).sendKeys("9970072899");
	 * driver.findElement(By.id("pass")).sendKeys("Summer@2020");
	 * driver.findElement(By.id("u_0_b")).click(); }
	 */
	@Then("^homepage is displayed Login Successfully$")
	public void homepage_is_displayed_Login_Successfully() throws Throwable {
		System.out.println("I am on Homepage");
		LogHelper.logger(Hooks.scenarioName, LogHelper.LogStatus.Info+": "+"Homepage Launched successfully");
	}

}
