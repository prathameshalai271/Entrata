package TestCases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import jdk.internal.org.jline.utils.Log;

public class TC_4_VerifyFacebookLogin extends TestBase{ //navigate to social media

	@Test
	public void test4() throws InterruptedException
	{
	    //Verify facebook login through the entrata website
		driver.findElement(By.xpath(loc.getProperty("declineCookies"))).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,7000)");
		driver.findElement(By.xpath(loc.getProperty("facebookPage"))).click();
		
		//After clicking on facebook button, new tab gets open, to handle that use getwindowhandles medthod
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		Iterator<String> iterator= windowhandles.iterator();
		String parentwindow = iterator.next();
		System.out.println(parentwindow);
		
		String childwindow = iterator.next();
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		
		//Login to fb with invalid credentials and verify the error message
		driver.findElement(By.xpath(loc.getProperty("fbID"))).sendKeys("Abcde");
		driver.findElement(By.xpath(loc.getProperty("fbPassword"))).sendKeys("Abcde");
		driver.findElement(By.xpath(loc.getProperty("loginButton"))).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("verifyLoginMessage"))));
		WebElement x=driver.findElement(By.xpath(loc.getProperty("verifyLoginMessage")));
		Assert.assertTrue(x.isDisplayed());
		System.out.println(x.getText());
		
    }
	
}
