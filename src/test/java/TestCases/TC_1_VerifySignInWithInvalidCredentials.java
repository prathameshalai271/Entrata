package TestCases;


import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import Base.TestBase;

public class TC_1_VerifySignInWithInvalidCredentials extends TestBase {


	@Test
	public void test1()  
	{
	    driver.findElement(By.xpath(loc.getProperty("signin"))).click(); 
		driver.findElement(By.xpath(loc.getProperty("declineCookies"))).click();
		WebElement login=driver.findElement(By.xpath(loc.getProperty("propertyManagerLogin")));
		login.click();
		
		//Keep Username and password field blank and click on SignIn and Verify the error message
		driver.findElement(By.xpath(loc.getProperty("clickOnSignInButton"))).click();
		WebElement verifySignIn = driver.findElement(By.xpath(loc.getProperty("verifySignInMessage")));
		Assert.assertTrue(verifySignIn.isDisplayed());
		System.out.println(verifySignIn.getText());
    }
}
