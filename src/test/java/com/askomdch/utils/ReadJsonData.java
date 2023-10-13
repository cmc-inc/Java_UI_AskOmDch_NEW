package com.askomdch.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonData {
    @DataProvider(name= "dp")
    public Object[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/products2.json");

        Object obj = jsonParser.parse(reader);

        JSONObject userLoginsJsonObj = (JSONObject) obj;
        JSONArray userLoginsArray = (JSONArray) userLoginsJsonObj.get("products");

        Object data[] = new String [userLoginsArray.size()];

        for(int i=0; i<userLoginsArray.size(); i++) {
            JSONObject users = (JSONObject) userLoginsArray.get(i);
            int user = Integer.parseInt(String.valueOf(users.get("id")));
            String pwd = (String) users.get("price");

            data[i] = user + "," + pwd;
        }
        return data;
    }
}
