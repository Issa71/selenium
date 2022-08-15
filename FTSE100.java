package com.selenium.mavenproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FTSE100 {
	
	private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }
    
    @Test
    void fallersTest() {
        this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");

        Home homePage = PageFactory.initElements(this.driver, Home.class);
        homePage.acceptCookies();

        homePage.checkFallers();

        Fallers fallerPage = PageFactory.initElements(this.driver, Fallers.class);
        String result = fallerPage.getTopFaller();

        assertEquals("Haleon plc", result);
    }
    @Test
    void risersTest() {
        this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");

        Home homePage = PageFactory.initElements(this.driver, Home.class);
        homePage.acceptCookies();

        homePage.checkRisers();

        Risers riserPage = PageFactory.initElements(this.driver, Risers.class);
        String result = riserPage.getTopRiser();

        assertEquals("RS Group plc", result);
}
    @AfterEach
    void tearDown() {
        this.driver.close();
    }

}