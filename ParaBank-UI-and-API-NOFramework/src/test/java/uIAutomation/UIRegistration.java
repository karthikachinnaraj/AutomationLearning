package uIAutomation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.asn1.cmp.ErrorMsgContent;
import org.openqa.selenium.*;	
import io.github.bonigarcia.wdm.WebDriverManager;


public class UIRegistration {
	public void RegisterSuccess() throws IOException {
		// setting browser by webDriverManager -- need to add dependency
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		
		// telling the window to maximize
		options.addArguments("--start-maximized");
		ChromeDriver driver=new ChromeDriver(options);
		
		//Using navigate .to
		driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
		driver.findElement(By.linkText("Register")).click();
		
		//Enter all form details using id and sendkeys
		driver.findElement(By.id("customer.firstName")).sendKeys("karthika");
		driver.findElement(By.id("customer.lastName")).sendKeys("Chinnaraj");
		driver.findElement(By.id("customer.address.street")).sendKeys("Madavaram");
		driver.findElement(By.id("customer.address.city")).sendKeys("chennai");
		driver.findElement(By.id("customer.address.state")).sendKeys("tamilnadu");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("600051");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("8989878787");
		driver.findElement(By.id("customer.ssn")).sendKeys("kdsbbsd");
		//change username and password for every successful run
		driver.findElement(By.id("customer.username")).sendKeys("Alert12");
		driver.findElement(By.id("customer.password")).sendKeys("Alert12");
		driver.findElement(By.id("repeatedPassword")).sendKeys("Alert12");
		driver.findElement(By.cssSelector("input[value=\"Register\"]")).click();
		
		
		String success=driver.findElement(By.xpath("//div[@id=\"bodyPanel\"]/div[2]")).getText();
		
		if(!success.isEmpty()) {
			System.out.println(success);
		}
		else {
			System.out.println("Error with registration");
		}
		//Taking Screenshot of whole webpage
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File Desc=screenshot.getScreenshotAs(OutputType.FILE);
		//Saving file using calendar java class
		Calendar DateTime=Calendar.getInstance();
		SimpleDateFormat sfd=new SimpleDateFormat("yyyyMMDD_HHmmss");
		String snapshot="ParaBankSuccessSnap"+sfd.format(DateTime.getTime()) +".PNG";
		
		//Saving file using system.current time
		//String snapshot="ParaBank-UI-and-API-NOFramework-Snap"+System.currentTimeMillis() +".PNG";
		File file=new File("D:\\Programming\\Automation Learning\\ScreenShot\\ParaBank-UI-and-API-NOFramework-Snap\\"+snapshot);
		FileUtils.copyFile(Desc,file);
		System.out.println("Screenshot saved at: " + file.getAbsolutePath());
	
		
		//Closing the driver
		driver.close();
		
	}
	
	public void RegisterError() throws IOException {
		// setting browser by webDriverManager -- need to add dependency
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		
		// telling the window to maximize
		options.addArguments("--start-maximized");
		ChromeDriver driver=new ChromeDriver(options);
		
		//Using navigate .to
		driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
		driver.findElement(By.linkText("Register")).click();
		
		//Enter all form details using id and sendkeys
		driver.findElement(By.id("customer.firstName")).sendKeys("karthika");
		driver.findElement(By.id("customer.lastName")).sendKeys("Chinnaraj");
		driver.findElement(By.id("customer.address.street")).sendKeys("Madavaram");
		driver.findElement(By.id("customer.address.city")).sendKeys("chennai");
		driver.findElement(By.id("customer.address.state")).sendKeys("tamilnadu");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("600051");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("8989878787");
		driver.findElement(By.id("customer.ssn")).sendKeys("kdsbbsd");
		//change username and password for every successful run
		driver.findElement(By.id("customer.username")).sendKeys("Alert12");
		driver.findElement(By.id("customer.password")).sendKeys("Alert12");
		driver.findElement(By.id("repeatedPassword")).sendKeys("Alert12");
		driver.findElement(By.cssSelector("input[value=\"Register\"]")).click();
		
		
		
		List<WebElement>Message=driver.findElements(By.xpath("//table/tbody/tr/td/span"));
		for(WebElement errorMsg:Message) {
			if(!errorMsg.getText().isEmpty()) {
				System.out.println("---- Validation Errors ----");
				System.err.println(errorMsg.getText());
				}
		//Taking Screenshot of whole webpage
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File Desc=screenshot.getScreenshotAs(OutputType.FILE);
		//Saving file using calendar java class
		Calendar DateTime=Calendar.getInstance();
		SimpleDateFormat sfd=new SimpleDateFormat("yyyyMMDD_HHmmss");
		String snapshot="ParaBankErrorSnap"+sfd.format(DateTime.getTime()) +".PNG";
		
		//Saving file using system.current time
		//String snapshot="ParaBank-UI-and-API-NOFramework-Snap"+System.currentTimeMillis() +".PNG";
		File file=new File("D:\\Programming\\Automation Learning\\ScreenShot\\ParaBank-UI-and-API-NOFramework-Snap\\"+snapshot);
		FileUtils.copyFile(Desc,file);
		System.out.println("Screenshot saved at: " + file.getAbsolutePath());
	
		
		//Closing the driver
		driver.close();
		}
		
	}
	

	
		
	public static void main(String[] args) throws IOException {
		UIRegistration register=new UIRegistration();
		//register.RegisterSuccess();
		register.RegisterError();
	}
}
