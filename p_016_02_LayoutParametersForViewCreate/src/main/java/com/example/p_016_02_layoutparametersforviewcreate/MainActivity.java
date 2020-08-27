package com.example.p_016_02_layoutparametersforviewcreate;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    ViewGroup.LayoutParams layoutParams, layoutParamsForViws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //create root layout
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.setBackgroundColor(Color.GRAY);
        //generate LayoutParameters
        layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        //set layout as root
        setContentView(linearLayout, layoutParams);


        //add some components

        //TextView
        //generate LayoutParameters
        LinearLayout.LayoutParams tvLayoutParameneters = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        int marginTv = 16;
        tvLayoutParameneters.setMargins(marginTv, marginTv, marginTv, marginTv);
        TextView textView = new TextView(this);
        textView.setText(R.string.tv_text);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(24);
        //textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        tvLayoutParameneters.gravity = Gravity.TOP|Gravity.RIGHT; //other variant set gravity
        textView.setBackgroundColor(Color.parseColor("#0099cc"));
        textView.setLayoutParams(tvLayoutParameneters);
        linearLayout.addView(textView);

        //Button
        //generate LayoutParameters
        LinearLayout.LayoutParams btLayoutParameneters = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        int marginBt = 32;
        int paddingBtTopBottom = 16;
        int paddingBtLeftRigh = 32;
        //firstvar
        //btLayoutParameneters.setMargins(marginBt, marginBt, marginBt, marginBt);
        //second var
        btLayoutParameneters.leftMargin = 32;
        btLayoutParameneters.topMargin = 100;
        Button button = new Button(this);
        button.setText(R.string.bt_text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(16);
        button.setGravity(Gravity.CENTER);
        button.setBackgroundColor(Color.parseColor("#CDDC39"));
        button.setPadding(paddingBtLeftRigh, paddingBtTopBottom,
                paddingBtLeftRigh, paddingBtTopBottom);
        //button.setLayoutParams(btLayoutParameneters);//first var
        //linearLayout.addView(button); //first var
        /*second var - assign param(btLayoutParameneters) and
        add button to linearLayout*/
        linearLayout.addView(button,btLayoutParameneters);

    }
}
