package com.selenium.mavenproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Risers {
	
	@FindBy(css = "#ls-row-RS1-L > td.name-col.align-left > a")
    private WebElement topRiser;

    public String getTopRiser() {
        return this.topRiser.getText();
    }
}
