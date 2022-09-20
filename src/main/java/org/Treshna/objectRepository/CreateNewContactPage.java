package org.Treshna.objectRepository;

import java.util.List;
import java.util.Set;

import org.Treshna.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	
	@FindBy(name="lastname")
	private WebElement lastnameTextField;
	
	@FindBy(name="firstname")
	private WebElement firstNameTextField;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//input[@name='mobile']/ancestor::td/preceding-sibling::td[@class='dvtCellInfo']//img[@alt='Select']")
	private WebElement selectIcon;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private List<WebElement> listOfOrgNamesInChildWindowOfContact;
	
	private String partialUrl="Accounts&action";
	private String partialUrlContact="Contacts&action";
	

	private WebDriver driver;
	
	public CreateNewContactPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void createContact(String lastname,WebDriverUtility webDriverUtility,String ExpectedOrganizationName) {
		lastnameTextField.sendKeys(lastname);
		selectIcon.click();
		
		webDriverUtility.switchToWinow( partialUrl);
		for (WebElement wid : listOfOrgNamesInChildWindowOfContact) {
			if (wid.getText().contains(ExpectedOrganizationName)) {
				wid.click();
				break;
			}
		}
		webDriverUtility.switchToWinow( partialUrlContact);
		webDriverUtility.scrollUpByJS(driver);
		saveButton.click();
	}
}
