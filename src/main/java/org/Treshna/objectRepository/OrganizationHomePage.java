package org.Treshna.objectRepository;

import java.util.List;
import java.util.Set;

import org.Treshna.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class OrganizationHomePage {
	
	

	private WebDriver driver;
			
	@FindBy(xpath  = "//a/img[@title='Create Organization...']")
	protected WebElement createOrganiztionIcon;

	@FindBy(xpath = "//a[text()='Organization Name']/ancestor::tr/following-sibling::tr//a[@title='Organizations']")
	private List<WebElement> organizationNameList;
	

	private String dynamicXpath ="//a[text()='%s']/ancestor::td/preceding-sibling::td//input[@name='selected_id']";
	
	@FindBy(xpath="//td/input[@value='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationHomePageText;
	
	
	public OrganizationHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to click on the create Organization Icon
	 */
	public void clickOnCreateOrganizationIcon() {
		createOrganiztionIcon.click();

	}
	
	/**
	 *  This method is used to get the list of all organization name
	 * 
	 * @return
	 */
	public List<WebElement> organizationNameList() {
		return organizationNameList;
	}
	
	public void deleteOrganization(WebDriverUtility webDriverUtility,String organizationName) {
		webDriverUtility.convertDynamicXpathIntoWebelement(dynamicXpath,organizationName,driver).click();
		deleteButton.click();
		driver.switchTo().alert().accept();
		
		
	}
	
	
	
}
