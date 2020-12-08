package dataProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;


public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath = "config//Configuration.properties";
	
	public ConfigFileReader()
	{
	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(propertyFilePath));
		properties = new Properties();
		try {
			properties.load(reader);
			reader.close();
		} catch (IOException e)
		{
			String msg = e.getMessage();
			System.out.println(msg);
			e.printStackTrace();
		}
	}
		catch (FileNotFoundException e)
		{
			String msg = e.getMessage();
			System.out.println(msg);
			e.printStackTrace();
	        throw new RuntimeException("Configuration.properties not found at "+propertyFilePath);
	}
}	
	
	public String getDriverPath()
	{
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!=null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file");
	}
	
	public long getImplicitlyWait()
	{
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null)return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("ImplicitlyWait not specified in the Configuration.properties file");
	}
	
	public String getApplicationUrl()
	{
		String url = properties.getProperty("url");
		if (url != null) return url;
		else throw new RuntimeException("url is not specified in the Configuration.properties file");
		
	}
	public String getFBUrl()
	{
		String fb_url = properties.getProperty("fb_url");
		if (fb_url != null) return fb_url;
		else throw new RuntimeException("url is not specified in the Configuration.properties file");
		
	}

	public DriverType getBrowser()
	{
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("Chrome")) return DriverType.Chrome; //if browsername is null or browsername is chrome
		else if (browserName.equalsIgnoreCase("Firefox")) return DriverType.FireFox;
		else if (browserName.equalsIgnoreCase("Internetexplorer")) return DriverType.InternetExplorer;
		else throw new RuntimeException("Browser Name key value in Configuration.properties file");
			
	}
	public EnvironmentType getEnvironment()
	{
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equals("Local")) return EnvironmentType.Local; //if browsername is null or browsername is chrome
		else if (environmentName.equalsIgnoreCase("Remote")) return EnvironmentType.Remote;
		else throw new RuntimeException("Environment Name key value in Configuration.properties file");
			
	}
	public String getTestDataResourcePath()
	{
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if (testDataResourcePath != null) return testDataResourcePath;
		else throw new RuntimeException("testDataResourcePath is not specified in the Configuration.properties file");
		
	}
}
