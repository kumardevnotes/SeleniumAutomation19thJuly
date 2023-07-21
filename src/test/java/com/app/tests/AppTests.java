package com.app.tests;

import org.testng.annotations.Test;

import com.app.pages.LandingPage;
import com.app.pages.SignupPage;
import com.automation.base.TestBase;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AppTests {

	TestBase testBase = null;
	LandingPage landingPage = null;
	SignupPage signUpPage = null;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		testBase = new TestBase();
		landingPage = new LandingPage(testBase);
		signUpPage = new SignupPage(testBase);
	}

	@Test
	public void verifyLandingPage() throws IOException {
      testBase.launchApp();
      String pageTitleExpected  = "Speak Languages — Learn a new language online";
      String pageTitleActual  = landingPage.getPageTitle();
      boolean isHeaderDisplayed  = landingPage.isHeaderDisplayed();
      boolean isFooterDisplayed  = landingPage.isFooterDisplayed();
      System.out.println(pageTitleActual);
      System.out.println(isHeaderDisplayed);
      System.out.println(isFooterDisplayed);
      
      isFooterDisplayed =  false;
     
      if(pageTitleActual.equals(pageTitleExpected) && isHeaderDisplayed == true && isFooterDisplayed == true) {
    	  System.out.println("Landing page is loaded without issues");
      }
      else {
    	  testBase.captureScreenshot("LandingPage_Failed");
    	  Assert.fail("Something went wrong. Landing page is not loaded properly");
      }
      
	}

	@Test (invocationCount = 1)
	public void verifySignup() throws InterruptedException, IOException {
		 testBase.launchApp();
		 landingPage.launchSignup();
		 signUpPage.fillTheSignupForm();
		 signUpPage.clickSignup();
		 String successMessageExpected  = "Thank you — now activate your account!";
		 successMessageExpected ="";
		 String successMessageActual  = signUpPage.getSignupSuccessMessage();
		 System.out.println(successMessageActual);
		  if(successMessageActual.equals(successMessageExpected)) {
	    	  System.out.println("Signup is success");
	      }
	      else {
	    	  testBase.captureScreenshot("Signup_Failed");
	    	  Assert.fail("Something went wrong. Signup is not succesful");
	      }
	}

	@AfterMethod
	public void afterMethod() {
		testBase.cleanUpBrowser();
	}

}
