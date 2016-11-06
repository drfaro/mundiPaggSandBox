package com.mundipaggsandbox.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.mundipaggsandbox.ListMerchantActivity;
import com.mundipaggsandbox.WebClient;
import com.mundipaggsandbox.converter.LoginConverter;
import com.mundipaggsandbox.converter.UserConverter;
import com.mundipaggsandbox.helper.LoginHelper;
import com.mundipaggsandbox.model.User;

/**
 * Created by guilherme on 29/10/16.
 */
public class LoginTask extends AsyncTask {

    private final Context context;
    private ProgressDialog progress;
    private WebClient wc;

    public LoginTask(Context context){
        this.context = context;
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        LoginHelper lh = new LoginHelper((Activity) context);
        LoginConverter loginConverter = new LoginConverter(lh.getLoginUser(),lh.getLoginPassword());
        wc = new WebClient();

        try{
            return wc.postLogin(loginConverter.getJson());
        }catch (Exception e){
            progress.dismiss();
            return null;
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress = ProgressDialog.show(context,"Logando","conectanco no servidor",false,true);
    }

    @Override
    protected void onPostExecute(Object o) {
        progress.dismiss();
        super.onPostExecute(o);
        String response = (String) o;
        if (wc.getResponseCode() == 200 || wc.getResponseCode() == 201) {
            UserConverter uc = new UserConverter(response);
            User user = uc.getUser();
            Intent intent = new Intent(context, ListMerchantActivity.class);
            intent.putExtra("user", user);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }else{
            Toast.makeText(context,LoginConverter.getMessageError(response),Toast.LENGTH_SHORT).show();
        }
    }
}
