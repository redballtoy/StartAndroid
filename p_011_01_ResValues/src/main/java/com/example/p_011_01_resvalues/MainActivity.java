package com.example.p_011_01_resvalues;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout llBottom;
    Button btnBottom;
    TextView tvBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llBottom = findViewById(R.id.ll_bottom);
        btnBottom = findViewById(R.id.btn_bottom);
        tvBottom = findViewById(R.id.tv_bottom);

        llBottom.setBackgroundColor(getResources().getColor(R.color.llBottomColor));
        btnBottom.setText(R.string.btBottomText);

        String textFromR = getResources().getString(R.string.btTopText);
        tvBottom.setText(textFromR);

    }
}
