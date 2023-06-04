package marathon1;
/*01) Launch Edge / Chrome  add  implicitlyWait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
02) Load https://in.bookmyshow.com/
03) Type the city as"Hyderabad"in Select City
04) Confirm the URL has got loaded with Hyderabad 
05) Search for your favorite movie 
06) Click on movie
07) Print the name of the theater displayed first
08) Click on the info of the theater
09) Confirm if there is a parking facility in the theater
10) Close the theater popup
11) Click on the first green (available) timing
12) Click Accept
13) Choose 1 Seat and Click Select Seats
14) Choose any available ticket and Click Pay
15) Print the sub total*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("  https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("hyderabad");
		driver.findElement(By.xpath("//li[@class='sc-gJqsIT jMjMYb']")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).click();
		driver.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("dasara");
		driver.findElement(By.xpath("(//div[@class='sc-dXfzlN iPwaRU'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
		driver.findElement(By.xpath("//div[@class='sc-vhz3gb-3 dRokFO']")).click();
		WebElement name = driver.findElement(By.xpath("//a[text()='Aarti Theater: Sanginagar']"));
		System.out.println(name.getText());
		driver.findElement(By.xpath("(//div[@class='venue-info-text'])[1]")).click();
		WebElement parking = driver.findElement(By.xpath("//div[text()='            Parking Facility        ']"));
		System.out.println(parking.getText());
		driver.findElement(By.xpath("//div[@class='cross-container']")).click();
		driver.findElement(By.xpath("(//div[@class='__details'])[1]")).click();
		driver.findElement(By.xpath("//li[@id='pop_1']")).click();
		driver.findElement(By.xpath("(//div[@class='btn-bar'])[2]")).click();
		driver.findElement(By.xpath("//a[@class='_available']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='btmcntbook']")).click();
        Thread.sleep(3000);
		WebElement total = driver.findElement(By.xpath("//span[@class='__sub-total']"));
		System.out.println(total.getText());
		driver.close();
		
		
		
		
		
		

	}

}
