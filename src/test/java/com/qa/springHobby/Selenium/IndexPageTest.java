package com.qa.springHobby.Selenium;



	

		import org.junit.jupiter.api.AfterEach;
		import org.junit.jupiter.api.Assertions;
		import org.junit.jupiter.api.BeforeEach;
		import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
		import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

		public class IndexPageTest {
			
			
			private WebDriver driver;
			
			@BeforeEach
			void setup() {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\itsme\\OneDrive\\Documents\\GitHub\\HobbyProject\\src\\main\\resources/chromedriver.exe");
				
				this.driver = new ChromeDriver(); 
				
	
				this.driver.manage().window().setSize(new Dimension(1366, 768)); 
			}
			
			@Test
			void testIndexTitle() {
			 
				
				System.out.println(driver);
				
				String testString = "Main Menu";
				String testUrl = "http://127.0.0.1:5500/iNDEX.HTML";
				
				
				this.driver.get(testUrl);
				
				
				System.out.println(driver.getTitle());
				Assertions.assertEquals(testString, driver.getTitle());
				
			}
			
			
			@Test
			public void testStartNowButton() {
				
			
				driver.get("http://127.0.0.1:5500/iNDEX.HTML");
				
	
				WebElement button = driver.findElement(By.id("Button"));
				System.out.println(button);
				
				
				button.click();
			}
			
			@Test
			public void testAdventureresGuildButton() {
				
				
				driver.get("http://127.0.0.1:5500/iNDEX.HTML");
				
		
				WebElement button = driver.findElement(By.id("Button1"));
				System.out.println(button);
				
		
				button.click();
			}
			

			@Test
			public void testCreateAGuildButton() {
				
			
				driver.get("http://127.0.0.1:5500/iNDEX.HTML");
				
				
				WebElement button = driver.findElement(By.id("Button2"));
				System.out.println(button);
		
				
				button.click();
			}
			

			@Test
			public void testMagicTypeButton() {
				
				
				driver.get("http://127.0.0.1:5500/iNDEX.HTML");
				
			
				WebElement button = driver.findElement(By.id("Button3"));
				System.out.println(button);
				
				
				button.click();
			}
			
			
	
			@AfterEach
			void teardown() {
				driver.close();
			}
			
			

		}
		
		
		

	    
	    
		
	
	
