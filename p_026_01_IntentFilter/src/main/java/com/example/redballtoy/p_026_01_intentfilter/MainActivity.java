package com.example.redballtoy.p_026_01_intentfilter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnShowTime, btnShowDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDate = findViewById(R.id.btn_date);
        btnShowTime = findViewById(R.id.btn_time);

        btnShowDate.setOnClickListener(this);
        btnShowTime.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_date:
                intent = new Intent("com.example.redballtoy.p_026_01_intentfilter.showdate");
                startActivity(intent);
                break;
            case R.id.btn_time:
                intent = new Intent("com.example.redballtoy.p_026_01_intentfilter.showtime");
                startActivity(intent);
                break;
        }

    }
}
