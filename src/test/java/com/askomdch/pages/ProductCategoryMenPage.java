package com.askomdch.pages;

import com.askomdch.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCategoryMenPage extends BasePage {

    private final By headerText = By.xpath("//h1[normalize-space()='Men']");

    public ProductCategoryMenPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }
}
