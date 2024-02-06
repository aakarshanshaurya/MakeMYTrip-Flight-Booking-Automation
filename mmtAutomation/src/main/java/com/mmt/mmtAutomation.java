package com.mmt;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mmtAutomation {
	
	//Global Variables
	
	// className objectName = new className();
	ChromeDriver driver = new ChromeDriver();
	
	WebElement button;
	
	
	@Test
	public void openBrowser() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\frameworks\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		//opens the link in the browser
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		// let the code wait(puts in sleep)
		Thread.sleep(1000);
		
		//round trip selection
		button = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[1]/ul/li[2]"));
		button.click();
		
		//takes screenshot
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File("C:\\Users\\KIIT\\Pictures\\automation\\MakeMyTrip Automation\\mmtscreenshot.jpg"));

	}
	
	
	@Test(dependsOnMethods = "openBrowser")
	public void locationFrom() throws InterruptedException, IOException {
		
		//Clicks the Bengaluru for from
		WebElement fromLocation = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/label/input"));
		fromLocation.click();
				
		//enters the strings(from location)
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("BLR");
			
		//clicks on Bengaluru from the drop down menu
		Thread.sleep(2000);
		fromLocation = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div/ul/li[1]/div/div[1]/p[1]"));
		fromLocation.click();
					
		//takes screenshot (after clicking BLR)
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File("C:\\Users\\KIIT\\Pictures\\automation\\MakeMyTrip Automation\\mmtscreenshot2.png"));
		
	}
	
	
	@Test(dependsOnMethods = "locationFrom")
	public void locationTo () throws InterruptedException, IOException {
		
		//Selecting Bhubaneswar for to
		WebElement toLocation = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/input"));
		toLocation.click();
				
		//Enters the strings(to location)
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/input")).sendKeys("BBI");
							
		//clicks on Bhubaneswar form the drop down menu
		Thread.sleep(2000);
		toLocation = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/ul/li[1]/div/div[1]/p[1]"));
		toLocation.click();
		
		//takes screenshot
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File("C:\\Users\\KIIT\\Pictures\\automation\\MakeMyTrip Automation\\mmtscreenshot3.png"));

	}

	
	@Test(dependsOnMethods = "locationTo")
	public void dates() throws IOException, InterruptedException {
		
		WebElement select;
		
		//departure date arrow
		for(int i = 0; i < 2; i++) {
			select = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
			select.click();
		}

		//departure date selection from calendar
		select = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[4]/div[2]/div/p[1]"));
		select.click();
								
		//return date arrow
		for(int i = 0; i < 1; i++) {
			select = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
			select.click();
		}
				
		//return date selection from calendar
		select = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[5]/div[2]/div/p"));
		select.click();
		
		//takes screenshot
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File("C:\\Users\\KIIT\\Pictures\\automation\\MakeMyTrip Automation\\mmtscreenshot4.png"));
	
	}	

	
	@Test(dependsOnMethods = "dates")
	public void passanger() throws InterruptedException, IOException {
		
		//clicks in passenger
		Thread.sleep(2000);
		WebElement select = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[5]/label/span"));
		select.click();
						
		//choosing amount of passengers
		select = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[5]/div[2]/div[1]/ul[1]/li[2]"));
		select.click();
				
		//clicking on apply
		select = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[5]/div[2]/div[2]/button"));
		select.click();
		
		//takes screenshot
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File("C:\\Users\\KIIT\\Pictures\\automation\\MakeMyTrip Automation\\mmtscreenshot5.png"));
	}
	
	
	@Test(dependsOnMethods = "passanger")
	public void search() throws IOException, InterruptedException {
		
		//selecting fare type
		Thread.sleep(500);
		button = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/ul/li[3]/p"));
		button.click();		
				
		//clicking search button
		button = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/p/a"));
		button.click();
		
		//takes screenshot
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File("C:\\Users\\KIIT\\Pictures\\automation\\MakeMyTrip Automation\\mmtscreenshot6.png"));
	}
}
