package marathon3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//setTimeout(function(){debugger;}, 5000)

public class TestCase002 extends ProjectSpecificMethod {
	@BeforeTest
	public void setfile() {
		filename="Test002";
	}
	
@Test(dataProvider="fetchData")
	public  void testCase002(String amnt,String name ) throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	Thread.sleep(3000);
	WebElement keys = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
	Actions act = new Actions(driver);
	act.moveToElement(keys).perform();
	//keys.click();
	act.pause(2000).perform();
	  driver.executeScript("arguments[0].click();",keys);
	  Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amnt);
	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
	driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='5']")).click();
	driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[2]")).click();
	driver.findElement(By.xpath("//span[text()='New Customer']")).click();
	driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input')]")).click();
	driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	//driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]")).click();
	//driver.findElement(By.xpath("//span[text()='REST API']")).click();
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	driver.findElement(By.xpath("//button[@title='Close']")).click();
	Thread.sleep(3000);
   driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
   driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys(name,Keys.ENTER);
	  
	Thread.sleep(3000);
	List<WebElement> list = driver.findElements(By.xpath("//span[@class='slds-grid slds-grid--align-spread']/a"));
	Thread.sleep(3000);
	/*
	 * boolean found=false; for (WebElement webElement : list) {
	 * if(webElement.getText().contains(name)) { found=true; break; }
	 * 
	 * } if(found) { System.out.println("New oppurtunity is created successfully");
	 * }else { System.out.println("New oppurtunity is not created");
	 * 
	 * }
	 */
	for (WebElement webElement : list) {
		
	
	if(webElement.getText().contains(name)) {
		System.out.println("New oppurtunity is created successfully");
	}else {
		System.out.println("New oppurtunity is not created");
		break;
	}
	
	}

}
}
