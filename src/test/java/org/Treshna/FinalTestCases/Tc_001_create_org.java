package org.Treshna.FinalTestCases;

import java.lang.reflect.Method;

import org.Treshna.genericUtility.BaseClass;
import org.Treshna.objectRepository.CreateNewOrganizationPage;
import org.Treshna.objectRepository.OrganizationHomePage;
import org.Treshna.objectRepository.OrganizationInformationPage;
import org.Treshna.objectRepository.TabNames;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tc_001_create_org extends BaseClass{

//abcde
	@Test
	public void createOrganization(Method mtd) throws InterruptedException {

		
		String ExpectedOrganizationName=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "organization name")+randomNumber;
		String PhoneNumber=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "phone");
		OrganizationHomePage organizatioHomePage =new OrganizationHomePage(driver);
		commonPage.clickOnRequiredTab(TabNames.Organizations, webDriverUtility);
		organizatioHomePage.clickOnCreateOrganizationIcon();
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createOrganization(ExpectedOrganizationName, PhoneNumber);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		webDriverUtility.waitTillElementVisible(driver, timeout,organizationInformationPage.organizationInfoHeaderDisplay() );
		commonPage.clickOnRequiredTab(TabNames.Organizations, webDriverUtility);
		commonPage.clickOnOrganizationMajorTab();
		for (WebElement actualnameOfOrganization: organizatioHomePage.organizationNameList()) {
			if (actualnameOfOrganization.getText().contains(ExpectedOrganizationName)) {
				Reporter.log("successfully created the organization");
			}
		}
		webDriverUtility.scrollUpByJS(driver);		
	}
}

