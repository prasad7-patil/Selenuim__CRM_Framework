package org.Treshna.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProductInfoHeaderText;
	
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[.='Products']")
	private WebElement productMajorTab;
	
	public WebElement productInfoHeaderText() {
		return ProductInfoHeaderText;

	}
	
	public void clickOnProductMajorTab() {
		productMajorTab.click();

	}
	
}