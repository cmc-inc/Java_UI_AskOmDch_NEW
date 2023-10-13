package com.askomdch.testcases;

import com.askomdch.base.BaseTest;
import com.askomdch.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        getDriver().get("https://askomdch.com");
        getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @Test
    public void testPageHeaderFontWeight() {
        String expResult = new HomePage(getDriver()).getPageHeaderFontWeight();
        Assert.assertEquals(expResult, "700");
    }

    @Test
    public void testPageTitle() {
        String expResult = getDriver().getTitle();
        Assert.assertEquals(expResult, "AskOmDch – Become a Selenium automation expert!");
    }

    @Test
    public void testLogoText() {
        String expResult = new HomePage(getDriver()).getPageTitle();
        Assert.assertEquals(expResult, "AskOmDch");
    }

    @Test
    public void testNavbarContentText() {
        String expResult = new HomePage(getDriver()).getNavbarContentText();
        Assert.assertEquals(expResult, "Home\n" +
                "Store\n" +
                "Men\n" +
                "Women\n" +
                "Accessories\n" +
                "Account\n" +
                "About\n" +
                "Contact Us");
    }

    @Test
    public void testPageSubHeaderText() {
        String expResult = new HomePage(getDriver()).getPageSubHeaderText();
        Assert.assertEquals(expResult, "25% OFF On all products");
    }

    @Test
    public void testPageHeaderText() {
        String expResult = new HomePage(getDriver()).getPageHeaderText();
        Assert.assertEquals(expResult, "Raining Offers for Hot Summer!");
    }

    @Test
    public void testShopNowLinkText() {
        String expResult = new HomePage(getDriver()).getShopNowLinkText();
        Assert.assertEquals(expResult, "SHOP NOW");
    }

    @Test
    public void testShopNowHrefAttr() {
        String expResult = new HomePage(getDriver()).getShopNowHrefAttr();
        Assert.assertEquals(expResult, "https://askomdch.com/store");
    }

    @Test
    public void testFindMoreLinkText() {
        String expResult = new HomePage(getDriver()).getFindMoreLinkText();
        Assert.assertEquals(expResult, "FIND MORE");
    }

    @Test
    public void testFindMoreHrefAttr() {
        String expResult = new HomePage(getDriver()).getFindMoreHrefAttr();
        Assert.assertEquals(expResult, "https://askomdch.com/contact-us/");
    }

    @Test
    public void testStoreHeaderText() {
        String expResult = new HomePage(getDriver()).goToStorePage().getStoreHeaderText();
        Assert.assertEquals(expResult, "Store");
    }

    @Test
    public void testEmptyCartText() {
        String expResult = new HomePage(getDriver()).viewCart();
        Assert.assertEquals(expResult, "0");
    }

    @Test(enabled = false)
    public void testCartPopUpText() {
        String expResult = new HomePage(getDriver()).getCartPopUpMessage();
        Assert.assertEquals(expResult, "No products in the cart.");
    }

    @Test()
    public void testClickingOnShopNowLinkOpensStorePage() {
        String expResult = new HomePage(getDriver()).clickShopNowLink().getStoreHeaderText();
        Assert.assertEquals(expResult, "Store");
    }

    @Test()
    public void testClickingOnFindMoreLinkOpensContactUsPage() {
        String expResult = new HomePage(getDriver()).clickFindMoreLink().getPageHeader();
        Assert.assertEquals(expResult, "Contact Us");
    }

    @Test
    public void testArticleImageOne() {
        String expResult = new HomePage(getDriver()).getArticleImageOneHrefAttr();
        Assert.assertEquals(expResult, "https://askomdch.com/wp-content/uploads/2021/06/launchpad9.jpg");
    }

    @Test
    public void testArticleOneHeaderText() {
        String expResult = new HomePage(getDriver()).getArticleOneHeaderText();
        Assert.assertEquals(expResult, "20% Off on Tank Tops");
    }

    @Test
    public void testArticleOneParagraphText() {
        String expResult = new HomePage(getDriver()).getArticleOneParagraphText();
        Assert.assertEquals(expResult, "Lorem ipsum dolor sit amet consectetur");
    }

    @Test
    public void testArticleOneShopNowLinkText() {
        String expResult = new HomePage(getDriver()).getArticleOneShopNowLinkText();
        Assert.assertEquals(expResult, "SHOP NOW");
    }

    @Test
    public void testArticleOneShopNowLinkHrefAttr() {
        String expResult = new HomePage(getDriver()).getArticleOneShopNowLinkHrefAttr();
        Assert.assertEquals(expResult, "https://askomdch.com/product-category/women/");
    }

    @Test
    public void testClickingOnShopNowLinkOpensProductCategoryWomenPage() {
        String expResult = new HomePage(getDriver()).clickArticleOneShopNowLink().getHeaderText();
        Assert.assertEquals(expResult, "Women");
    }

    @Test
    public void testArticleImageTwo() {
        String expResult = new HomePage(getDriver()).getArticleImageTwoHrefAttr();
        Assert.assertEquals(expResult, "https://askomdch.com/wp-content/uploads/2021/06/launchpad_FRAGRANCE.jpg");
    }

    @Test
    public void testArticleTwoHeaderText() {
        String expResult = new HomePage(getDriver()).getArticleTwoHeaderText();
        Assert.assertEquals(expResult, "Latest Eyewear");
    }

    @Test
    public void testArticleTwoParagraphText() {
        String expResult = new HomePage(getDriver()).getArticleTwoParagraphText();
        Assert.assertEquals(expResult, "Lorem ipsum dolor sit amet consectetur");
    }

    @Test
    public void testArticleTwoShopNowLinkText() {
        String expResult = new HomePage(getDriver()).getArticleTwoShopNowLinkText();
        Assert.assertEquals(expResult, "SHOP NOW");
    }

    @Test
    public void testArticleTwoShopNowLinkHrefAttr() {
        String expResult = new HomePage(getDriver()).getArticleTwoShopNowLinkHrefAttr();
        Assert.assertEquals(expResult, "https://askomdch.com/product-category/men/");
    }

    @Test
    public void testClickingOnShopNowLinkOpensProductCategoryMenPage() {
        String expResult = new HomePage(getDriver()).clickArticleTwoShopNowLink().getHeaderText();
        Assert.assertEquals(expResult, "Men");
    }

    @Test
    public void testFeaturedProductsText() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertEquals(homePage.getFeaturedProductsText(), "Featured Products");
        Assert.assertTrue(homePage.featuredProductsIsDisplayed());
    }
}
