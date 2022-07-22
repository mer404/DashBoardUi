package com.example.tourapp;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinnerMoney;
    String[] moneyName = {"US$", "INDIA(INR)", "EURO(EUR)", "JAPAN(JPY)", "CANADIAN DOLLAR(CAD)"};
    int[] moneyImage = {R.drawable.us_dollar, R.drawable.india_money, R.drawable.euro, R.drawable.jpy, R.drawable.cad};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinnerView();
    }

    private void spinnerView() {
        spinnerMoney = findViewById(R.id.spinnerMoney);

        CustomMoneyAdapterClass adapter = new CustomMoneyAdapterClass(this, R.layout.spinner_money_text, moneyName, moneyImage);
        spinnerMoney.setAdapter(adapter);
    }
}