package com.selenium.mavenproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Fallers {
	
	@FindBy(css = "#ls-row-HLN-L > td.name-col.align-left > a")
    private WebElement topFaller;

    public String getTopFaller() {
        return this.topFaller.getText();
    }
}
