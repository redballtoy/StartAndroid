package com.example.redballtoy.p_141_01_canvasview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //The DrawView component that is passed to setContentView will take up the entire
        //activity space
        setContentView(new DrawView(this));
    }
}
