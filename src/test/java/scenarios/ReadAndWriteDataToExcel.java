package scenarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadAndWriteDataToExcel {
	
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
		driver.get("https://www.amazon.in/");
		
//		5. Identify the search textfield and provide actions on that
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphones");
		Thread.sleep(2000);
		 List<WebElement> allEle = driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		 for(WebElement ele: allEle)
		 {
			 System.out.println(ele.getText());
		 }
		 
		 FileInputStream fis = new FileInputStream("./testData/phones.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.createSheet("AllPhones");
		 
		 int rowCount=0;
		 for(WebElement allPhones: allEle)
		 {
			 Row row = sh.createRow(rowCount++);
			 row.createCell(0).setCellValue(allPhones.getText());
		 }
		 
		  FileOutputStream fos= new FileOutputStream("./testData/phones.xlsx");
		  wb.write(fos);
		  wb.close();
		 
		 
		 driver.close();
	}

}
