package org.Treshna.objectRepository;

import org.Treshna.genericUtility.JavaUtility;
import org.Treshna.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingEventPage {

	@FindBy(name="subject")
	private WebElement  eventTextField;
	
	@FindBy(name="activitytype")
	private WebElement  eventTypeDropDown;
	
	@FindBy(name="description")
	private WebElement  descriptionTextArea;
	
	@FindBy(name="location")
	private WebElement  locationTextArea;
	
	@FindBy(name="starthr")
	private WebElement  eventStartinghour;
	
	@FindBy(name="startmin")
	private WebElement  eventStartingMinute;
	
	@FindBy(name="startfmt")
	private WebElement  eventStartFormat;
	
	@FindBy(name="endhr")
	private WebElement  eventEndhour;
	
	@FindBy(name="endmin")
	private WebElement  eventEndMinute;
	
	@FindBy(name="endfmt")
	private WebElement  eventEndFormat;
	

	@FindBy(name="date_start")
	private WebElement  eventStartDateTextArea;
	
	@FindBy(name="due_date")
	private WebElement  eventEndDateTextArea;
	
	
	public CreatingEventPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createAnEventDetails(WebDriverUtility webDriverUtility,String eventType,String eventName,String locationName,String descriptionTextDetails ) {
		webDriverUtility.selectDropdownByValue(eventTypeDropDown, eventType);
		eventTextField.sendKeys(eventName);
		descriptionTextArea.sendKeys(descriptionTextDetails);
		locationTextArea.sendKeys(locationName);
	}
	public void fillEventStartTimeAndDate(String eventStartTime,WebDriverUtility webDriverUtility,JavaUtility javaUtility,String startDate) {
		String[] splittedTime = javaUtility.splitTheTimeInHHMMFormat(eventStartTime);
		String HH=null;
		String MM=null;
		String PM=null;
		for (int i = 0; i < splittedTime.length; i++) {
			HH=splittedTime[0];
			MM=splittedTime[1];
			PM=splittedTime[2];
		}
		
		webDriverUtility.eventStartTimeDropdown(eventStartinghour, eventStartingMinute, eventStartFormat, HH, MM, PM);
		eventStartDateTextArea.clear();
		eventStartDateTextArea.sendKeys(startDate);
		
	}
	public void fillEventEndTimeAndDate(String eventEndTime,WebDriverUtility webDriverUtility,JavaUtility javaUtility,String endDate) {
		String[] splittedTime = javaUtility.splitTheTimeInHHMMFormat(eventEndTime);
		String HH=null;
		String MM=null;
		String PM=null;
		for (int i = 0; i < splittedTime.length; i++) {
			HH=splittedTime[0];
			MM=splittedTime[1];
			PM=splittedTime[2];
		}
		webDriverUtility.eventEndTimeDropdown(eventEndhour, eventEndMinute, eventEndFormat, HH, MM, PM);
		eventStartDateTextArea.clear();
		eventStartDateTextArea.sendKeys(endDate);
		
	}
	
	
}
