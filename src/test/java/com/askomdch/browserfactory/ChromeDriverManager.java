package com.askomdch.browserfactory;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected void startDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
