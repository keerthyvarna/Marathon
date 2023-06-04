package marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get(" https://dev120081.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("$AWWF0/a2afr");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		Thread.sleep(6000);
		Shadow sh = new Shadow(driver);
		sh.setImplicitWait(10);
		//Thread.sleep(3000);
		sh.findElementByXPath("//div[text()='All']").click();
		sh.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog",Keys.ENTER);
		sh.findElementByXPath("//mark[@class='filter-match']").click();
		WebElement frame = sh.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
		WebElement mb = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select dd1 = new Select(mb);
		dd1.selectByIndex(2);
		driver.findElement(By.xpath("(//label[@class='radio-label'])[4]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[9]")).click();
		driver.findElement(By.xpath("//button[@name='oi_order_now_button']")).click();
		WebElement text = driver.findElement(By.xpath("//span[@aria-live='assertive']"));
		System.out.println(text.getText());
		WebElement ref = driver.findElement(By.xpath("//a[@id='requesturl']"));
		System.out.println("Request Number: "+ ref.getText());
		driver.quit();
		
		
		

	}

}
