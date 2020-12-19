package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotOnFailure {

	public static void captureScreenshot(WebDriver driver, String TcName) throws IOException {
		try
		{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File srcFile= ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+TcName+ ".png");
		FileUtils.copyFile(srcFile, destFile);
		}
		catch (IOException e)
		{
			
		}
	}

}
