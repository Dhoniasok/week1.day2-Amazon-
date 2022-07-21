package practicetest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver ();
		 // Load Amazon 
		 driver.get("https://www.amazon.in/");
		// to maximize
		 driver.manage().window().maximize();    
		// Add implicit wait
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 // Type "Bags" in the Search box
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		 // Choose the third displayed item in the result (bags for boys)
		driver.findElement(By.xpath("//div[@aria-label='bags for boys']")).click();
		// Print the total number of results (like 30000)
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')]")).getText());
		// Select the first 2 brands in the left menu
		driver.findElement(By.xpath("(//span[text()='American Tourister'])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Generic']")).click();
		// Confirm the results have got reduced
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')]")).getText());
		// Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		// Print the first resulting bag info (name, discounted price)
		System.out.println(driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus a-color-base')])[2]")).getText());
		System.out.println(driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]")).getText());
		// Confirm the color of the 'Deal of the day' is in kind of Red
		driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_3']")).click();
		System.out.println(driver.findElement(By.xpath("(//img[@class='GridPresets-module__gridPresetImage_1FnIo-Do5TDxU-XJMp1M77'])[2]")).getCssValue("color"));
        // Click on the First Deal of the day
		driver.findElement(By.xpath("//span[text()='Deals of the Day']")).click();
		driver.findElement(By.xpath("(//div[@class='a-row a-spacing-small'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='a-section octopus-dlp-image-shield'])[1]")).click();
		System.out.println(driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText());
	    System.out.println("The price of previous and current price is  "  +(driver.findElement(By.xpath("(//span[@aria-hidden='true'])[4]"))).getText());
	    
	    // Take a Screenshot of the page and close
	    File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	    File target = new File("./report/img.png");	//set the storage path
	    FileUtils.copyFile(screenshotAs, target);//link the source and target files
	    driver.close();
	}

}
