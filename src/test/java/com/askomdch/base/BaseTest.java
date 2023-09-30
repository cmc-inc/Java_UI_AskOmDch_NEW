package com.askomdch.base;

import com.askomdch.browserfactory.DriverManager;
import com.askomdch.browserfactory.DriverManagerFactory;
import com.askomdch.constants.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    private ThreadLocal<DriverManager> driverManager = new ThreadLocal<>();
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DriverManager getDriverManager() {
        return driverManager.get();
    }

    public void setDriverManager(DriverManager driverManager) {
        this.driverManager.set(driverManager);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser) {
        //browser = "CHROME";
        setDriverManager(DriverManagerFactory.getManager(DriverType.valueOf(browser)));
        setDriver(getDriverManager().getDriver());
        System.out.println("THREAD ID IS: " + Thread.currentThread().getId());
    }
}
