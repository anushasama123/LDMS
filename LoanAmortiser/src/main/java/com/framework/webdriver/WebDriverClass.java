package com.framework.webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass {
	
	private static WebDriver driver;
	
	//Launch the Browser Window
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
	
	}
	public static void closeBrowser() {
		driver.close();
	}
	//Method to share driver details
	public static WebDriver getDriver() {
		return driver;		
	}
	

}
