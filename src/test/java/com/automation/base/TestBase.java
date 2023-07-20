package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver = null;
	
	public TestBase(){
		initiateBrowser();
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
		driver.get("https://speakLanguages.com");
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

}
