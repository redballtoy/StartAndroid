package com.example.p_019_02_simplecalculatorv2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOff, tvMc, tvMplus, tvMminus, tvDel;
    TextView tvLeftBracket, tv7, tv8, tv9, tvDiv;
    TextView tvRightBracket, tv4, tv5, tv6, tvMult;
    TextView tvExp, tv1, tv2, tv3, tvSub;
    TextView tvEqual, tvNull, tvDoubleNull, tvPoint, tvAdd;


    EditText etDiplay;
    StringBuilder sbMemory = new StringBuilder();
    StringBuilder sbOutput = new StringBuilder();

    String expression = null;
    String result = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDiplay = findViewById(R.id.et_display);

        tvOff = findViewById(R.id.tv_ac);
        tvMc = findViewById(R.id.tv_ce);
        tvMplus = findViewById(R.id.tv_m_plus);
        tvMminus = findViewById(R.id.tv_m_minus);
        tvDel = findViewById(R.id.tv_m_del_ch);
        tvOff.setOnClickListener(this);
        tvMc.setOnClickListener(this);
        tvMplus.setOnClickListener(this);
        tvMminus.setOnClickListener(this);
        tvDel.setOnClickListener(this);

        tvLeftBracket = findViewById(R.id.tv_left_scobka);
        tv7 = findViewById(R.id.tv_7);
        tv8 = findViewById(R.id.tv_8);
        tv9 = findViewById(R.id.tv_9);
        tvDiv = findViewById(R.id.tv_div);
        tvLeftBracket.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        tv9.setOnClickListener(this);
        tvDiv.setOnClickListener(this);

        tvRightBracket = findViewById(R.id.tv_righ_skobka);
        tv4 = findViewById(R.id.tv_4);
        tv5 = findViewById(R.id.tv_5);
        tv6 = findViewById(R.id.tv_6);
        tvMult = findViewById(R.id.tv_multi);
        tvRightBracket.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tvMult.setOnClickListener(this);

        tvExp = findViewById(R.id.percent);
        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);
        tv3 = findViewById(R.id.tv_3);
        tvSub = findViewById(R.id.tv_sub);
        tvExp.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tvSub.setOnClickListener(this);

        tvEqual = findViewById(R.id.tv_equally);
        tvNull = findViewById(R.id.tv_0);
        tvDoubleNull = findViewById(R.id.tv_00);
        tvPoint = findViewById(R.id.tv_point);
        tvAdd = findViewById(R.id.tv_add);
        tvEqual.setOnClickListener(this);
        tvNull.setOnClickListener(this);
        tvDoubleNull.setOnClickListener(this);
        tvPoint.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_ac:
                sbMemory.delete(0, sbMemory.length());
                sbOutput.delete(0, sbOutput.length());
                etDiplay.setText(sbOutput.toString());
                break;
            case R.id.tv_ce:
                sbOutput.delete(0, sbOutput.length());
                etDiplay.setText(sbOutput.toString());
                break;
            case R.id.tv_m_plus:
                sbMemory.delete(0, sbMemory.length());
                sbMemory.append(sbOutput.toString());
                break;
            case R.id.tv_m_minus:
                sbOutput.delete(0, sbOutput.length());
                expression = etDiplay.getText().toString() + sbMemory.toString();
                sbOutput.append(expression);
                etDiplay.setText(sbOutput);
                break;

            case R.id.tv_m_del_ch:
                if (sbOutput.length() == 0) break;
                sbOutput.delete(0, sbOutput.length());
                sbOutput.append(etDiplay.getText().toString());
                sbOutput.delete(sbOutput.length() - 1, sbOutput.length());
                etDiplay.setText(sbOutput.toString());
                break;
            case R.id.tv_left_scobka:
                showDigitAtDisplay(R.string.tb_text_left_scoba);
                break;
            case R.id.tv_righ_skobka:
                showDigitAtDisplay(R.string.tb_text_right_scobka);
                break;
            case R.id.tv_1:
                showDigitAtDisplay(R.string.tb_text_1);
                break;
            case R.id.tv_2:
                showDigitAtDisplay(R.string.tb_text_2);
                break;
            case R.id.tv_3:
                showDigitAtDisplay(R.string.tb_text_3);
                break;
            case R.id.tv_4:
                showDigitAtDisplay(R.string.tb_text_4);
                break;
            case R.id.tv_5:
                showDigitAtDisplay(R.string.tb_text_5);
                break;
            case R.id.tv_6:
                showDigitAtDisplay(R.string.tb_text_6);
                break;
            case R.id.tv_7:
                showDigitAtDisplay(R.string.tb_text_7);
                break;
            case R.id.tv_8:
                showDigitAtDisplay(R.string.tb_text_8);
                break;
            case R.id.tv_9:
                showDigitAtDisplay(R.string.tb_text_9);
                break;
            case R.id.tv_0:
                showDigitAtDisplay(R.string.tb_text_0);
                break;
            case R.id.tv_00:
                showDigitAtDisplay(R.string.tb_text_00);
                break;
            case R.id.tv_point:
                showDigitAtDisplay(R.string.tb_text_point);
                break;
            case R.id.tv_add:
                showDigitAtDisplay(R.string.tb_text_add);
                break;
            case R.id.tv_sub:
                showDigitAtDisplay(R.string.tb_text_sub);
                break;
            case R.id.tv_multi:
                showDigitAtDisplay(R.string.tb_text_mult);
                break;
            case R.id.tv_div:
                showDigitAtDisplay(R.string.tb_text_div);
                break;
            case R.id.percent:
                showDigitAtDisplay(R.string.tb_text_perc);
                break;
            case R.id.tv_equally:
                expression = sbOutput.toString();
                try {
                    result = StringExpressToResult(expression);
                } catch (ScriptException e) {
                    etDiplay.setText(getString(R.string.error_exception));
                }
                result = expression + getText(R.string.tb_text_equally) + result;
                etDiplay.setText(result);
                break;

        }

    }


    public String StringExpressToResult(String operation) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        String result;
        try {
            result = String.valueOf(engine.eval(operation));
        } catch (ScriptException e) {
            result = getString(R.string.error_exception);
        }
        return result;
    }

    void showDigitAtDisplay(int idStringButton) {
        sbOutput.append(getString(idStringButton));
        etDiplay.setText(sbOutput.toString());
    }


}
