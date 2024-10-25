package baseClasses;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; // For logger
import org.apache.logging.log4j.Logger;  //For logger
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class Tutorialsninja_TestCases_BaseClass {

	public static WebDriver d2; //it should be static as created object in "ExtentReport_Generation_Class"
	public Logger logger;
	public Properties prt;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String brws) throws IOException
	{
		//loading config.properties file
		
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		//(or)
		//FileReader file=new FileReader(".\\src\\test\\resources\\config.properties");
		prt=new Properties();
		prt.load(file);
				
		logger=LogManager.getLogger(this.getClass());
		
		
		//for Grid remote execution 
		
		if(prt.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
			capabilities.setPlatform(Platform.WIN11);
				
			}
			else if(os.equalsIgnoreCase("mac"))
			{
			capabilities.setPlatform(Platform.MAC);
			
			}
			else if(os.equalsIgnoreCase("Linux"))
			{
			capabilities.setPlatform(Platform.LINUX);
			
			}
			else
			{
				System.out.println("No matching of os");
				return;
			}
			
			switch(brws.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No maching browser");return;
			}
			d2=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);	//http://192.168.29.133:4444 /ui/------in case of local host we can use ip address as well
		}
		
		
		 
		//for grid local execution
		
		if(prt.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(brws.toLowerCase())
		{
		case "chrome": d2=new ChromeDriver(); break;
		case "edge": d2=new EdgeDriver(); break;
		case "firefox": d2=new FirefoxDriver(); break;
		default: System.out.println("Invalid browser provided");return;
		}
		
		}
		

	d2.manage().deleteAllCookies();
	d2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d2.get(prt.getProperty("url"));   //getting url from config.properties file
	d2.manage().window().maximize();
	}	
	
	
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown()
	{
	d2.quit();	
	}

	
		
	
	public String randomString()//to generate random String
	{
		String randstring=RandomStringUtils.randomAlphabetic(5);

		return randstring;
	}

	public String randomnumber()//to generate random string numbers
	{
		String randnumbert=RandomStringUtils.randomNumeric(10);  

		return randnumbert;
	}

	public String randomalphnumeric()//to generate random string alphanumaric
	{
		String randAlphbet=RandomStringUtils.randomNumeric(4);
		String randnumaric=RandomStringUtils.randomNumeric(4);  

		return (randAlphbet+"$"+randnumaric);
	}

public String captureScreenshot(String tname)
	{	
	
	String timeStamp=new SimpleDateFormat("yyyyMMddmmss").format(new Date());
	
	TakesScreenshot takesScreenshot = (TakesScreenshot)d2;
	File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);
	
	return targetFilePath;
	}
	
}
