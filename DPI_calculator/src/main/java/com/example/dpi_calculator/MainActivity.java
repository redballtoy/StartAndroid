package com.example.dpi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText diagonalScreen;
    private EditText widthScreen;
    private EditText heightScreen;
    private Button calculationBtn;
    private TextView resultTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diagonalScreen = findViewById(R.id.et_diagonal);
        widthScreen = findViewById(R.id.et_width);
        heightScreen = findViewById(R.id.et_height);
        calculationBtn = findViewById(R.id.bt_calculate);
        resultTV = findViewById(R.id.tv_result);


        calculationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double diagonalScr = Double.valueOf(diagonalScreen.getText().toString());
                Toast.makeText(getApplicationContext(),String.valueOf(diagonalScr),Toast.LENGTH_SHORT).show();
                //double widthScr = Double.valueOf(widthScreen.getText().toString());
                //double heightScr = Double.valueOf(heightScreen.getText().toString());
                //double dpi = Math.sqrt((Math.pow(widthScr, 2) + Math.pow(heightScr, 2))/ Math.pow(diagonalScr, 2));


            }
        });


    }
}
