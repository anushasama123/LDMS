package com.application.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.application.pages.HomePage;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass{
	HomePage homePage;
	
	/*
	 * @BeforeClass public void getHomePage(){ homePage= HomePage.getHomePage(); }
	 */
	
	@BeforeMethod
	public void openBrowser() {
		WebDriverClass.launchBrowser();	
	}
	
	@AfterMethod
	public void exitBrowser() {
		WebDriverClass.closeBrowser();
	}

	//Verify page title
	@Test
	public void verifyApplicationTitle() throws IOException {
		
		assertEquals(WebDriverClass.getDriver().getTitle(),"Loan Amortiser"); 
		
		}
	
	//Verify all mandatory text fields are displayed in the page
	
	@Test
	public void verifyWebElements() throws InterruptedException {
		homePage= HomePage.getHomePage();
		
		 assertTrue(homePage.loanAmount.isDisplayed()); 
		 assertTrue(homePage.loanTerm.isDisplayed());
		 assertTrue(homePage.interestRate.isDisplayed());
		 assertTrue(homePage.submitButton.isDisplayed());
		 	
		}
	
	//Verify all required table fields are displayed after submit the form
	
	@Test
	public void calculateLoanAmount(){
		homePage= HomePage.getHomePage();
		homePage.submitButton.click();
		WebDriverClass.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		 assertTrue(homePage.monthlyRepaymentAmount.isDisplayed());
		 assertTrue(homePage.totalInterestRepayable.isDisplayed());
		 assertTrue(homePage.totalAmountRepayable.isDisplayed());
		 
		}
	
	//Verify the error message when clear the mandatory text fields. Though values are not getting cleared error messages are getting populated. Values are getting clear with keys.backspace method
	@Test
	public void validateInputFields(){
		homePage= HomePage.getHomePage();
		homePage.loanAmount.clear();
		homePage.loanTerm.clear();
		homePage.interestRate.clear();
		assertEquals(homePage.loanAmountErrorMessage.getText(), "The amount of the loan must be provided");
		assertEquals(homePage.loanTermErrorMessage.getText(), "The term of the loan must be provided");
		assertEquals(homePage.interestRateErrorMessage.getText(), "The interest rate of the loan must be provided");
		
		
	}
	
	
	//Text fields are not getting clear but data not getting clear from text fields with clear method. Could not able to enter values
	// Verify loan term is equal to no. of records in the table
	@Test
	public void verifyTableRowsEqualToLoanTerm(){
		String loanTerm="1";
		homePage= HomePage.getHomePage();		
		homePage.loanAmount.sendKeys("40000");
		homePage.loanTerm.sendKeys(loanTerm);;
		homePage.interestRate.sendKeys("9");
		homePage.submitButton.click();
		WebDriverClass.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertNotNull(WebDriverClass.getDriver().findElement(By.xpath("//td[text()='12"+loanTerm+"']")));
		
		
	}	
	
}