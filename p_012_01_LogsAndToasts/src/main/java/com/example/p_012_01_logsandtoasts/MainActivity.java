package com.example.p_012_01_logsandtoasts;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOut;
    Button btOk;
    Button btCancel;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Find View-elements");
        tvOut = findViewById(R.id.tv_out);
        btOk = findViewById(R.id.bt_ok);
        btCancel = findViewById(R.id.bt_cancel);

        tvOut.setClickable(true);

        Log.d(TAG,"Assign handler to buttons");
        tvOut.setOnClickListener(this);
        btOk.setOnClickListener(this);
        btCancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        //determine id that called handler
        Log.d(TAG,"By id define the button that called this handler");
        switch (view.getId()) {
            case R.id.bt_ok:
                Log.d(TAG,"Pressed button Ок");
                Toast.makeText(this, "Pressed button Ок", Toast.LENGTH_SHORT).show();
                tvOut.setText("Pressed button Ок");
                break;
            case R.id.bt_cancel:
                Toast.makeText(this, "Pressed button Cancel", Toast.LENGTH_SHORT).show();
                Log.d(TAG,"Pressed button Cancel");
                tvOut.setText("Pressed button Cancel");
                break;
            case R.id.tv_out:
                Toast.makeText(this, "Pressed TextView to reset", Toast.LENGTH_SHORT).show();
                Log.d(TAG,"Pressed TextView to reset");
                Toast.makeText(MainActivity.this, "Reset TextView", Toast.LENGTH_SHORT).show();
                tvOut.setText("TextView");
                break;
        }

    }
}

