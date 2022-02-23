package com.inetbanking.pageobject;

import java.net.UnknownHostException;



import com.inetbanking.utilities.HTMLReportGenerator;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hookable

{
	@Before
	public void before(Scenario scenario) throws UnknownHostException 
	{
		HTMLReportGenerator.TestSuiteStart("D:\\NewWorkSapce\\InetBanking\\target", "Project");
		HTMLReportGenerator.TestCaseStart(scenario.getName(), scenario.getStatus().toString());
		
		
       	System.out.println("----------------------Scenerio Start---------------------------");
	}
	
	@After
	public void after(Scenario scenario)
	{
		System.out.println("----------------------Scenerio End-----------------------------");
	    
		HTMLReportGenerator.TestCaseEnd();
		HTMLReportGenerator.TestSuiteEnd();
		
	
	}


}
