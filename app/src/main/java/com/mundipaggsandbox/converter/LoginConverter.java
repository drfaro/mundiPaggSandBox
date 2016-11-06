package com.mundipaggsandbox.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/**
 * Created by guilherme on 29/10/16.
 */
public class LoginConverter {

    private final String password;
    private final String user;

    public LoginConverter(String user,String password){
        this.user = user;
        this.password = password;
    }

    public String getJson(){

        JSONStringer js = new JSONStringer();

        try {
            js.object().key("username").value(user).key("password").value(password).endObject();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return js.toString();
    }

    public static String getMessageError(String json) {

        JSONObject js = null;
        String msg = null;
        try {
            js = new JSONObject(json);

            msg = js.getJSONArray("errors").getJSONObject(0).getString("message");

        } catch (JSONException e) {
            //e.printStackTrace();
            msg = "Erro ao fazer login";
        }


        return msg;
    }
}
