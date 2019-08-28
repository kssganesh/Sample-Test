package Sample1.Sample1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class FB_Login
{
	
	public static void main(String[] args) {
   
		String Chromepath= System.getProperty("user.dir");
		System.out.println(Chromepath);
		
		System.setProperty("webdriver.chrome.driver", Chromepath+"/Drivers//Chromedriver//chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		
		WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys("kssganesh@gmail.com");;
		
		WebElement password= driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys("Ganesh@5973");
		
		WebElement Login= driver.findElement(By.xpath("//label[@id='loginbutton']"));
		Login.submit();
		
		//WebElement expand= driver.findElement(By.xpath("//div[@id='userNavigationLabel']"));
		//expand.click();
		
		//WebElement logout= driver.findElement(By.xpath("//span[contains(text(),'Log Out')]"));
		//logout.click();
		
	
	driver.quit();;
	}
}
