package com.mundipaggsandbox.converter;

import com.mundipaggsandbox.model.User;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by guilherme on 29/10/16.
 */
public class UserConverter {

    private User user;
    private String json;

    public UserConverter(String json){
        this.json = json;
    }
    public UserConverter(User user){
        this.user = user;
    }

    public User getUser(){

        User user = new User();

        try {
            JSONObject js = new JSONObject(json);

            user.setName(js.getString("name"));
            user.setAccessToken(js.getString("accessToken"));
            user.setCustomerKey(js.getString("customerKey"));
            user.setExpiresIn(js.getInt("expiresIn"));
            user.setRefreshToken(js.getString("refreshToken"));
            user.setTokenType(js.getString("tokenType"));
            user.setUsername(js.getString("username"));
            user.setUserId(js.getString("userId"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return user;
    }
}
