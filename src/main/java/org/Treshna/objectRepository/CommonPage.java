package org.Treshna.objectRepository;

import org.Treshna.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	private WebDriver driver;
	private String dynamicXpath="//a[.='%s']";

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signoutLink;
	
	
	//hello--updated by te2
	
	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement organizationMajorTab;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createIcon;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signOut(WebDriverUtility webDriverUtility) {
		webDriverUtility.mouseHoverAction(administratorIcon);
		webDriverUtility.convertDynamicXpathIntoWebelement(dynamicXpath, "Sign Out", driver).click();
		//signoutLink.click();
	}
	
	public void clickOnOrganizationMajorTab() {
		organizationMajorTab.click();
		
	}
	
	public void clickOnRequiredTab(TabNames tabName,WebDriverUtility webDriverUtility) {
		webDriverUtility.convertDynamicXpathIntoWebelement(dynamicXpath,tabName.toString(),driver).click();
	}
	
	public void clicOnCreateIcon() {
		createIcon.click();
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

}

