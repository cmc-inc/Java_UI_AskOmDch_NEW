package com.askomdch.testcases;

import com.askomdch.base.BaseTest;
import com.askomdch.objects.Product;
import com.askomdch.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class StoreTest extends BaseTest {

    @Test
    public void testMovePriceSliderRightAndClickFilterBtn() {
        String actualRes = new StorePage(getDriver()).load().moveSliderRight().clickFilterBtn();
        Assert.assertEquals(actualRes, "https://askomdch.com/store/?min_price=70&max_price=150");
    }

    @Test
    public void testFilteredProducts() throws IOException {
        StorePage storePage = new StorePage(getDriver());
        storePage.load().moveSliderRight().clickFilterBtn();
        Product product = new Product();
        Assert.assertEquals(storePage.getFilteredProductsList(), product.getFilteredProducts());
    }
}
