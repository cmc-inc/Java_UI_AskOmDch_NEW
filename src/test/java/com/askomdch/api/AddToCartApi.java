package com.askomdch.api;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AddToCartApi {
    private Cookies cookies;

    public AddToCartApi() {}

    public AddToCartApi(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public Response addToCart(int productId, int quantity) {
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);

        if(cookies == null) {
            cookies = new Cookies();
        }

        Response response = given()
                .baseUri("https://askomdch.com")
                .contentType(ContentType.URLENC)
                .cookies(cookies)
                .formParams(formParams)
                .when()
                .post("/?wc-ajax=add_to_cart")
                .then()
                .extract()
                .response();
        this.cookies = response.getDetailedCookies();
        return response;
    }

    public Response addToCart(int productId1, int productId2, int quantity) {
        HashMap<String, Object> formParams1 = new HashMap<>();
        List list = new ArrayList<>();
        list.add(productId1);
        list.add(productId2);
        formParams1.put("product_sku", "");
        formParams1.put("product_id", list);
        formParams1.put("quantity", quantity);

        if(cookies == null) {
            cookies = new Cookies();
        }

        Response response = given()
                .baseUri("https://askomdch.com")
                .contentType(ContentType.URLENC)
                .cookies(cookies)
                .formParams(formParams1)
        .when()
                .post("/?wc-ajax=add_to_cart")
        .then()
                .extract()
                .response();
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
