package com.tutorialsNinja.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	    
	    //Step 1: Add the extentreports dependency in pom.xml
	
	public static ExtentReports generateExtentReport() throws Exception {
	
		//Step 2: Create the Object of ExtentReports Class
		ExtentReports extentReport = new ExtentReports();
		
		//Step 3: Create the object of the File Class and pass the path of the extentreport which is an html file in the constructor
		File extentReportFile = new File(System.getProperty("user.dir")+ "\\test-output\\EXTENTREPORTS\\extentreport.html");
		
		//Step 4: Create the object of ExtentSparkReporter and pass the path of the File in it's constructor
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		//Step 5: Using this sparkReporter we can configure a lot of things in the extentreport.html file
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("PnT Jan-June Automation Weekday Batch");
		sparkReporter.config().setDocumentTitle("TutorialsNinja | AutomationSuite");
		//sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		//Step 6: We need to attach the ExtentReport with the Spark Reporter
		extentReport.attachReporter(sparkReporter);
		
		//Step 7: Add more additional information - System information
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsNinja\\Config\\config.properties");
		prop.load(ip);
		
		extentReport.setSystemInfo("application url", prop.getProperty("url"));
		extentReport.setSystemInfo("login input", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("browser preference", prop.getProperty("browser"));
		extentReport.setSystemInfo("java version", System.getProperty("java.vm.specification.version"));
		extentReport.setSystemInfo("SDET Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Country Name", System.getProperty("user.country"));
		extentReport.setSystemInfo("Java Version Date", System.getProperty("java.version.date"));
		
		//Step 8: Return the extentReport
		return extentReport;
		
	}
	
	
	

	
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		System.out.println("******************************************");
		System.out.println(System.getProperty("java.vm.specification.version"));
		
	}

}
