package org.Treshna.objectRepository;

import java.util.List;

import org.Treshna.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderHomePage {

	@FindBy(xpath="//a[text()='All Events & Todos']")
	private WebElement allEventsAndTodosButton;
	
	@FindBy(xpath="//a[text()='Subject']/ancestor::tr/following-sibling::tr[@class='lvtColData']//span[@vtfieldname='subject']")
	private List<WebElement> listOfEventNames;
	
	@FindBy(xpath="//a[text()='Calendar']")
	protected WebElement calenderHomePageTest;
	
	
	
	public CalenderHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAllEventsAndTodosButton() {
		allEventsAndTodosButton.click();
	}
	
	public void clickByjs(WebDriverUtility webdriverUtility) {
		webdriverUtility.clickByJavaScripExecutor(allEventsAndTodosButton);
	}
	
	public List<WebElement> listOfAllEventNames() {
		return listOfEventNames;
	}
	
	public WebElement calenderHomePageText() {
		return calenderHomePageTest;
	}
}
