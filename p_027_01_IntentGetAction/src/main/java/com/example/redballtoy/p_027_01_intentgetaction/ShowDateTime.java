package com.example.redballtoy.p_027_01_intentgetaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowDateTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_date_time);

        //получаем Intent который вызвал это активити
        Intent intent = getIntent();
        //читаем из него action
        String action = intent.getAction();

        //задаем форматы и заполняем их в зависимости от содержимого action
        String formatInfo = "";
        String textInfo = "";

        if (action.equals(getString(R.string.INTENT_ACTIVITY_SHOW_DATE))) {
            formatInfo = "dd.MM.yyyy";
            textInfo = "Date: ";
        } else if (action.equals(getString(R.string.INTENT_ACTIVITY_SHOW_TIME))) {
            formatInfo = "HH:mm:ss";
            textInfo = "Time: ";
        }

        //в зависимости от содержимого переменной format
        //получаем дату или время в переменную datetime
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatInfo);
        String datetime = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        TextView tvShowDateTime = (TextView) findViewById(R.id.tv_show_date_time);
        tvShowDateTime.setText(textInfo + datetime);
    }
}