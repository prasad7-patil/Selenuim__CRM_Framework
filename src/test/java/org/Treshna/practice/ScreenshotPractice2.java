package org.Treshna.practice;

import org.Treshna.genericUtility.BaseClass;
import org.Treshna.genericUtility.ListnerImplementation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotPractice2 extends BaseClass{

	@Test
	
	public void screenshot() {
		ListnerImplementation.stest.assignAuthor("vinay");
		ListnerImplementation.stest.assignCategory("smoke");
		
		ListnerImplementation.stest.info("browser launched successfully");
		ListnerImplementation.stest.info("login successfull");
		ListnerImplementation.stest.info("home page displayed successfully");
		Assert.fail();
	}
}
