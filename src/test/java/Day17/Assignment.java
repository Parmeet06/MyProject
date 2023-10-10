package Day17;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		/* Steps for Test case
		1. Launch Chrome Browser
		2. Open the URL
		3. Enter username
		4.Enter password
		5.Click Login Button
		6. verify if correct homepage is launched
*/
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2");
		
		
		driver.manage().window().maximize(); // maximize the page
		Thread.sleep(5000);
				
		driver.findElement(By.id("Email")).clear();
	
		driver.findElement(By.id("Password")).clear();
		Thread.sleep(5000);
		
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.id("Password")).sendKeys("admin1");
		
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		Thread.sleep(5000);
		String exp_label = "Dashboard";
		String Act_label=null;
		Thread.sleep(5000);
		
		try{
			
			Act_label=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
			  
		
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
	
		
		
		
		
	}

}
