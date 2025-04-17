package com.tutorialsNinja.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsNinja.Utilities.ExtentReporter;

public class MyListener implements ITestListener {
	
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	public String testName;
	public WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Operation Begins");
		try {
			extentReport = ExtentReporter.generateExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + "-->" + "Started Execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testName = result.getName();
		extentTest.log(Status.PASS, testName + "-->" + "PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		driver = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
		
		try {
			FileHandler.copy(source, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		testName = result.getName();
		extentTest.addScreenCaptureFromPath(destinationFile);
		extentTest.log(Status.FAIL, testName +  "-->" +"FAIL");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testName = result.getName();
		extentTest.log(Status.SKIP, testName + "-->" + "SKIP");
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathofExtentReport = System.getProperty("user.dir") + "\\test-output\\EXTENTREPORTS\\extentreport.html";
		File extentReport = new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
