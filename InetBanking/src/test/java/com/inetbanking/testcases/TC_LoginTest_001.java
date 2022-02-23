package com.inetbanking.testcases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
  public void loginTest() throws IOException
  {
	  driver.get(baseUrl);
	  logger.info("Url is opened");
	  
	  LoginPage lp=new LoginPage(driver);
	  
	  lp.setUserName(username);
	  logger.info("Enter UserName");
	  
	  lp.setPassword(password);
	  logger.info("Enetr Password");
	  
	  lp.clickSubmit();
	  if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	  {
		  Assert.assertTrue(true);
		  logger.info("Login Tast Pass");
	  }
	  else
	  {
		  captureScreen (driver,"loginTest");
		  Assert.assertTrue(false);
		  logger.info("Login Test Fails");
	  }
  }
}
