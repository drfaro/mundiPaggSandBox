package com.mundipaggsandbox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mundi.R;
import com.mundipaggsandbox.model.Merchant;

import java.util.List;

/**
 * Created by guilherme on 29/10/16.
 */
public class MerchantAdapter extends BaseAdapter {

    private final List<Merchant> merchants;
    private final Context context;

    public MerchantAdapter(Context context, List<Merchant> merchants) {
        this.context = context;
        this.merchants = merchants;
    }

    @Override
    public int getCount() {
        return merchants.size();
    }

    @Override
    public Object getItem(int i) {
        return merchants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return merchants.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        View view = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (view == null) {
            view = inflater.inflate(R.layout.merchant_list_item,viewGroup,false);
        }

        TextView merchantCorporate = (TextView) view.findViewById(R.id.merchant_list_corporate);
        TextView merchantName  = (TextView) view.findViewById(R.id.merchant_list_name);

        Merchant merchant = merchants.get(i);
        merchantCorporate.setText(merchant.getDocumentNumber());
        merchantName.setText(merchant.getName());

        return view;
    }



}
