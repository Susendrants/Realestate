package com.realestate.GenericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result)
	{
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"---Testscript Execution starts here---");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"--Passed--");
		Reporter.log(MethodName+"--Testscript executed successfully--");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String Fs=result.getMethod().getMethodName();
		String f = Fs+ new JavaUtils().systemDate();
		test.addScreenCaptureFromPath(f);
		try {
			WebdriverUtils.getScreenShot(BaseClass.sdriver, f);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, f+"--failed--");
		Reporter.log(f+"---Testscript execution failed--");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"--skipped--");
		Reporter.log(MethodName+"--Testscript execution skipped--");
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-52");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Spot Spotters");
		
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("url", "http://rmgtestingserver/domain/House_Rental_Application/");
		report.setSystemInfo("Reporter Name", "T.S.Susendran");
				
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		//clean the older report
		report.flush();
	}

	
	
}
