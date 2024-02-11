package Base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties loc= new Properties();
	public static FileReader fr;
	
	@BeforeTest
	 public void setup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resource\\Configfiles\\locators.properties");
		loc.load(fr);
		driver.manage().window().maximize();
		driver.get("https://www.entrata.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
}
