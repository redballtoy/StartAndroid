package com.example.p_009_01_onclickbuttons;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvOut;
    Button btOk;
    Button btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = findViewById(R.id.tv_Out);
        btOk = findViewById(R.id.bt_Ok);
        btCancel = findViewById(R.id.bt_cancel);




    }
}
