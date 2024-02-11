package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.TestBase;

public class TC_5_VerifyResidentLogin extends TestBase {
	@Test
	public void test5()
	{
		//signin using residentlogin
		 driver.findElement(By.xpath(loc.getProperty("signin"))).click(); 
		 driver.findElement(By.xpath(loc.getProperty("declineCookies"))).click();
		 WebElement login=driver.findElement(By.xpath(loc.getProperty("residentLogin")));
	     login.click();
	     
	     //select view the app and scroll down the page
	     driver.findElement(By.xpath(loc.getProperty("viewTheApp"))).click();
	     JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,3000)");
		 
		 //fill the contact us form
		 driver.findElement(By.xpath(loc.getProperty("name"))).sendKeys("Prathamesh");
	     driver.findElement(By.xpath(loc.getProperty("emailResidentLogin"))).sendKeys("prathameshalai271@gmail.com");
	     driver.findElement(By.xpath(loc.getProperty("propertyName"))).sendKeys("entrata");
	     driver.findElement(By.xpath(loc.getProperty("propertyURL"))).sendKeys("entrata.com");
	     driver.findElement(By.xpath(loc.getProperty("message"))).sendKeys("Successfully Contacted");
	}

}
