package org.Treshna.practice;

import java.lang.reflect.Method;

import org.Treshna.genericUtility.BaseClass;
import org.Treshna.objectRepository.CreateNewOrganizationPage;
import org.Treshna.objectRepository.OrganizationHomePage;
import org.Treshna.objectRepository.OrganizationInformationPage;
import org.Treshna.objectRepository.TabNames;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tc_003_delete extends BaseClass {


	@Test
	public  void deleteOrganization(Method mtd) throws InterruptedException {

		String ExpectedOrganizationName=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "orgName")+randomNumber;
		String industryIropdownvalue = excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "dropdownValue");
		String PhoneNumber=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "phone");
		OrganizationHomePage organizatioHomePage =new OrganizationHomePage(driver);
		commonPage.clickOnRequiredTab(TabNames.Organizations, webDriverUtility);
		organizatioHomePage.clickOnCreateOrganizationIcon();
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createOrganization(ExpectedOrganizationName, PhoneNumber, webDriverUtility, industryIropdownvalue);
		OrganizationInformationPage organizationInformationPage= new OrganizationInformationPage(driver);
		webDriverUtility.waitTillElementVisible(driver, timeout,organizationInformationPage.organizationInfoHeaderDisplay() );
		commonPage.clickOnRequiredTab(TabNames.Organizations, webDriverUtility);
		for (WebElement actualnameOfOrganization: organizatioHomePage.organizationNameList()) {
			if (actualnameOfOrganization.getText().equalsIgnoreCase(ExpectedOrganizationName)) {
				organizatioHomePage.deleteOrganization(webDriverUtility, ExpectedOrganizationName);
				System.out.println("PASS:organization is successfully deleted");
				break;
			} 
		}
		webDriverUtility.scrollUpByJS(driver);
	}
}
