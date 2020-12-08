package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;
import utility.ScreenshotOnFailure;

public class Hooks {
	public static WebDriver driver;
	public WebDriverManager webDriverManagerObj;
	static String scenarioName;
	
	public Hooks()
	{
		webDriverManagerObj = new WebDriverManager();
		driver = webDriverManagerObj.getDriver();
	}
	
	@Before
	
	 public void setUp(Scenario scenario) throws IOException
	{
		scenarioName = scenario.getName(); 
		File myObj = new File(scenario.getName()+".txt");
		if(myObj.createNewFile()) 
		{
			System.out.println("File created: " +myObj.getName());
		} else
		{
			System.out.println("File already exists");
		}
	}
	
	@Before
	public void BeforeTest()
	{
		System.out.println("This is before Hook");
		driver.get("https://www.google.com");
	}

	/*
	 * @After public void AfterTest() { System.out.println("This is After hook");
	 * driver.close(); driver.quit(); }
	 */
	
	/*
	 * @After public void embedScreenshot(Scenario scenario) throws Exception { if
	 * (scenario.isFailed()) { try { byte[] screenshot = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.BYTES); String testName =
	 * scenario.getName(); scenario.embed(screenshot, "image/png");
	 * scenario.write(testName); } catch (WebDriverException wde) {
	 * System.err.println(wde.getMessage()); } catch (ClassCastException cce) {
	 * cce.printStackTrace();} } }
	 */
	
	@After
	public void postExecution(Scenario scenario) throws IOException
	{
		System.out.println("This is After hook");
		if(scenario.isFailed())
		{
			System.out.println("failed scenario");
			ScreenshotOnFailure.captureScreenshot(driver, scenario.getName());
			
		}
		else
		{
			System.out.println("passed scenario");
			ScreenshotOnFailure.captureScreenshot(driver, scenario.getName());
		}
		driver.close(); 
		driver.quit();
	
		
	}
}

