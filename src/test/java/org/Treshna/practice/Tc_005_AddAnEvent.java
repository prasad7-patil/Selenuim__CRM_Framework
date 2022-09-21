package org.Treshna.practice;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Set;

import org.Treshna.genericUtility.BaseClass;
import org.Treshna.objectRepository.CalenderHomePage;
import org.Treshna.objectRepository.CreateNewOrganizationPage;
import org.Treshna.objectRepository.CreatingEventPage;
import org.Treshna.objectRepository.OrganizationHomePage;
import org.Treshna.objectRepository.OrganizationInformationPage;
import org.Treshna.objectRepository.TabNames;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_005_AddAnEvent extends BaseClass {
	
	@Test
	public  void AddAnEventToOrganization(Method mtd) throws InterruptedException {
		
		String expectedOrganizationName=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "org Name")+randomNumber;
		String PhoneNumber=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "phone");
		String eventStartTime=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "event Start Time");
		String eventEndTime=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "event End Time");
		String StartdateOfEvent=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "date Of event");
		String typeOfEvent=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "event Type");
		String eventName=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "event Name")+randomNumber;
		String eventLocation=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "location of event");
		String descriptionDetails=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "Description text area");
		String endDateOfEvent=excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "end date of event");
		
 		OrganizationHomePage organizatioHomePage =new OrganizationHomePage(driver);
		commonPage.clickOnRequiredTab(TabNames.Organizations, webDriverUtility);
		organizatioHomePage.clickOnCreateOrganizationIcon();
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		createNewOrganizationPage.createOrganization(expectedOrganizationName, PhoneNumber);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		webDriverUtility.waitTillElementVisible(driver, timeout,organizationInformationPage.organizationInfoHeaderDisplay() );
		organizationInformationPage.clikOnAddEvent();
		CreatingEventPage creatingEventPage=new CreatingEventPage(driver);
		creatingEventPage.createAnEventDetails(webDriverUtility, typeOfEvent, eventName, eventLocation, descriptionDetails);
		creatingEventPage.fillEventStartTimeAndDate(eventStartTime, webDriverUtility, javaUtility, StartdateOfEvent);
		creatingEventPage.fillEventEndTimeAndDate(eventEndTime, webDriverUtility, javaUtility, endDateOfEvent);
		commonPage.clickOnSaveButton();
		CalenderHomePage calenderHomePage=new CalenderHomePage(driver);
		commonPage.clickOnRequiredTab(TabNames.Calendar, webDriverUtility);
		webDriverUtility.waitTillElementVisible(driver, timeout,calenderHomePage.calenderHomePageText());
		calenderHomePage.clickByjs(webDriverUtility);
		//calenderHomePage.clickOnAllEventsAndTodosButton();
		
		for (WebElement nameOfEvent : calenderHomePage.listOfAllEventNames()) {
			if (nameOfEvent.getText().contains(eventName)) {
				System.out.println("PASS:Successfully created the event");
				break;
				
			}		
		}
//		count++;
//		if (count==1) {
//			System.out.println("FAIL:event not created");
//		}
	
	}
}
