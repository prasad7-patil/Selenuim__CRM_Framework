package org.Treshna.FinalTestCases;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.Treshna.genericUtility.BaseClass;
import org.Treshna.genericUtility.DataType;
import org.Treshna.genericUtility.ExcelUtility;
import org.Treshna.genericUtility.FileUtility;
import org.Treshna.genericUtility.IConstantPath;
import org.Treshna.genericUtility.JavaUtility;
import org.Treshna.genericUtility.WebDriverUtility;
import org.Treshna.objectRepository.CreateNewContactPage;
import org.Treshna.objectRepository.CreateNewOrganizationPage;
import org.Treshna.objectRepository.OrganizationHomePage;
import org.Treshna.objectRepository.OrganizationInformationPage;
import org.Treshna.objectRepository.TabNames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_004_CreateOraganizationAndCheckInContactModule extends BaseClass {
	
	@Test
	public  void CreateOraganizationAndCheckInContactModule(Method mtd) {
		
		
		String ExpectedOrganizationName=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "orgname")+randomNumber;
		String PhoneNumber=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "phone");
		String ExpectedContactName=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "contact last name");
		
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
			if (actualnameOfOrganization.getText().equalsIgnoreCase(ExpectedOrganizationName)) {
				System.out.println("PASS:organization is successfully created");
			} 
		}
		commonPage.clickOnRequiredTab(TabNames.Contacts, webDriverUtility);
		commonPage.clicOnCreateIcon();
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		createNewContactPage.createContact(ExpectedContactName, webDriverUtility, ExpectedOrganizationName);
	}

}
