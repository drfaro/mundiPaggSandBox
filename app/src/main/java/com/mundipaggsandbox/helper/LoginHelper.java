package com.mundipaggsandbox.helper;

import android.app.Activity;
import android.widget.EditText;

import com.mundi.R;
import com.mundipaggsandbox.model.User;

/**
 * Created by guilherme on 29/10/16.
 */
public class LoginHelper {

    private EditText loginUser;
    private EditText loginPassword;
    private User user;

    public LoginHelper(Activity activity){

        loginUser = (EditText) activity.findViewById(R.id.login_user);
        loginPassword = (EditText) activity.findViewById(R.id.login_password);

        this.user = new User();

    }

    public String getLoginUser(){
        return loginUser.getText().toString();
    }
    public String getLoginPassword(){
        return loginPassword.getText().toString();
    }

}
