package com.askomdch.base;

import com.askomdch.utils.CookieUtils;
import io.restassured.http.Cookies;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void load(String endpoint) {
        driver.get("https://askomdch.com" + endpoint);
    }

    public WebElement visibilityOfElement(By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void injectCookiesToBrowser(Cookies cookies){
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie: seleniumCookies){
            System.out.println(cookie.toString());
            driver.manage().addCookie(cookie);
        }
    }
}
