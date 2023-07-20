package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.TestBase;

public class SignupPage {

	WebDriver driver = null;
	TestBase testBase = null;

	By firstNameField = By.id("first_name");
	By lastNameField = By.name("last_name");
	By emailField = By.name("email");
	By passwordField = By.name("password");

	By genderLocator = By.name("sex");
	By dayLocator = By.name("dob_day");
	By monthLocator = By.name("dob_month");
	By yearLocator = By.name("dob_year");

	By signUpButton = By.xpath("//input[@value='Sign up']");
	By thankYouMessage = By.xpath("//h1[contains(text(),'Thank you')]");

	public SignupPage(TestBase testBase) {
		this.testBase = testBase;
	}

	public void fillTheSignupForm() {
		testBase.enterText(firstNameField, "JohnKumar");
		testBase.enterText(lastNameField, "LegendSam");
		testBase.enterText(emailField, "johnlegenSam441990@gmail.com");
		testBase.enterText(passwordField, "Meaning1122");

		WebElement genderWebElement = testBase.getWebElement(genderLocator);
		Select genderDD = new Select(genderWebElement);
		genderDD.selectByVisibleText("Female");

		WebElement dayWebElement = testBase.getWebElement(dayLocator);
		Select dayDD = new Select(dayWebElement);
		dayDD.selectByVisibleText("10");

		WebElement monthWebElement = testBase.getWebElement(monthLocator);
		Select monthDD = new Select(monthWebElement);
		monthDD.selectByVisibleText("April");

		WebElement yearWebElement = testBase.getWebElement(yearLocator);
		Select yearDD = new Select(yearWebElement);
		yearDD.selectByVisibleText("1996");

	}

	public void clickSignup() throws InterruptedException {
		testBase.clickElement(signUpButton);
		Thread.sleep(8000);
	}

	public String getSignupSuccessMessage() {
		return testBase.getText(thankYouMessage);
	}

}
