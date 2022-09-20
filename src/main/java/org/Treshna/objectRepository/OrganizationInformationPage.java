package org.Treshna.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInformationText;
	
	@FindBy(xpath = "//a[text()='Add Event']")
	private WebElement addEventLink;

	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement organizationInfoHeaderDisplay() {
		return organizationInformationText;

	}
	
	public void clikOnAddEvent() {
		addEventLink.click();
	}
}
