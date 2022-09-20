package org.Treshna.objectRepository;

import java.util.Map;

import org.Treshna.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {

	private WebDriverUtility webdriverUtility;
	

	@FindBy(name = "accountname")
	private WebElement accountNameTextField;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	



	
	
	public CreateNewOrganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void createOrganization(String organizationName,String phoneNumber) {
		accountNameTextField.sendKeys(organizationName);
		phoneNumberTextField.sendKeys(phoneNumber);
		saveButton.click();
	}
	
	public void createOrganization(String organizationName,String phoneNumber,WebDriverUtility webdriverUtility,String dropdwonValue ) {
		
		accountNameTextField.sendKeys(organizationName);
		webdriverUtility.selectDropdownByVisibleText(industryDropdown, dropdwonValue);
		phoneNumberTextField.sendKeys(phoneNumber);
		saveButton.click();
	}

}
