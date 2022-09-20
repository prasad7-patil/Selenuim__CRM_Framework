package org.Treshna.practice;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class basicConfigAnnotationPracticeTest {

	@Test
	@BeforeSuite
	public void suiteSetUp() {
		System.out.println("before suit");
	}

	@Test
	
	public void classSetUp() {
		System.out.println("before class");
	}

	@Test
	@BeforeSuite
	public void TestSetUp() {
		System.out.println("before suit");
	}
}

