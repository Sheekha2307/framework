package seleniumTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonFirstTest {

	
public static WebDriver driver;

public static WebDriver getConnection() {
	 System.setProperty("webdriver.chrome.driver","C:\\Users\\IB\\Downloads\\chromDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\IB\\Downloads\\chromDriver\\chromedriver.exe"); WebDriver driver=
		 * new ChromeDriver();
		 * 
		 */
		AmazonFirstTest.getConnection();
		 driver.navigate().to("https://www.amazon.in/");  //Open URl
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 driver.findElement(By.linkText("Sign in")).click();
		 Thread.sleep(2000); 
		 driver.findElement(By.id("ap_email")).sendKeys("9425104270");
		 driver.findElement(By.id("continue")).click();
		 driver.findElement(By.name("password")).sendKeys("Summer@2020");
		 driver.findElement(By.id("signInSubmit")).click();
		 
		 Thread.sleep(1000);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,1000)","");
		 driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("mask"); 
		 driver.findElement(By.xpath("//*[@value='Go']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@class='s-main-slot s-result-list s-search-results sg-row']/div[3]//h2")).click();
		 switchTab();
		 driver.findElement(By.id("submit.add-to-cart")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='hlb-ptc-btn']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.partialLinkText("Deliver to this address")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@class='order-display']/following-sibling::div//span[1]/span/input[@value='Continue']")).click();

		 
	}
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
			/*
			 * String MainWindow = driver.getWindowHandle();
			 * System.out.println("Main window is " +MainWindow);
			 * driver.findElement(By.partialLinkText("Gadgets")).click(); Set<String>
			 * windowHandles = driver.getWindowHandles(); Iterator<String> itr =
			 * windowHandles.iterator(); while(itr.hasNext()) { String childWindow =
			 * itr.next(); if (!MainWindow.equalsIgnoreCase(childWindow)) {
			 * System.out.println("This is child window");
			 * 
			 * driver.switchTo().window(childWindow);
			 */	 }	 
	
	}
	}


