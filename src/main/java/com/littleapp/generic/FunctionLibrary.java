package com.littleapp.generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class FunctionLibrary {
	public static String getPropery(String path,String url){
		String v="";
		try{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(url);
		}
		catch(Exception e){
			Reporter.log(e.toString(),true);
		}
		return v;
	}
	
	public static String  getPhoto(WebDriver driver,String folder, String name){
		TakesScreenshot t=(TakesScreenshot)driver;
		File scr=t.getScreenshotAs(OutputType.FILE);
		String dt=new Date().toString().replaceAll(":","_");
		String path=folder+name+dt+".png";
		File des=new File(path);
		try{
			FileUtils.copyFile(scr,des);
		}
		catch(Exception e){}
		return path;
	}

}
