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

public class ArchitectCertifications {

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
			driver.findElement(By.xpath("//div[text()='Architect']")).click();
			String text = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text')]")).getText();
			System.out.println("summary of Salesforce Architect: "+text);
			List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
			System.out.println("certifications for salesforce architect: ");
			 for(int i=0;i<list1.size();i++) {
				   String text1 = list1.get(i).getText();
				  System.out.println(text1);
	}
			 Thread.sleep(3000);
			 driver.findElement(By.linkText("Application Architect")).click();
			 List<WebElement> list2 = driver.findElements(By.xpath("//div/div[@class='credentials-card_title']"));
			 System.out.println("certifications for application architect: ");
			 for(int i=0;i<list2.size();i++) {
				   String text2 = list2.get(i).getText();
				  System.out.println(text2);
				  driver.quit();
			 

}
	}
}
