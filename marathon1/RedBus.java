package marathon1;
/*Testcase:1

==========
01) Launch Firefox / Chrome and add  implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
02) Load https://www.redbus.in/
03) Type "Chennai" in the FROM text box
04) Click the first option from the pop up box
05) Type "Bangalore" in the TO text box
06) Click the first option from the pop up box
07) Select tomorrow's date in the Date field
08) Click Search Buses
09) Print the number of buses shown as results (104 Buses found) (use .getText())
10) Choose SLEEPER in the left menu 
11) Print the name of the second resulting bus (use .getText())
12) Get the Title of the page(use .getTitle())*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get(" https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("chennai");
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		driver.findElement(By.xpath("//label[text()='Date']")).click();
		driver.findElement(By.xpath("//td[text()='6']")).click();
		driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		WebElement buses = driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']"));
		//System.out.println( driver.findElement(By.xpath("//span[@class='w-60 d-block d-found']")));
		System.out.println(buses.getText());
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		WebElement Name = driver.findElement(By.xpath("//div[text()='KMRL Kalaimakal']"));
		System.out.println(Name.getText());
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}

}
