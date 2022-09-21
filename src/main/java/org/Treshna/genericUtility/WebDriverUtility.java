package org.Treshna.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.TempFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class consists of all methods which are required to do browser related operations
 * @author Admin
 *
 */

public class WebDriverUtility {
	private Actions action;
	private WebDriver driver;
	private JavascriptExecutor js;
	/**
	 * This method helps to launch the browser
	 * @param browser
	 * @return
	 */

	public WebDriver launchBrowser(String browser) {


		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;


		default:
			System.out.println("please enter the valid key");
			break;
		}
		return driver;

	}
	/**
	 * This method helps to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method helps to synchronize the  testscript speed with browser speed
	 * @param driver
	 * @param longTimeout
	 */
	public void waitTillPageLoad(WebDriver driver, Long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	/**
	 * This method help to wait till elements become visible
	 * @param driver
	 * @param longTimeout
	 * @return 
	 */
	public String waitTillElementVisible(WebDriver driver,Long Timeout,WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();

	}


	/**
	 * This method helps to open the application
	 * @param driver
	 * @param url
	 */
	public void navigateToApplication(WebDriver driver,String url) {
		driver.get(url);
	}
	/**
	 * This method is used to launch, maximize,achieve synchronization both explicit and implicit,open the application
	 * @param browser
	 * @param longTimeout
	 * @param url
	 * @return
	 */

	public WebDriver openBrowserWithApplication(String browser,Long longTimeout,String url) {
		driver=launchBrowser(browser);
		maximizeBrowser(driver);
		waitTillPageLoad(driver,longTimeout);
		navigateToApplication(driver,url);
		return driver;
	}
	/**
	 * This method is used to perform mouse hover operations
	 * @param driver
	 * @param Element
	 */

	public void mouseHoverAction( WebElement Element) {

		action.moveToElement(Element).perform();
	}
	/**
	 * This method is used to double click on the element
	 * @param driver
	 * @param Element
	 */
	public void doubleClick( WebElement Element) {
		action.doubleClick(Element).perform();
	}
	/**
	 * This method is used to double click
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		action.doubleClick().perform();
	}
	/**This method is used to close the browser
	 * 
	 * @param driver
	 */
	public void closeTheBrowser(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method is used to select the dropdown with the value
	 * @param element
	 * @param Value
	 */
	public void selectDropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}


	/**
	 * This method is used to select dropdwon with the visible text
	 * @param element
	 * @param visibleText
	 */
	public void selectDropdownByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * This method is used to initialize the java script executor
	 * @param driver
	 */
	private JavascriptExecutor jsExecutor;
	public void downcastJavaScripExecutor(WebDriver driver) {
		jsExecutor = (JavascriptExecutor)driver;

	}
	/**\
	 * This method help to perform click action by using java script executor
	 * @param driver
	 * @param element
	 */
	public void clickByJavaScripExecutor( WebElement element) {

		jsExecutor.executeScript("arguments[0].click()", element);
	}
	/**
	 * scroll by using java script executor
	 * @param element
	 */
	public void scrollToTheElementByJavaScriptExecutor( WebElement element) {

		jsExecutor.executeScript("arguments[0].scrollIntoView", element);
	}

	/**
	 * This method will helps to switch the driver control
	 * @param allwid
	 * @param partialUrl
	 */
	public void switchToWinow( String partialUrl) {
		Set<String> allwid=driver.getWindowHandles();
		for (String wid : allwid) {
			driver.switchTo().window(wid);
			if (wid.equalsIgnoreCase(partialUrl)) {
				break;
			}
		}

	}
	/**
	 * This method helps to click action by using action class
	 * @param driver
	 * @param element
	 */

	public void clickByActionClass( WebElement element) {

		action.click(element).build().perform();

	}

	/**
	 * This method is used mainly to initialize the action class
	 * @param driver
	 */
	public void initializeTheActionClass( WebDriver driver ){
		action=new Actions(driver);
	}
	/**
	 * This method is used to convert the dynamic xpath into By locator
	 * @param dynamicXpath
	 * @param replacedData
	 * @return
	 */
	public By convertDynamicXpathIntoByClass(String dynamicXpath,String replacedData) {
		String requiredXpath = String.format(dynamicXpath, replacedData);
		By element = By.xpath(requiredXpath);
		return element;
	}
	/**
	 * This method is used to convert the  dynamic xpath into thr webelement 
	 * @param dynamicXpath
	 * @param replacedData
	 * @param driver
	 * @return
	 */
	public WebElement convertDynamicXpathIntoWebelement(String dynamicXpath,String replacedData,WebDriver driver) {
		String requiredXpath = String.format(dynamicXpath, replacedData);
		WebElement element = driver.findElement(By.xpath(requiredXpath));
		return element;
	}


	public String screenshot(WebDriver driver,JavaUtility javaUtility,String ClassName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String currentTime = javaUtility.currentTime();
		File destFile=new File("./Screenshot/"+ClassName+"_"+currentTime+".png");
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(tempfile, destFile);

		return destFile.getAbsolutePath();
	}
	
	public String screenshot(WebDriver driver) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String tempfile = ts.getScreenshotAs(OutputType.BASE64);
		return tempfile;
	}



	
	public void downcastJavaScriptExecutor(WebDriver driver) {
		jsExecutor = (JavascriptExecutor)driver;
	}
/**
 * This method is used to scroll up by 1000 units
 * @param driver
 */
	public void scrollUpByJS(WebDriver driver) {
		jsExecutor.executeScript("window.scrollTo(0,-1000)");
	}

	public void ScrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void eventStartTimeDropdown(WebElement element1,WebElement element2,WebElement element3,String hour,String minute,String seconds) {
		Select select1 = new Select(element1);
		select1.selectByVisibleText(hour);
		Select select2 = new Select(element2);
		select2.selectByVisibleText(minute);
		Select select3 = new Select(element3);
		select3.selectByVisibleText(seconds);
	}
	
	public void eventEndTimeDropdown(WebElement element1,WebElement element2,WebElement element3,String hour,String minute,String seconds) {
		Select select1 = new Select(element1);
		select1.selectByVisibleText(hour);
		Select select2 = new Select(element2);
		select2.selectByVisibleText(minute);
		Select select3 = new Select(element3);
		select3.selectByVisibleText(seconds);
	}
	
	
	
	




}
