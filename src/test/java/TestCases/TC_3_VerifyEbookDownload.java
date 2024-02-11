package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;

public class TC_3_VerifyEbookDownload extends TestBase{
	
	@Test
	public void test3() throws InterruptedException
	{
		//Click on Resources and click on download ebook
		driver.findElement(By.xpath(loc.getProperty("resources"))).click();
		driver.findElement(By.xpath(loc.getProperty("declineCookies"))).click();
		driver.findElement(By.xpath(loc.getProperty("downloadNow"))).click();
		//fill the form keeping one field blank
     	driver.findElement(By.xpath(loc.getProperty("firstName"))).sendKeys("Prathamesh");
     	driver.findElement(By.xpath(loc.getProperty("lastName"))).sendKeys("Alai");
     	driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys("prathameshalai271@gmail.com");
     	driver.findElement(By.xpath(loc.getProperty("companyName"))).sendKeys("entrata");
     	driver.findElement(By.xpath(loc.getProperty("phoneNumber"))).sendKeys("9307880587");
     	driver.findElement(By.xpath(loc.getProperty("unitCount"))).sendKeys("1-10");
     	   //driver.findElement(By.xpath(loc.getProperty("jobTitle"))).sendKeys("SDET");
     	//click on download and verify the error message
     	driver.findElement(By.xpath(loc.getProperty("downloadE-Book"))).click();
     	WebElement errorMessage=driver.findElement(By.xpath(loc.getProperty("verifyErrorMessage")));
		Assert.assertTrue(errorMessage.isDisplayed());
		System.out.println(errorMessage.getText());
     	
	}


}
