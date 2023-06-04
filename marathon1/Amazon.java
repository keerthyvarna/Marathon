package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*01) Launch Chrome  
02) Load https://www.amazon.in/
       add  implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
03) Type "Bags" in the Search box
04) Choose the 	 item in the result (bags for boys)
05) Print the total number of results (like 40000)
    1-48 of over 40,000 results for "bags for boys"
06) Select the first 2 brands in the left menu
    (like American Tourister, Generic)
07) Choose New Arrivals (Sort)
08) Print the first resulting bag info (name, discounted price)
09) Get the page title and close the browser(driver.close())*/
public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bags");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='s-suggestion s-suggestion-ellipsis-direction'])[7]")).click();
		WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
     //   Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[3]")).click();
        driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[4]")).click();
       Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
        WebElement name = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        System.out.println("Name: "+name.getText());
        WebElement discount = driver.findElement(By.xpath("//div[@class='a-row a-size-base a-color-base']"));
        System.out.println("price: "+ discount.getText());
        System.out.println(driver.getTitle());
        driver.close();
	}

}
