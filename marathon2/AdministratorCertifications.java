
package marathon2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

/*Testcase-1: Administrator Certifications
==============================
1. Launch Salesforce application https://login.salesforce.com/
2. Login with username as "hari.radhakrishnan@qeagle.com" 
    and password as "Leaf@123"
3. Click on Learn More link in Mobile Publisher
4. Click confirm on Confirm redirect
5. Click Learning 
6. And mouse hover on Learning On Trailhead
7. Clilck on Salesforce Certifications
8. Click on first resulting Ceritificate
9. verify - Administrator Overview page
10.Print the Certifications available for Administrator Certifications (List)
11. Close Browser*/


public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		//Shadow shadow = new Shadow(driver);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		 Set<String> windowHandles = driver.getWindowHandles();
			List<String> whs = new ArrayList<String>(windowHandles);
			driver.switchTo().window(whs.get(1));
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			Shadow shadow = new Shadow(driver);
			shadow.findElementByXPath("//span[text()='Learning']").click();
			WebElement a = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
			Actions action= new Actions(driver);
			action.moveToElement(a).perform();
			WebElement b = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
			action.moveToElement(b).click(b).perform();
		driver.findElement(By.xpath("//div/a[text()='Administrator']")).click();
		String title = driver.getTitle();
		System.out.println(title);
	//	System.out.println("certifications: ");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='trailMix-card-body_title']"));
		System.out.println("certificates for administrator: ");
		 for(int i=0;i<list.size();i++) {
		   String text2 = list.get(i).getText();
		  System.out.println(text2 );
		 }
		 driver.quit();
			  
			 
		  
		
		
		

	}

}
