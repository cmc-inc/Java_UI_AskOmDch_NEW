package com.askomdch.browserfactory;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected void startDriver() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
}
