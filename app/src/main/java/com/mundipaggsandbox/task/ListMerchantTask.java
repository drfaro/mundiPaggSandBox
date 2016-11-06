package com.mundipaggsandbox.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.mundipaggsandbox.ListMerchantActivity;
import com.mundipaggsandbox.WebClient;
import com.mundipaggsandbox.converter.MerchantConverter;
import com.mundipaggsandbox.model.Merchant;
import com.mundipaggsandbox.model.User;


import java.util.List;

/**
 * Created by guilherme on 03/11/16.ncy
 */
public class ListMerchantTask extends AsyncTask <Object, Object, String> {


    private TextView listMerchantMessage;
    private String term;
    private Context context;
    private User user;
    private String response;

    public ListMerchantTask(Context context,User user,TextView listMerchantMessage){

        this.context = context;
        this.user = user;
        this.listMerchantMessage = listMerchantMessage;
    }

    public ListMerchantTask(Context context, User user,TextView listMerchantMessage, String term) {
        this.term = term;
        this.context = context;
        this.user = user;
        this.listMerchantMessage = listMerchantMessage;
    }


    @Override
    protected String doInBackground(Object[] objects) {
        WebClient wb = new WebClient();


        try {
            response = wb.getListMerchant(user,term);
            return response;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        listMerchantMessage.setText("Aguarde...");
    }

    @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);

        listMerchantMessage.setText("");

        List<Merchant> list = null;
        if (o != null ) {
            MerchantConverter mc = new MerchantConverter(o);
            list= mc.getMerchants();
        }

        ((ListMerchantActivity) context).loadMerchant(list);

    }
}
