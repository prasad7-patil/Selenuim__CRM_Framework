package HardCodedTestCases;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_002_delete {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		//Random random = new Random();
		//int randomNum = random.nextInt(100);
		driver.get("http://rmgtestingserver:8888/");
		String orgnName="cognizant";
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		//js.executeScript("arguments[0].click();", org);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgnName);
		WebElement industryDropdown = driver.findElement(By.name("industry"));
		Select select = new Select(industryDropdown);
		select.selectByValue("Education");
		//driver.findElement(By.name("button")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//WebElement homeButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']"));
		//js.executeScript("arguments[0].click();", homeButton);
		WebElement orgButton = driver.findElement(By.xpath("//td[@class='moduleName']/a[text()='Organizations']"));
		js.executeScript("arguments[0].click();", orgButton);
		List<WebElement> listOrgName = driver.findElements(By.xpath("//a[contains(text(),'Organization Name')]/ancestor::tr/following-sibling::tr//a[@title='Organizations']"));
		for (WebElement webElement : listOrgName) {
			if (webElement.getText().equals(orgnName)) {
				driver.findElement(By.xpath("//a[text()='"+orgnName+"']/ancestor::td/preceding-sibling::td//input[@name='selected_id']")).click();
				
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
		driver.switchTo().alert().accept();
		//System.out.println("organization is deleted");
		List<WebElement> listNewOrgName = driver.findElements(By.xpath("//a[text()='Organization Name']/ancestor::tr/following-sibling::tr//a[@title='Organizations']"));
		for (WebElement webElement : listNewOrgName) {
			if (!(webElement.getText().contains(orgnName))) {
				System.out.println("pass:organization is  deleted");
				break;
			}
			
		}
		driver.quit();
		
		/*
	Actions action=new Actions(driver);
	WebElement signOutIcon = driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]"));
	action.moveToElement(signOutIcon);
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
		 */
	}
}
