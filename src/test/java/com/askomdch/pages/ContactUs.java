package com.askomdch.pages;

import com.askomdch.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs extends BasePage {

    private final By pageHeader = By.cssSelector("h1[class='has-text-align-center']");

    public ContactUs(WebDriver driver) {
        super(driver);
    }

    public String getPageHeader() {
        return driver.findElement(pageHeader).getText();
    }
}
