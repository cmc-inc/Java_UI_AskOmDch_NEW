package com.askomdch.pages;

import com.askomdch.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCategoryWomenPage extends BasePage {

    private final By headerText = By.xpath("//h1[normalize-space()='Women']");

    public ProductCategoryWomenPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }
}
