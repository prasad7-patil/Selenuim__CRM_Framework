package org.Treshna.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHomePage {

	@FindBy(xpath = "//a/img[@alt='Create Product...']")
	private WebElement createProductIcon;
	
	@FindBy(xpath = "//a[text()='Product Name']/ancestor::tr/following-sibling::tr//a[@title='Products']")
	private List<WebElement> listOfProductNames;
	
	public ProductHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnCreateProductIcon() {
		createProductIcon.click();
	}
	
	public List<WebElement> getListOfProductNames() {
		return listOfProductNames;
	}
}
