package scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RedBusFetchingBusPriceAndDepTime {
	
	@Test
	public void sampleTest() throws Throwable
	{
//		1. Launch the Browser
		WebDriver driver= new ChromeDriver();
		
//		2. Maximize the window
		driver.manage().window().maximize();
		
//		3. Provide wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		4. Load the Url
		driver.get("https://www.redbus.in/");
		
//		5. Identify From element and provide source location
		WebElement from = driver.findElement(By.xpath("//div[.='From' and @class='label___cef6ea ']"));
		
		Actions act= new Actions(driver);
		act.click().sendKeys(from, "Hyderabad").perform();
		driver.findElement(By.xpath("//div[contains(text(),'Miyapur, Hyderabad')]")).click();
		
		
		driver.quit();
	}

}
