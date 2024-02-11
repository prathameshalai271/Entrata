package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;

public class TC_2_VerifyDropdownSelectionAndFillTheForm extends TestBase{
	
	@Test
	public void test2() throws IOException, InterruptedException 
	{
		driver.findElement(By.xpath(loc.getProperty("declineCookies"))).click();
		
		//Hover on products tab and select one value(i.e.ResidentPay) from dropdown
     	WebElement x=driver.findElement(By.xpath(loc.getProperty("clickOnProducts")));
     	Actions action =new Actions(driver);
     	action.moveToElement(x).build().perform();
     	WebElement option1=driver.findElement(By.xpath(loc.getProperty("clickOnOption1")));
     	option1.click();
     	
     	//Click on schedule demo
     	driver.findElement(By.xpath(loc.getProperty("scheduleDemo"))).click();
     	//fill the form
     	driver.findElement(By.xpath(loc.getProperty("firstName"))).sendKeys("Prathamesh");
     	driver.findElement(By.xpath(loc.getProperty("lastName"))).sendKeys("Alai");
     	driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys("prathameshalai271@gmail.com");
     	driver.findElement(By.xpath(loc.getProperty("companyName"))).sendKeys("entrata");
     	driver.findElement(By.xpath(loc.getProperty("phoneNumber"))).sendKeys("9307880587");
     	driver.findElement(By.xpath(loc.getProperty("unitCount"))).sendKeys("1-10");
     	driver.findElement(By.xpath(loc.getProperty("jobTitle"))).sendKeys("SDET");
	}

}
