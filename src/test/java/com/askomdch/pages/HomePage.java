package com.askomdch.pages;

import com.askomdch.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends BasePage {
    private final By logoText = By.cssSelector("h1[class='site-title'] a");
    private final By navbarElements = By.xpath("(//ul[@id='ast-hf-menu-1'])[1]");
    private final By pageHeaderText = By.xpath("//h1[normalize-space()='Raining Offers for Hot Summer!']");
    private final By shopNowLink = By.cssSelector("a[class='wp-block-button__link']");
    private final By storeNavbarLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");
    private final By pageSubHeaderText = By.xpath("//h3[normalize-space()='25% OFF On all products']");
    private final By findMoreLink = By.xpath("//a[normalize-space()='Find More']");
    private final By viewCart = By.xpath(("(//span[@class='count'][normalize-space()='0'])[1]"));
    private final By cartPopUpMessage = By.xpath("(//p[text()='No products in the cart.'])[1]");
    private final By articleImageOne = By.xpath("(//div[@class='wp-block-cover has-background-dim-40 has-background-dim'])[1]//img");
    private final By articleOneHeader = By.xpath(("//h3[normalize-space()='20% Off on Tank Tops']"));
    private final By articleOneParagraph = By.xpath(("(//p[contains(text(),'Lorem ipsum dolor sit amet consectetur')])[1]"));
    private final By articleOneShopNowLink = By.xpath(("(//a[@href='https://askomdch.com/product-category/women/'][normalize-space()='Shop Now'])[1]"));
    private final By articleImageTwo = By.xpath("(//div[@class='wp-block-cover has-background-dim-40 has-background-dim'])[2]//img");
    private final By articleTwoHeader = By.xpath(("//h3[normalize-space()='Latest Eyewear']"));
    private final By articleTwoParagraph = By.xpath(("(//p[contains(text(),'Lorem ipsum dolor sit amet consectetur')])[2]"));
    private final By articleTwoShopNowLink = By.xpath(("(//a[@href='https://askomdch.com/product-category/men/'][normalize-space()='Shop Now'])[1]"));
    private final By featuredProducts = By.cssSelector("h2[class='has-text-align-center']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeaderFontWeight() {
        return driver.findElement(pageHeaderText).getCssValue("font-weight");
    }

    public String getPageTitle() {
        return driver.findElement(logoText).getText();
    }

    public String getNavbarContentText() {
        String text = "";
        List<WebElement> elements = driver.findElements(navbarElements);
        for(WebElement el : elements) {
            text = text + el.getText();
        }
        return text;
    }

    public String getPageHeaderText() {
        return driver.findElement(pageHeaderText).getText();
    }

    public String getPageSubHeaderText() {
        return driver.findElement(pageSubHeaderText).getText();
    }

    public String getShopNowLinkText() {
        return driver.findElement(shopNowLink).getText();
    }

    public String getShopNowHrefAttr() {
        return driver.findElement(shopNowLink).getAttribute("href");
    }

    public String getFindMoreLinkText() {
        return driver.findElement(findMoreLink).getText();
    }

    public String getFindMoreHrefAttr() {
        return driver.findElement(findMoreLink).getAttribute("href");
    }

    public StorePage goToStorePage() {
        driver.findElement(storeNavbarLink).click();
        return new StorePage(driver);
    }

    public String viewCart() {
        return driver.findElement(viewCart).getText();
    }

    public String getCartPopUpMessage() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(viewCart)).build().perform();
        //Thread.sleep(3000);
        return visibilityOfElement(cartPopUpMessage).getText();
    }

    public StorePage clickShopNowLink() {
        driver.findElement(shopNowLink).click();
        return new StorePage(driver);
    }

    public ContactUs clickFindMoreLink() {
        driver.findElement(findMoreLink).click();
        return new ContactUs(driver);
    }

    public String getArticleImageOneHrefAttr() {
        return driver.findElement(articleImageOne).getAttribute("src");
    }

    public String getArticleOneHeaderText() {
        return driver.findElement(articleOneHeader).getText();
    }

    public String getArticleOneParagraphText() {
        return driver.findElement(articleOneParagraph).getText();
    }

    public String getArticleOneShopNowLinkText() {
        return driver.findElement(articleOneShopNowLink).getText();
    }

    public String getArticleOneShopNowLinkHrefAttr() {
        return driver.findElement(articleOneShopNowLink).getAttribute("href");
    }

    public ProductCategoryWomenPage clickArticleOneShopNowLink() {
        driver.findElement(articleOneShopNowLink).click();
        return new ProductCategoryWomenPage(driver);
    }

    public String getArticleImageTwoHrefAttr() {
        return driver.findElement(articleImageTwo).getAttribute("src");
    }

    public String getArticleTwoHeaderText() {
        return driver.findElement(articleTwoHeader).getText();
    }

    public String getArticleTwoParagraphText() {
        return driver.findElement(articleTwoParagraph).getText();
    }

    public String getArticleTwoShopNowLinkText() {
        return driver.findElement(articleTwoShopNowLink).getText();
    }

    public String getArticleTwoShopNowLinkHrefAttr() {
        return driver.findElement(articleTwoShopNowLink).getAttribute("href");
    }

    public ProductCategoryMenPage clickArticleTwoShopNowLink() {
        driver.findElement(articleTwoShopNowLink).click();
        return new ProductCategoryMenPage(driver);
    }

    public String getFeaturedProductsText() {
        return driver.findElement(featuredProducts).getText();
    }

    public boolean featuredProductsIsDisplayed() {
        return driver.findElement(featuredProducts).isDisplayed();
    }
}
