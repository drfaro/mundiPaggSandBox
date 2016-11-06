package com.mundipaggsandbox.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.mundipaggsandbox.WebClient;
import com.mundipaggsandbox.converter.PaymentConverter;
import com.mundipaggsandbox.model.Merchant;
import com.mundipaggsandbox.model.Payment;
import com.mundipaggsandbox.model.User;

/**
 * Created by guilherme on 04/11/16.
 */
public class PaymentTask extends AsyncTask {

    private Payment payment;
    private Context context;
    private Merchant merchant;
    private User user;
    private ProgressDialog progress;
    private WebClient wb;
    private PaymentConverter payConveter;

    public PaymentTask(Context context,Payment payment,User user,Merchant merchant){
        this.context = context;
        this.payment = payment;
        this.merchant = merchant;
        this.user = user;
        wb = new WebClient();
    }
    @Override
    protected Object doInBackground(Object[] objects) {

        payConveter = new PaymentConverter(payment);
        try{
            return wb.postPayment(payConveter.getJson(), user, merchant);
        }catch (Exception e){
            return "Erro ao se comunicar com servidor";
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progress = ProgressDialog.show(context,"validando","",true,true);

    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progress.dismiss();

        String response = ((String) o);
        if (wb.getResponseCode() == 200 || wb.getResponseCode() == 201 ){
            response = payConveter.getMessageSuccess(response);
            Toast.makeText(context, response, Toast.LENGTH_LONG).show();
            ((Activity) context).finish();

        }else{
            response = payConveter.getMessageError(response);
            Toast.makeText(context, response, Toast.LENGTH_LONG).show();
        }


    }
}
