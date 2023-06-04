package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import w6d2serviceNowAssignments.ReadExcel;

public class ProjectSpecificMethod {
	public ChromeDriver driver;
	public String filename;
@BeforeMethod()
public void preCondition() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	    driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("keerthyvarna06@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Tester@0608");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}

	
	
	/*
	 * @AfterMethod() public void postCondition() { driver.close(); }
	 */
	 
	 

@DataProvider(name="fetchData")
public String[][] sendData() throws IOException  {		
	return ReadExcel.readExcel(filename);	
}
}
