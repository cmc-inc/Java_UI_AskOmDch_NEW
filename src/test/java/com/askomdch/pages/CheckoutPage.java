package com.askomdch.pages;

import com.askomdch.api.AddToCartApi;
import com.askomdch.base.BasePage;
import com.askomdch.objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By subTotal = By.xpath("//tr[@class='cart-subtotal']//bdi[1]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/checkout");
    }

    public String getProductName(Product product) {
        return product.getName();
    }

    public String getSubTotalAsGuestUser() {
        return driver.findElement(subTotal).getText();
    }

    public CheckoutPage addToCart(int productId) {
        AddToCartApi addToCartApi = new AddToCartApi();
        addToCartApi.addToCart(productId, 1);
        load();
        injectCookiesToBrowser(addToCartApi.getCookies());
        driver.navigate().refresh();
        return this;
    }

    public CheckoutPage addToCart(int productId1, int productId2) {
        AddToCartApi addToCartApi = new AddToCartApi();
        addToCartApi.addToCart(productId1,1);
        load();
        injectCookiesToBrowser(addToCartApi.getCookies());
        addToCartApi.addToCart(productId2, 1);
        load();
        injectCookiesToBrowser(addToCartApi.getCookies());
        driver.navigate().refresh();
        return this;
    }
}
