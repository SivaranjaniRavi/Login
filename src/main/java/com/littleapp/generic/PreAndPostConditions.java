package com.littleapp.generic;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PreAndPostConditions implements EnvironmentConstants {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	
	static{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@BeforeSuite
	public void initial(){
		report=new ExtentReports(REPORTS_PATH);
	}
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional ("chrome") String browser, Method testName){
		if(browser.equals("chrome")){
			driver=new ChromeDriver();
		}
		else{
			driver=new FirefoxDriver();
		}
		//driver=new ChromeDriver();
		String url=FunctionLibrary.getPropery(SETTING_PATH, "URL");
		driver.get(url);
		String strITO=FunctionLibrary.getPropery(SETTING_PATH, "ITO");
		long ITO=Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		
		String name=testName.getName();
		test=report.startTest(name);
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult res) throws InterruptedException{
		String name=res.getName();
		int status=res.getStatus();
		if(status==2){
			String imgPath=FunctionLibrary.getPhoto(driver, SCREENSHOT_PATH, name);
			Reporter.log("Imagepath:"+imgPath,true);
		}
		
		if(status==1){
			test.log(LogStatus.PASS, "pass");
		}
		else{
			test.log(LogStatus.FAIL, "fail");
		}
		report.endTest(test);
		
		Thread.sleep(2000);
		driver.close();
	}
	
	@AfterSuite
	public void end(){
		report.flush();
	}

}
