package com.askomdch.pages;

import com.askomdch.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StorePage extends BasePage {

    private final By storeHeader = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By slider = By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]");
    private final By filterButton = By.xpath("//button[normalize-space()='Filter']");
    private final By filteredProductsList = By.xpath("//ul[@class='products columns-4']//span[@class='woocommerce-Price-amount amount']/bdi");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage load() {
        load("/store");
        return this;
    }

    public String getStoreHeaderText() {
        return driver.findElement(storeHeader).getText();
    }

    public StorePage moveSliderRight() {
        for (int i = 1; i <= 11 ; i++) {
            visibilityOfElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    public String clickFilterBtn() {
        driver.findElement(filterButton).click();
        return driver.getCurrentUrl();
    }

    public List<String> getFilteredProductsList() {
        List<WebElement> elements = driver.findElements(filteredProductsList);
        List<String> productList = new ArrayList<>();
        for (WebElement e: elements){
            //System.out.println(e.getText());
            productList.add(e.getText());
        }
        Collections.sort(productList);
        return productList;
    }
}
