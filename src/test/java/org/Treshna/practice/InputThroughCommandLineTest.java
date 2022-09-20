package org.Treshna.practice;

import org.testng.annotations.Test;

public class InputThroughCommandLineTest {

	@Test
	
	public void testCase1() {
		String name = System.getProperty("n");
		System.out.println("hello my name is ======>"+name);
	}
}
