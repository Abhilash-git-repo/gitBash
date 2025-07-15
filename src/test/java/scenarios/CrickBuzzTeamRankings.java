package scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CrickBuzzTeamRankings {
	
	@Test
	public void getTeamNames() throws Exception
	{
//		1. Launch the browser
		WebDriver driver= new ChromeDriver();
//		2. Maximize the window
		driver.manage().window().maximize();
//		3. Provide waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
//		4. Load the url
		driver.get("https://www.cricbuzz.com/");
		
//		5.click on Rankings link
		driver.findElement(By.linkText("Rankings")).click();
		
//		6. click on Team link and get all the names whose positions which are greater than 3
		driver.findElement(By.id("teams-tab")).click();
		Thread.sleep(2000);
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='cb-col cb-col-50 cb-lst-itm-sm text-left']"));
		int count =ele.size();
		//System.out.println(count);
		
		for(int i=0; i<count;i++)
		{
			if(i>=2)
			{
				System.out.println(ele.get(i).getText());
			}
		}
		
		driver.close();
	}

}
