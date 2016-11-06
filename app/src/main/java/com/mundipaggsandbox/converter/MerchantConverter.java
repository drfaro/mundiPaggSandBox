package com.mundipaggsandbox.converter;

import com.mundipaggsandbox.model.Merchant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 03/11/16.
 */
public class MerchantConverter {

    private String json;

    public MerchantConverter(String json){

        this.json = json;
    }


    public List<Merchant> getMerchants(){

        List<Merchant> listMerchants = new ArrayList<Merchant>();

        try {
            JSONObject js = new JSONObject(json);

            JSONArray jsonList = js.getJSONArray("items");
            final int numberOfItemsInResp = jsonList.length();

            for (int i = 0 ; i < numberOfItemsInResp; i++){

                JSONObject item = jsonList.getJSONObject(i);

                Merchant merchant = new Merchant();
                merchant.setMerchantKey(item.getString("merchantKey"));
                merchant.setPublicMerchantKey(item.getString("publicMerchantKey"));
                merchant.setName(item.getString("merchantName"));
                merchant.setDocumentNumber(item.getString("documentNumber"));
                merchant.setCorporateName(item.getString("corporateName"));
                merchant.setRetryEnabled(item.getBoolean("isRetryEnabled"));
                merchant.setEnabled(item.getBoolean("isEnabled"));
                merchant.setDeleted(item.getBoolean("isDeleted"));
                merchant.setAntiFraudEnabled(item.getBoolean("isAntiFraudEnabled"));
                merchant.setMerchantStatus(item.getString("merchantStatus"));
                merchant.setId(Long.valueOf(item.getString("documentNumber"),36).longValue());


                listMerchants.add(merchant);
            }

            return listMerchants;



        } catch (JSONException e) {
            e.printStackTrace();

        }

        return null;
    }
}
