package com.askomdch.api;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;

public class TestApis {
    public static void main(String[] args) {

        Response response = new AddToCartApi()
                .addToCart(1198, 1);
        System.out.println("1st response: " + response.getDetailedCookies());

        Response newResponse = new AddToCartApi(response.getDetailedCookies())
                .addToCart(1205, 2);
        System.out.println("2nd response: " + newResponse.getDetailedCookies());
    }
}
