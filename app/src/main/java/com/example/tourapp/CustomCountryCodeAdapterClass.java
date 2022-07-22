package com.example.tourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomCountryCodeAdapterClass extends BaseAdapter {
    int[] countryFlag;
    String[] countryCode;
    Context Mycontax;

    public CustomCountryCodeAdapterClass(Context Mycontax, int spinner_country_code, String[] countryCode, int[] countryFlag) {
        this.countryFlag = countryFlag;
        this.countryCode = countryCode;
        this.Mycontax = Mycontax;
    }

    @Override
    public int getCount() {
        return countryCode.length;
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
        convertView = LayoutInflater.from(Mycontax).inflate(R.layout.spinner_country_code, null);
        TextView countrycode = convertView.findViewById(R.id.txtCountryCode);
        countrycode.setText(countryCode[position]);
        ImageView imageFlag = convertView.findViewById(R.id.imgcountryFlag);
        imageFlag.setImageResource(countryFlag[position]);
        return convertView;
    }
}
