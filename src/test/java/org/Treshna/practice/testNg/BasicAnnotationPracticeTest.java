package org.Treshna.practice.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicAnnotationPracticeTest {

	@BeforeSuite
	public void setUpBs() {
		System.out.println("before suite");
	}
	@BeforeTest
	public void setUpBt() {
		System.out.println("before test");
	}
	
	@BeforeClass
	public void setUpBc() {
		System.out.println("before class");
	}
	@BeforeMethod
	public void setUpBM() {
		System.out.println("before method1");
	}
	
	@Test
	public void setUpTest1() {
		System.out.println("Test1");
	}
	@Test
	public void setUpTest2() {
		System.out.println("Test2");
	}
	@AfterMethod
	public void setUpAM() {
		System.out.println("after method");
	}
	@AfterMethod
	public void setUpBM1() {
		System.out.println("before method2");
	}
	
	@AfterClass
	public void setUpAc() {
		System.out.println("before class");
	}
	@AfterTest
	public void setUpAt() {
		System.out.println("before test");
	}

	@AfterSuite
	public void setUpAs() {
		System.out.println("before suite");
	}
}
