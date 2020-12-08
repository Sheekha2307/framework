package seleniumTest;

	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Facebook {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver","C:\\Users\\IB\\Downloads\\chromDriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://facebook.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("email")).sendKeys("9970072899");
			driver.findElement(By.id("pass")).sendKeys("Summer@2020");
			driver.findElement(By.id("u_0_b")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			driver.switchTo().alert().accept();
		}

	}
