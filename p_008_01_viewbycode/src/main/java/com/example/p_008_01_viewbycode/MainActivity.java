package com.example.p_008_01_viewbycode;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = findViewById(R.id.tv_mytext);
        myTextView.setText(R.string.my_text_view);

        Button myButton = findViewById(R.id.bt_mybtn);
        myButton.setText(R.string.my_btn_name);
        myButton.setEnabled(false);

        CheckBox myCheckBox = findViewById(R.id.my_checkbox);
        myCheckBox.setText(R.string.my_likely_checkbox);
        myCheckBox.setChecked(true);

    }
}
