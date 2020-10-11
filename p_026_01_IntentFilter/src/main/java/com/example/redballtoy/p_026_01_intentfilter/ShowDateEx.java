package com.example.redballtoy.p_026_01_intentfilter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowDateEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_date);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        String date = sdf.format(new Date(System.currentTimeMillis()));

        TextView tvShowDate = findViewById(R.id.tv_show_date);
        tvShowDate.setText(date);

    }
}