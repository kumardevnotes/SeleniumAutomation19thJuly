package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver = null;

	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeOptions);

		// To maximize browser, use below code
		driver.manage().window().maximize();
		System.out.println("browser opened and app is launched befre running TC");
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void getTitle() {
		driver.getTitle();
	}

	public void clickElement(By by) {
		driver.findElement(by).click();
	}

	public void enterText(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}
	
	public boolean isDisplayed(By by) {
		return driver.findElement(by).isDisplayed();
	}

}
