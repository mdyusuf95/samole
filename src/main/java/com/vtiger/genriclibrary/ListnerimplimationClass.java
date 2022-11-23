package com.vtiger.genriclibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerimplimationClass implements ITestListener {
	 ExtentReports report;
	 ExtentTest test;
	public void onTestStart(ITestResult result)
	{
	String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"....TestScript Exiecution Started");
		
		
	}
	

	public void onStart(ITestContext context) 
	{
		//Execution Start here
				//Configure the report
				ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReport\\report.html");
				htmlreport.config().setDocumentTitle("SDET-43 report");
				htmlreport.config().setTheme(Theme.STANDARD);
				htmlreport.config().setReportName("HMS execution report");
				
				report= new ExtentReports();
				
				report.attachReporter(htmlreport);
				report.setSystemInfo("Base_Browser","chrome");
				report.setSystemInfo("OS","windows");
				report.setSystemInfo("Base_url","jdbc:mysql://localhost:3306/testyantra");
				report.setSystemInfo("ReporterName","yusuf");
		
	}




	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"...>passed");
		Reporter.log(MethodName+"...>script executed successfullly");
		
    }
	public void onTestFailure(ITestResult result) 
	{
		
		String  failedTestScript= result.getMethod().getMethodName();
		String FScript=failedTestScript+new JavaUtility().getSystemDateandTimeInFormat(); 
		EventFiringWebDriver  edriver =new EventFiringWebDriver(Base.sdriver);
		File src =edriver.getScreenshotAs(OutputType.FILE);
		File dst =new File(".\\screenshot\\"+FScript+".png");
		try
		{
			FileUtils.copyFile(src,dst);
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
	}

	public void onTestSkipped(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"...>skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(MethodName+"....Script Skipped");
		
	}
	public void onFinish(ITestContext context)
	{
   //Consolidate all the report
	report.flush();
	}

}
