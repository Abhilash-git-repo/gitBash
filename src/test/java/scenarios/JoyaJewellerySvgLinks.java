package scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JoyaJewellerySvgLinks {
	
	@Test
	public void sampleTest() 
	{
//		1. Launch the Browser
		WebDriver driver= new ChromeDriver();
		
//		2. Maximize the window
		driver.manage().window().maximize();
		
//		3. Provide wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		4. Load the Url
		driver.get("https://www.joyalukkas.in/");
		
//		5. identify the element 
		//List<WebElement> links = driver.findElements(By.xpath("//ul[@class='social_links']/child::li"));
	
		//String link = facebook.getAttribute("href");
		//System.out.println(link);
		
		driver.close();
		
	}

}
