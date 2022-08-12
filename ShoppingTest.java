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

public class ShoppingTest {

	private RemoteWebDriver driver;

	    @BeforeEach
	    void setup() {
	        this.driver = new ChromeDriver();
	    }
	    @Test
	    void test() {
	        this.driver.get("http://automationpractice.com/index.php");
	        WebElement searchBox = this.driver.findElement(By.id("search_query_top"));
	        searchBox.sendKeys("dress");
	        searchBox.sendKeys(Keys.ENTER);

	        WebElement topResult = this.driver
	                .findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"));

	        assertEquals("Printed Summer Dress", topResult.getText());
}
	    @AfterEach
		void tearDown() {
			this.driver.close();
		}
}
