package marathon3;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase001 extends ProjectSpecificMethod {
	@BeforeTest
	public void setfile() {
		filename="Test001";
	}

	@Test(dataProvider="fetchData")
	public  void testCase001(String ques, String det) throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		Thread.sleep(3000);
        WebElement View = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));
        driver.executeScript("arguments[0].click();", View);
        String title = driver.getTitle();
        System.out.println("Title: "+title);
        driver.findElement(By.xpath("//span[text()='Question']")).click();
        driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(ques);
        String text1 = driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).getAttribute("value");
        driver.findElement(By.xpath("//div[contains(@class,'ql-editor')]")).sendKeys(det);
        driver.findElement(By.xpath("//button[text()='Ask']")).click();
        String text2 = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
        Thread.sleep(3000);
        if(text1.contains(text2)) {
        	System.out.println("question appears");
        }else {
        	System.out.println("question doesnt appear");
        }
	}
	

}
