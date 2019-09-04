package Sample1.Sample1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */


public class FB_Login_Test
{
	
	WebDriver driver = null	;
	@BeforeTest
	public void setup() {
		String Chromepath= System.getProperty("user.dir");
		System.out.println(Chromepath);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();	
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", Chromepath+"/Drivers//Chromedriver//chromedriver.exe");
		
		 driver = new ChromeDriver(options);

	}
	
	@Test
	public  void Login_URL() {
   
				driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys("kssganesh@gmail.com");;
		
		WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("Ganesh@5973");
		
		WebElement Login= driver.findElement(By.xpath("//label[@id='loginbutton']"));
		Login.submit();
		}
	
	@Test
	public void Manage_group(){
		WebElement expand= driver.findElement(By.xpath("//div[@id='userNavigationLabel']"));
		expand.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Manage Groups')]")));
		
		WebElement groups=driver.findElement(By.xpath("//span[contains(text(),'Manage Groups')]"));
		groups.click();
		expand.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Manage Groups')]")));
		
	}
	@Test
	public void logout(){
		
		WebElement logout= driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
		logout.click();
	}
	
	@AfterTest
	public void teardown() {
	driver.close();
		driver.quit();
	System.out.println("Test Completed Sucessfully");
	
	}
	}

