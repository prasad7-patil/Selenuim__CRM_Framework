package org.Treshna.objectRepository;

import java.util.Map;

import org.Treshna.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {
	
	//private WebDriverUtility webDriverUtility;
	@FindBy(name= "productcategory")
	private WebElement productCategoryDropdown;
	
	@FindBy(name= "productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void createProduct(String productName,String productCategoryValue,WebDriverUtility webDriverUtility) {
		productNameTextField.sendKeys(productName);
		webDriverUtility.selectDropdownByVisibleText(productCategoryDropdown, productCategoryValue);
		saveButton.click();
	}
	
}
