package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class TestBase {
	WebDriver driver;
	public Logger log;
	public FileInputStream file;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String browser) throws IOException, InterruptedException
	{	// loading log4j
		log=LogManager.getLogger(this.getClass());
		 file = new FileInputStream(System.getProperty("user.dir")+".\\src\\test\\resources\\config.properties");
		 p = new Properties();
		p.load(file);
		file.close();
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			//OS
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching OS");
				return;
			}
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome");break;
			case "firefox":cap.setBrowserName("firefox");break;
			case "edge":cap.setBrowserName("edge");break;
			default:System.out.println("No Matching Browser");return;
			}
			Thread.sleep(10);
			System.out.println("Execution Mode: " + p.getProperty("execution_env"));
			System.out.println("Connecting to Selenium Grid...");
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
			System.out.println("Remote WebDriver Initialized");
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (browser.toLowerCase()) {
			case "chrome":driver = new ChromeDriver(); break;
			case "edge":driver= new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default:System.out.println("invalide browser name");; return;	
		}
		
		}
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public String RandomString()
	{
		String randomString=RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}
	public String RandomNumber()
	{
		 String randomNumber = RandomStringUtils.randomNumeric(5);
		//String randomNumber=Long.toString(random);
		return randomNumber;
	}
	public String RandomAlphaNumeric()
	{
		String alphaNumeric=RandomString()+RandomNumber()+"@";
		return alphaNumeric;
	}

}
