package Day17;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		1) Launch browser
		2) open url
			https://opensource-demo.orangehrmlive.com/
		3) Provide username  - Admin
		4) Provide password  - admin123
		5) Click on Login button 
		6) Verify the title of dashboard page   
			Exp title : OrangeHRM
		7) close browser

		 */
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\parmeet kapoor\\Documents\\DRIVERS\\chromedriver.exe");
		
		
		//Launch browser
		WebDriver driver=new ChromeDriver();
		
		
		
		//open url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);
		
		driver.manage().window().maximize(); // maximize the page
		
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		//String act_title = driver.getTitle();
		//String exp_title = "OrangeHRM";
		String exp_label = "Dashboard";
		String Act_label=null;
		Thread.sleep(5000);
		
		try{
			
			Act_label=driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
			  
		
			}catch(NoSuchElementException e) {
				Act_label="";
		}
		
		if(Act_label.equals(exp_label))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("failed");
		}
	
		List<WebElement> MenuItems = driver.findElements(By.className("oxd-main-menu-item-wrapper"));
		System.out.println(MenuItems.size());
		
		List<WebElement> TotalImages = driver.findElements(By.tagName("img"));
		System.out.println(TotalImages.size());
		

		List<WebElement> TotalLinks = driver.findElements(By.tagName("a"));
		System.out.println(TotalLinks.size());
		//driver.quit();

	}
}


	
			

