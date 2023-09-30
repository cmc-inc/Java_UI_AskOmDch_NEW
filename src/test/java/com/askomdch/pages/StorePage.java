package com.askomdch.pages;

import com.askomdch.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By storeHeader = By.cssSelector(".woocommerce-products-header__title.page-title");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public String getStoreHeaderText() {
        return driver.findElement(storeHeader).getText();
    }
}
