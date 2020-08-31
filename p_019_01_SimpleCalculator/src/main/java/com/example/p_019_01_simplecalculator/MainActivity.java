package com.example.p_019_01_simplecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNumLeft;
    EditText etNumRight;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    //menu
    final int MENU_RESET_ID = 1;
    final int MENU_QUICK_ID = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumLeft = findViewById(R.id.et_number1);
        etNumRight = findViewById(R.id.et_number2);

        btnAdd = findViewById(R.id.bt_add);
        btnDiv = findViewById(R.id.bt_div);
        btnSub = findViewById(R.id.bt_minus);
        btnMult = findViewById(R.id.bt_mult);

        tvResult = findViewById(R.id.tv_show_result);

        btnMult.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        //cchecking that the input field is not empty
        if (TextUtils.isEmpty(etNumLeft.getText().toString())
                || TextUtils.isEmpty(etNumRight.getText().toString())) {
            tvResult.setText(getString(R.string.not_null_message));
            return;
        }

        num1 = Float.parseFloat(etNumLeft.getText().toString());
        num2 = Float.parseFloat(etNumRight.getText().toString());

        switch (view.getId()) {
            case R.id.bt_add:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.bt_minus:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.bt_div:
                oper = "/";
                if (num2 == 0) {
                    tvResult.setText(getString(R.string.error_divide_by_nul));
                    return;
                }
                result = num1 / num2;
                break;
            case R.id.bt_mult:
                oper = "*";
                result = num1 * num2;
                break;
        }
        //form the output line
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, getString(R.string.menu_clear));
        menu.add(0, MENU_QUICK_ID, 0, getString(R.string.menu_quit));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                //reset field
                etNumRight.setText("");
                etNumLeft.setText("");
                tvResult.setText("");
                break;
            case MENU_QUICK_ID:
                //exit from app
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
