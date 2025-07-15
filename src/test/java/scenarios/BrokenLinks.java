package scenarios;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {
	
	@Test
	public void sampleTest() throws Throwable
	{
//		1. Launch the Browser
		WebDriver driver= new ChromeDriver();
		
//		2. Maximize the window
		driver.manage().window().maximize();
		
//		3. Provide wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		4. Load the Url
		driver.get("https://www.amazon.in/");
		
//		5. get all broken links
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count = allLinks.size();
		System.out.println(count);
		
		for(WebElement ele: allLinks)
		{
			String value = ele.getAttribute("href");
			if(value==null || value.isEmpty())
			{
				System.out.println("We cannot check");
				continue;
			}
			
			URL url= new URL(value);
			HttpURLConnection con= (HttpURLConnection) url.openConnection();
			con.connect();
			if(con.getResponseCode()>=400)
			{
				System.out.println(value+"-->" +con.getResponseCode() +"-->" + "It is a broken link");
			}
			else
			{
				System.out.println(value+"-->" +con.getResponseCode() +"-->" + "It is not a broken link");
			}
			
		}
		
		driver.quit();
		
		
		
	}

}
