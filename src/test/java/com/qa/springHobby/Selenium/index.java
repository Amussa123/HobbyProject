package com.qa.springHobby.Selenium;

<<<<<<< HEAD
public class index {

}
=======

	import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

	import org.junit.jupiter.api.AfterEach;


	public class index {
		
		// Creating a webdriver data type, calling it driver
		private WebDriver driver;
		
		// Setup our webdriver, so it can create a new browser window
		@BeforeEach
		void setup() {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			// Our Webdriver is being specified as a chrome driver
			this.driver = new ChromeDriver(); 
			
			// Create a new browser window with these measurements
			this.driver.manage().window().setSize(new Dimension(1366, 768)); 
		}
		
		// A test to check the title of bing is "Bing"
		
		@Test
		void testBingTitle() {
			// Arrange Act Assert 
			
			System.out.println(driver);
			
			// Arrange - Setup
			String testString = "Bing";
			String testUrl = "https://www.bing.com/";
			
			// Act - What we're doing
			// Opens up a browser connecting to Bing
			this.driver.get(testUrl);
			
			// Assert - What we're testing
			// Asserting if the title of Bing is Bing
			System.out.println(driver.getTitle());
			Assertions.assertEquals(testString, driver.getTitle());
			
		}
		
		@AfterEach
		void teardown() {
			driver.close();
		}
		
		

	}
>>>>>>> front-end
