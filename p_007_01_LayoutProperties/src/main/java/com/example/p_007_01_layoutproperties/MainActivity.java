package com.example.p_007_01_layoutproperties;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnFrameLayout;
    Button btnTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFrameLayout = findViewById(R.id.bt_frame_layout);
        btnTableLayout = findViewById(R.id.bt_table_layout);

        btnFrameLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFrame = new Intent(MainActivity.this, FrameLayoutActivity.class);
                startActivity(intentFrame);
            }
        });

        btnTableLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTable = new Intent(MainActivity.this, TableLayoutActivity.class);
                startActivity(intentTable);
            }
        });



    }
}
