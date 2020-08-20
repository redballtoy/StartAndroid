package com.example.p_009_01_onclickbuttons;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        btOk.setOnClickListener(oclBtOk);

        //second var
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOut.setText(R.string.press_cancel_button_message);
            }
        });

        tvOut.setClickable(true);
        tvOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.toast_reset_message, Toast.LENGTH_SHORT).show();
                tvOut.setText(R.string.text_view_default_message);
            }
        });

    }

    //first var
    View.OnClickListener oclBtOk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tvOut.setText(R.string.press_ok_button_message);
        }
    };

}
