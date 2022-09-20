package org.Treshna.practice;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.Treshna.genericUtility.BaseClass;
import org.Treshna.genericUtility.DataType;
import org.Treshna.genericUtility.ExcelUtility;
import org.Treshna.genericUtility.FileUtility;
import org.Treshna.genericUtility.IConstantPath;
import org.Treshna.genericUtility.JavaUtility;
import org.Treshna.genericUtility.WebDriverUtility;
import org.Treshna.objectRepository.CreateNewProductPage;
import org.Treshna.objectRepository.ProductHomePage;
import org.Treshna.objectRepository.ProductInformationPage;
import org.Treshna.objectRepository.TabNames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_002_createProduct extends BaseClass {
	@Test
	public  void createProduct(Method mtd) {

		//step1----->fetchThedatafromExcel
		String productName = excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "product name")+randomNumber;
		String productCategoryDropdownValue = excelUtility.getDataFromDataFromExcel("organization", mtd.getName(), "product_category_dropdown_value");

		System.out.println(productCategoryDropdownValue);
		commonPage.clickOnRequiredTab(TabNames.Products, webDriverUtility);
		ProductHomePage productHomePage=new ProductHomePage(driver);
		productHomePage.clickOnCreateProductIcon();
		CreateNewProductPage createNewProductPage=new  CreateNewProductPage(driver);
		createNewProductPage.createProduct( productName, productCategoryDropdownValue,webDriverUtility);
		ProductInformationPage productInformationPage=new ProductInformationPage(driver);
		webDriverUtility.waitTillElementVisible(driver, timeout, productInformationPage.productInfoHeaderText());
		commonPage.clickOnRequiredTab(TabNames.Products, webDriverUtility);
		//WebDriverUtility.selectDropdownByVisibleText(productCategoryDropdown, product_category_value);
		
		//List<WebElement> listOfProducts = driver.findElements(By.xpath("//a[text()='Product Name']/ancestor::tr/following-sibling::tr//a[@title='Products']"));
		for (WebElement prodtName : productHomePage.getListOfProductNames()) {
			if (prodtName.getText().equals(productName)) {
				System.out.println("PASS:Successfully created the product");
				
			}
		}
		
	}
}