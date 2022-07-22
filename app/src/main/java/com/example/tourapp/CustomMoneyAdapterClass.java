package com.example.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomMoneyAdapterClass extends BaseAdapter {
    String[] moneyName;
    int[] moneyImage;
    Context context;

    public CustomMoneyAdapterClass(Context context, int spinner_money_text, String[] moneyName, int[] moneyImage) {
        this.context = context;
        this.moneyImage = moneyImage;
        this.moneyName = moneyName;
    }

    @Override
    public int getCount() {
        return moneyImage.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.spinner_money_text, null);
        TextView moneyname = convertView.findViewById(R.id.textItemSpinner);
        moneyname.setText(moneyName[position]);
        ImageView imageMoney = convertView.findViewById(R.id.imageOfMoney);
        imageMoney.setImageResource(moneyImage[position]);

        return convertView;

    }
}


