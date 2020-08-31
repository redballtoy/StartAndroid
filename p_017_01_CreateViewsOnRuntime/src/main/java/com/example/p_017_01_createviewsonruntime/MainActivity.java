package com.example.p_017_01_createviewsonruntime;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llOutput;
    RadioGroup rgGravity;
    EditText etInsertName;
    Button btnCreate;
    Button btnClear;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llOutput = findViewById(R.id.ll_output);
        etInsertName = findViewById(R.id.et_name_views_insert);
        btnClear = findViewById(R.id.bt_clear);
        btnCreate = findViewById(R.id.bt_create);
        rgGravity = findViewById(R.id.rg_Gravity);

        btnCreate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_create:
                //create LayotParams with width and height by default
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                        (wrapContent, wrapContent);
                //variable to store the aligment value
                //let it be LEFT by default
                int btnGravity = Gravity.LEFT;
                //determine which RarioButton is "checked" and
                //fill btnGravity accordintly
                switch (rgGravity.getCheckedRadioButtonId()) {
                    case R.id.rb_left:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rb_center:
                        btnGravity = Gravity.CENTER;
                        break;
                    case R.id.rb_right:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                //transfer the resulting aligment value to LayoutParams
                layoutParams.gravity = btnGravity;

                //create Button with text and add to LinearLayout
                Button btnNext = new Button(this);
                btnNext.setText(etInsertName.getText().toString());
                llOutput.addView(btnNext, layoutParams);
                break;
            case (R.id.bt_clear):
                llOutput.removeAllViews();
                Toast.makeText(this, "All Views deleted", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
