package com.app.tests;

import org.testng.annotations.Test;

import com.app.pages.LandingPage;
import com.app.pages.SignupPage;
import com.automation.base.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AppTests {

	TestBase testBase = null;
	LandingPage landingPage = null;
	SignupPage signUpPage = null;

	@BeforeMethod
	public void beforeMethod() {
		testBase = new TestBase();
		landingPage = new LandingPage(testBase);
		signUpPage = new SignupPage(testBase);
	}

	@Test
	public void verifyLandingPage() {
      testBase.launchApp();
      String pageTitle  = landingPage.getPageTitle();
      boolean isHeaderDisplayed  = landingPage.isHeaderDisplayed();
      boolean isFooterDisplayed  = landingPage.isFooterDisplayed();
      System.out.println(pageTitle);
      System.out.println(isHeaderDisplayed);
      System.out.println(isFooterDisplayed);
      //Validation is pending
	}

	@Test
	public void verifySignup() throws InterruptedException {
		 testBase.launchApp();
		 landingPage.launchSignup();
		 signUpPage.fillTheSignupForm();
		 signUpPage.clickSignup();
		 String successMessage  = signUpPage.getSignupSuccessMessage();
		 System.out.println(successMessage);
		 //Validation is pending
	}

	@AfterMethod
	public void afterMethod() {
		testBase.cleanUpBrowser();
	}

}
