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
                double diagonalScr = 0;
                double widthScr = 0;
                double heightScr = 0;
                int dpi = 0;

                if (diagonalScreen.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.enterValue, Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    diagonalScr = Double.valueOf(diagonalScreen.getText().toString());
                }
                if (widthScreen.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.enterValue, Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    widthScr = Double.valueOf(widthScreen.getText().toString());
                }
                if (heightScreen.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), R.string.enterValue, Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    heightScr= Double.valueOf(heightScreen.getText().toString());
                }

                //Toast.makeText(getApplicationContext(),String.valueOf(diagonalScr),Toast.LENGTH_SHORT).show();
                //double widthScr = Double.valueOf(widthScreen.getText().toString());
                //double heightScr = Double.valueOf(heightScreen.getText().toString());
                dpi = (int)Math.round(Math.sqrt((Math.pow(widthScr, 2) + Math.pow(heightScr, 2))/ Math.pow(diagonalScr, 2)));
                resultTV.setText(String.valueOf(dpi));
            }
        });


    }
}
