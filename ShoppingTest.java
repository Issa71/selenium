package com.selenium.mavenproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	   
	    
	    @Test
	    void checkOutTest() {
	        this.driver.get("http://automationpractice.com/index.php");

	        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));

	        WebElement searchBox = this.driver.findElement(By.id("search_query_top"));
	        searchBox.sendKeys("dress");
	        searchBox.sendKeys(Keys.ENTER);

	        WebElement topResult = this.driver
	                .findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"));
	        Actions action = new Actions(this.driver);
	        action.moveToElement(topResult);

	        WebElement addToCartBtn = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > div.button-container > " +
	                        "a.button.ajax_add_to_cart_button.btn.btn-default")));

	        addToCartBtn.click();

	       
	        WebElement proceedButton = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")));
	        proceedButton.click();

	        WebElement proceedButton2 = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")));
	        proceedButton2.click();

	      
	        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
	        WebElement psswordField = this.driver.findElement(By.cssSelector("#passwd"));

	        emailField.sendKeys("mo123@gmail.com");
	        psswordField.sendKeys("abcd123");

	       
	        WebElement signInButton = this.driver.findElement(By.cssSelector("#SubmitLogin"));
	        signInButton.click();

	        WebElement proceedButton3 = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("#center_column > form > p > button")));
	        proceedButton3.click();

	        WebElement tosChecker = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("#uniform-cgv")));
	        tosChecker.click();

	        WebElement proceedButton4 = this.driver.findElement(By.cssSelector("#form > p > button"));
	        proceedButton4.click();

	       
	        WebElement payByWire = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a")));
	        payByWire.click();

	        WebElement confirmButton = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("#cart_navigation > button")));
	        confirmButton.click();

	       
	        WebElement checkField = wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.cssSelector("#center_column > div > p > strong")));

	        assertEquals("Your order is complete.", checkField.getText());

	    }
	    @AfterEach
		void tearDown() {
			this.driver.close();
		}
}

