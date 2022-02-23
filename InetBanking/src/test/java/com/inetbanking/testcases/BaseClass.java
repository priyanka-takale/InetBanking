package com.inetbanking.testcases;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.inetbanking.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ConfigReader configreader=new ConfigReader();
	public String baseUrl=configreader.getApplicationURL();
	public String username=configreader.getUserName();
	public String password=configreader.getPassword();
	public static WebDriver driver;
	
	public static  Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		//WebDriverManager.chromedriver().setup();;
		// driver=new ChromeDriver();
		
		System.setProperty("webdriver.chrome.driver" ,configreader.getChromePath() ) ;
	  driver=new ChromeDriver();
		 
		  logger=Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("Log4j.properties");
	 }
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
