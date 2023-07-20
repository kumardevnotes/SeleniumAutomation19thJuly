package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.TestBase;

public class LandingPage {

	TestBase testBase = null;
	
	By appLogo = By.id("logo");
	By searchField = By.id("search_input");
	By searchButton = By.id("search_submit");
	By loginLink = By.id("nav_login");
	By signUpLink = By.id("nav_signup");
	By copyRightLabel = By.xpath("//p[contains(text(),'Speak Languages')]");
	By privacyPolicyLink = By.linkText("Privacy policy");
	By termsOfUse = By.linkText("Terms of use");
	By contactUsLink = By.linkText("Contact us");
	

	public LandingPage(TestBase testBase) {
		this.testBase = testBase;
	}

	public String getPageTitle() {
		return testBase.getTitle();
	}

	public boolean isHeaderDisplayed() {
    
		return testBase.isDisplayed(appLogo) &&
				testBase.isDisplayed(searchField) &&
				testBase.isDisplayed(searchButton) &&
				testBase.isDisplayed(loginLink) &&
				testBase.isDisplayed(signUpLink); // true && true && true && true && true --> true
		
	}

	public boolean isFooterDisplayed() {
		
		JavascriptExecutor js = (JavascriptExecutor) testBase.getDriver();
		js.executeScript("arguments[0].scrollIntoView();", testBase.getWebElement(privacyPolicyLink));
		
		return testBase.isDisplayed(copyRightLabel) &&
				testBase.isDisplayed(privacyPolicyLink) &&
				testBase.isDisplayed(termsOfUse) &&
				testBase.isDisplayed(contactUsLink) ;
	}
	
	public void launchLogIn() {
        testBase.clickElement(loginLink);
	}

	public void launchSignup() {
        testBase.clickElement(signUpLink);
	}

}
