package com.selenium.mavenproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoTest {

	private RemoteWebDriver driver;

	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver(); 
	}

	@Test
	void demoTest() {
		this.driver.get("https://www.bbc.co.uk/search?q=");
		WebElement search = this.driver.findElement(By.cssSelector("#search-input"));
		search.sendKeys("Turtles"); 
		search.sendKeys(Keys.ENTER); 

		WebElement result = this.driver.findElement(By.cssSelector(
				"#main-content > div:nth-child(3) > div.ssrcss-1v7bxtk-StyledContainer.enjd40x0 > div > div > ul > li:nth-child(1) > div > div > div.ssrcss-tq7xfh-PromoContent.e1f5wbog7 > div.ssrcss-1f3bvyz-Stack.e1y4nx260 > a > span > p > span"));


		assertEquals("The Man Who Made Mock Turtle Soup", result.getText());

	}

	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}

