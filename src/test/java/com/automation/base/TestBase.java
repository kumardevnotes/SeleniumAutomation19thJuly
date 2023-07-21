package com.automation.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver = null;
	Properties props = null;
	
	public TestBase() throws IOException{
		initiateBrowser();
	
		String rootPath =  System.getProperty("user.dir");
		System.out.println(rootPath);
		FileReader myFile = new FileReader(rootPath + "//src//test//resources//appData.properties");
		props = new Properties();
		
		props.load(myFile);
		System.out.println(props.getProperty("appBrowser"));
		System.out.println(props.getProperty("appUrl"));
		System.out.println(props.getProperty("appUserEmailID"));
		System.out.println(props.getProperty("apppassword"));
	}

	public void initiateBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeOptions);

		// To maximize browser, use below code
		driver.manage().window().maximize();
		System.out.println("browser opened and app is launched befre running TC");
	}
	

	public void launchApp() {
		driver.get(props.getProperty("appUrl"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickElement(By by) {
		driver.findElement(by).click();
	}

	public void enterText(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}
	
	public WebElement getWebElement(By by) {
		return driver.findElement(by);
	}
	
	public String getText(By by) {
		return driver.findElement(by).getText().trim();
	}
	
	public boolean isDisplayed(By by) {
		return driver.findElement(by).isDisplayed();
	}
	
	public void cleanUpBrowser() {
		driver.quit();
	}
	
	public void captureScreenshot(String screenShotName) throws IOException {
		String rootPath  =  System.getProperty("user.dir");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(rootPath+"//Screenshots/Screnshot_"+screenShotName+".png");
		FileHandler.copy(src, dest);
	}

}
