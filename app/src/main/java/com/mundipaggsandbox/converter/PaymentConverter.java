package com.mundipaggsandbox.converter;

import com.mundipaggsandbox.model.Payment;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/**
 * Created by guilherme on 04/11/16.
 */
public class PaymentConverter {


    private Payment payment;

    public PaymentConverter(Payment payment) {
        this.payment = payment;
    }


    public String getJson(){

        //JSONObject json = new JSONObject();
        JSONStringer json = new JSONStringer();

        try {
            json.object().key("CreditCardTransactionCollection").array().object()
                    .key("AmountInCents").value(payment.getAmountInCents())
                    .key("InstallmentCount").value(payment.getInstallmentCount())
                    .key("CreditCardOperation").value("AuthAndCapture")
                    .key("CreditCard").object()
                        .key("CreditCardNumber").value(payment.getCreditCardNumber())
                        .key("ExpMonth").value(payment.getExpMonth())
                        .key("ExpYear").value(payment.getExpYear())
                        .key("CreditCardBrand").value(payment.getCreditCardBrand())
                        .key("HolderName").value(payment.getCreditCardHolderName())
                        .key("SecurityCode").value(payment.getSecurityCode())
                    .endObject()
            .endObject().endArray().endObject();
            json.object().key("Buyer").object()
                    .key("Name").value(payment.getName())
                    .key("Email").value(payment.getEmail())
            .endObject().endObject();

        } catch (JSONException e) {

            e.printStackTrace();
        }


        return json.toString();
    }

    public String getMessageSuccess(String json) {
        JSONObject js;
        String msg;
        try {
            js = new JSONObject(json);
            msg = js.getJSONArray("CreditCardTransactionResultCollection").getJSONObject(0).getString("AcquirerMessage");

        } catch (JSONException e) {
            //e.printStackTrace();
            return "Erro ao se comunicar com servidor "+json;
        }

        return msg;
    }

    public String getMessageError(String json) {
        JSONObject js;
        String msg;
        try {
            js = new JSONObject(json);
            msg = js.getJSONObject("ErrorReport").getJSONArray("ErrorItemCollection").getJSONObject(0).getString("Description");

        } catch (JSONException e) {
            //e.printStackTrace();
            return "Erro ao se comunicar com servidor";
        }

        return msg;
    }
}
