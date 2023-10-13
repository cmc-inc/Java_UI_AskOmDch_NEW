package com.askomdch.objects;

import com.askomdch.utils.DeserializeJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private String price;

    public Product() {}

    public Product(int id) throws IOException {
        Product[] products = DeserializeJson.deserializeJson("products.json", Product[].class);
        for(Product product : products) {
            if(product.id == id){
                setId(product.id);
                setName(product.name);
                setPrice(product.price);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getFilteredProducts() throws IOException {
        Product[] products = DeserializeJson.deserializeJson("products.json", Product[].class);
        List<String> productsList = new ArrayList<>();
        productsList.add("$100.00");
        for (Product product: products) {
            if(Float.parseFloat(product.getPrice().substring(1)) >= 70.00) {
                productsList.add(product.getPrice());
            }
        }
        Collections.sort(productsList);
        return productsList;
    }
}
