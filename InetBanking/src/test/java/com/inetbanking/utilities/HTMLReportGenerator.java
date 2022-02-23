package com.inetbanking.utilities;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class HTMLReportGenerator
{
	static ExtentReports testsuiteobj=null;
	static ExtentTest testcaseobj; 
	static boolean isShowImage=false;
	static String imageFolderPath=null;
	public HTMLReportGenerator(String HTMLFilePath,String UserName) throws UnknownHostException
	{
		
		TestSuiteStart(HTMLFilePath,UserName);
		isShowImage=false;
	}
	public HTMLReportGenerator(String HTMLFilePath,String UserName,String ImageFolderPath) throws UnknownHostException
	{
		isShowImage=true;
		this.imageFolderPath=ImageFolderPath;
		TestSuiteStart(HTMLFilePath,UserName);
	}
	public static void TestSuiteStart(String ResultHTMLFilePath,String UserName) throws UnknownHostException
	{
		testsuiteobj=new ExtentReports(ResultHTMLFilePath,false,NetworkMode.OFFLINE);
		
		testsuiteobj
			.addSystemInfo("Host Name", InetAddress.getLocalHost().getHostName())
	        .addSystemInfo("Environment", "QA")
	        .addSystemInfo("User Name", UserName);
	}
	public static void TestSuiteEnd()
	{
		testsuiteobj.flush();testsuiteobj.close();
	}
	public static void TestCaseStart(String TestName,String Description)
	{
		testcaseobj=testsuiteobj.startTest(TestName, Description);
	}
	public static void TestCaseEnd()
	{
		testsuiteobj.endTest(testcaseobj);
		
	}
	
	public static void StepDetails(String Status,String StepName,String StepDetails)
	{
		String stepinfo=null;
	
			if(isShowImage)
			{
				stepinfo=StepDetails+"<br>"+testcaseobj.addScreenCapture(imageFolderPath+"\\"+StepName.replace(" ", "_")+"...png");
			}
			else
			{
				stepinfo=StepDetails;
			}
				if(Status.equalsIgnoreCase("pass"))
				{		testcaseobj.log(LogStatus.PASS,StepName,stepinfo);}
				else if(Status.equalsIgnoreCase("fail"))
				{		testcaseobj.log(LogStatus.FAIL,StepName, stepinfo);}
				else if(Status.equalsIgnoreCase("error"))
				{		testcaseobj.log(LogStatus.ERROR,StepName, stepinfo);}
				else if(Status.equalsIgnoreCase("info"))
				{		testcaseobj.log(LogStatus.INFO,StepName, stepinfo);}
				else
				{testcaseobj.log(LogStatus.INFO,StepName, stepinfo);}
	
		
	}


}
