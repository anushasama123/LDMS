package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.framework.webdriver.WebDriverClass;

public class HomePage {


	@FindBy(xpath="//input[@name='loanAmount']")
	public WebElement loanAmount;
	
	@FindBy(xpath="//input[@name='loanTerm']")
	public WebElement loanTerm;
	
	@FindBy(xpath="//input[@name='interestRate']")
	public WebElement interestRate;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath="//th[text()='Monthly Repayment Amount']")
	public WebElement monthlyRepaymentAmount;
	
	@FindBy(xpath="//th[text()='Total Interest Repayable']")
	public WebElement totalInterestRepayable;
	
	@FindBy(xpath="//th[text()='Total Amount Repayable']")
	public WebElement totalAmountRepayable;
	
	
	@FindBy(xpath="//div[text()='The amount of the loan must be provided']")
	public WebElement loanAmountErrorMessage;
	
	@FindBy(xpath="//div[text()='The term of the loan must be provided']")
	public WebElement loanTermErrorMessage;
	
	@FindBy(xpath="//div[text()='The interest rate of the loan must be provided']")
	public WebElement interestRateErrorMessage;
	
	@FindBy(xpath="//table[@aria-label='Loan Schedule']")
	public WebElement table;
	
	public static HomePage getHomePage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), HomePage.class);
	}
}
