package com.example.p_010_01_listenerusingvar;

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

        tvOut.setClickable(true);

        tvOut.setOnClickListener(onClickListener);
        btOk.setOnClickListener(onClickListener);
        btCancel.setOnClickListener(onClickListener);
    }

    //create listener
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //determine id that called handler
            switch (view.getId()) {
                case R.id.bt_Ok:
                    tvOut.setText("Pressed button Ок");
                    break;
                case R.id.bt_cancel:
                    tvOut.setText("Pressed button Cancel");
                    break;
                case R.id.tv_Out:
                    Toast.makeText(MainActivity.this, "Reset TextView", Toast.LENGTH_SHORT).show();
                    tvOut.setText("TextView");
                    break;
            }

        }
    };
}
