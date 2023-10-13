package com.askomdch.api;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;

public class TestApis {
    public static void main(String[] args) {
        //Cookie cookie = new Cookie("wp_woocommerce_session_e39c30ea93030240fdcfed1ddf385ba1", "t_c90a1799d5c565940ef2dfaa3ca038%7C%7C1696857659%7C%7C1696854059%7C%7Cd2c07823494cdbda3105d1a2a58b8fd1;Path=/;Max-Age=172799;Secure;HttpOnly;Expires=10/9/23, 1:20 PM");

        Response response = new AddToCartApi()
                .addToCart(1198, 1);
        System.out.println("1st response: " + response.getDetailedCookies());

        Response newResponse = new AddToCartApi(response.getDetailedCookies())
                .addToCart(1205, 2);
        System.out.println("2nd response: " + newResponse.getDetailedCookies());
    }
}
