package com.askomdch.browserfactory;

import com.askomdch.constants.DriverType;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType browser) {
        if(browser == DriverType.CHROME)
            return new ChromeDriverManager();
        else
            return new FirefoxDriverManager();
    }
}
