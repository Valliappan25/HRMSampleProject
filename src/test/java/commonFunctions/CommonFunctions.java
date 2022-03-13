package commonFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {

	public static FileInputStream stream;
	public static Properties prop;
	public static WebDriver driver;
	Logger logger = Logger.getLogger(CommonFunctions.class);
	public Properties loadPropertyFile()
	{ 
		try {
		stream = new FileInputStream("config.properties");
		prop = new Properties();
		logger.info("Loading Configuration Properties File");
		prop.load(stream);
		
	} 
		catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return prop;
	}
	
	@BeforeSuite
	public void lauchBrowser()
	{
		logger.info("Begin Test Execution");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Loading Property File");
		
		loadPropertyFile();
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().cachePath("Driver").setup();
			driver = new ChromeDriver();
			logger.info("Launching Chrome");
	        
		}
		else if(browser.equalsIgnoreCase("edge"))  {
			WebDriverManager.edgedriver().cachePath("Driver").setup();
			driver = new EdgeDriver();
			logger.info("Launching Edge");
			
		}
		else {
			WebDriverManager.firefoxdriver().cachePath("Driver").setup();   
			driver = new FirefoxDriver();	
			logger.info("Launching Firefox");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		logger.info("Launching Application by hitting URL: "+url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown()
	{
		logger.info("End of Testcase Execution and closing Browser");
		driver.quit();
	}
}
