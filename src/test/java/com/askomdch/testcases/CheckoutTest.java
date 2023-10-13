package com.askomdch.testcases;

import com.askomdch.base.BaseTest;
import com.askomdch.objects.Product;
import com.askomdch.pages.CheckoutPage;
import com.askomdch.pages.StorePage;
import com.askomdch.utils.ReadJsonData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends BaseTest {

    @Test
    public void testSubTotalAsGuestUser() throws IOException {
        Product product = new Product(1196);
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        String actualResult = checkoutPage.addToCart(product.getId()).getSubTotalAsGuestUser();
        Assert.assertEquals(actualResult, "$34.00");
    }

    @Test
    public void testSubTotalForMultipleProductsAsGuestUser() throws IOException, InterruptedException {
        Product product1 = new Product(1196);
        Product product2 = new Product(1209);
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        String expResult = String.format("%.2f", Float.parseFloat(product1.getPrice().substring(1))
                + Float.parseFloat(product2.getPrice().substring(1)));
        String actualResult = checkoutPage.addToCart(product1.getId(), product2.getId()).getSubTotalAsGuestUser();
        Assert.assertEquals(actualResult, "$" + expResult);
    }

    @Test(dataProvider = "dp", dataProviderClass = ReadJsonData.class)
    public void testSubTotalAsGuestUserParameterized(String data) throws IOException {
        String products[] = data.split(",");
        //Product product = new Product(1196);
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        String actualResult = checkoutPage.addToCart(Integer.parseInt(products[0])).getSubTotalAsGuestUser();
        Assert.assertEquals(actualResult, products[1]);
    }

    @Test
    public void testPageTitle() throws IOException {
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        Product product = new Product(1196);
        checkoutPage.addToCart(product.getId());
        String actualResult = checkoutPage.load().getPageTitle();
        Assert.assertEquals(actualResult, "Checkout – AskOmDch");
    }
}
