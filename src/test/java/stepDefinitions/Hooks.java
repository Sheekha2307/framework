package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;
import utility.EmailWithAttachment;
import utility.ScreenshotOnFailure;

public class Hooks {
	public static WebDriver driver;
	public WebDriverManager webDriverManagerObj;
	static String scenarioName;
	
	  
	  public Hooks() { 
		  webDriverManagerObj = new WebDriverManager(); 
	  driver = webDriverManagerObj.getDriver(); }
	 

	@Before

	public void setUp(Scenario scenario) throws IOException {
		scenarioName = scenario.getName();
		File myObj = new File(scenario.getName() + ".txt");
		if (myObj.createNewFile()) {
			System.out.println("File created: " + myObj.getName());
		} else {
			System.out.println("File already exists");
		}
	}

	@Before
	public void BeforeTest() {
		System.out.println("This is before Hook");
		driver.get("https://www.google.com");
	}

	@After(order = 2)
	 public void afterScenario(Scenario scenario) {
	 if (scenario.isFailed()) {
	 String screenshotName = scenario.getName().replaceAll(" ", "_");
	 try {
	 System.out.println("I am in failed scenario");
		 //This takes a screenshot from the driver at save it to the specified location
	 File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 //getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
	 
	 //Building up the destination path for the screenshot to save
	 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
	 //File destinationPath = new File(System.getProperty("user.dir") + "/target/screenshots/" + screenshotName + ".png");
	 File destinationPath = new File("./Screenshots/"+screenshotName+ ".png");
	 //Copy taken screenshot from source location to destination location
	 Files.copy(sourcePath, destinationPath);   
	 
	 //This attach the specified screenshot to the test
	 Reporter.addScreenCaptureFromPath(destinationPath.toString());
	 } catch (IOException e) {
	 } 
	 
	 }
	 }
	
	
	
	  @After(order=0)
	  public void AfterTest() throws EmailException 
	  { 
	  System.out.println("This is After hook");
	 EmailWithAttachment.emailWithAttachment();
	  driver.close(); 
	  driver.quit(); 
	  }
	 

	/*
	 * @After public void embedScreenshot(Scenario scenario) throws Exception { if
	 * (scenario.isFailed()) { try { byte[] screenshot = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.BYTES); String testName =
	 * scenario.getName(); scenario.embed(screenshot, "image/png");
	 * scenario.write(testName); } catch (WebDriverException wde) {
	 * System.err.println(wde.getMessage()); } catch (ClassCastException cce) {
	 * cce.printStackTrace();} } }
	 */

	//***************working screenshot block-commented now****************
	/*
	 * @After public void postExecution(Scenario scenario) throws IOException {
	 * System.out.println("This is After hook"); if (scenario.isFailed()) {
	 * System.out.println("failed scenario");
	 * ScreenshotOnFailure.captureScreenshot(driver, scenario.getName());
	 * 
	 * } else { System.out.println("passed scenario");
	 * ScreenshotOnFailure.captureScreenshot(driver, scenario.getName()); }
	 * driver.close(); driver.quit();
	 * 
	 * }
	 */}
