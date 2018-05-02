package com.littleapp.scripts;





import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.littleapp.generic.PreAndPostConditions;

public class Test1  {
	@BeforeSuite				//  one
	public void suitemethod() {
		System.out.println("this is beforesuite");
	}
	@BeforeTest				//two
	public void beforetestmethod() {
		System.out.println("this is before test");
	}
	@AfterTest
	public void aftertestmethod() {
		System.out.println("this is after test");
	}
	@BeforeClass
	public void beforclassmeth() {
		System.out.println("this is beforeclass");
	}
	@AfterClass
	public void afterclassmeth() {
		System.out.println("this is after class ");
	}
	@BeforeMethod
	public void beforemeth() {
		System.out.println("this is beforemethod");
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("this is aftermethod ");
	}
	@AfterSuite
	public void asuitemethod() {
		System.out.println("this is after suite method");
	}
	@Test
	public void test1() {
		System.out.println("this is test1");
	}
	@Test
	public void test2() {
		System.out.println("this is test2");
	}
	
	
}
