package com.example.redballtoy.p_028__01_intenyextras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//transfer data from one activity to other by extras intent
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inputFirstName;
    EditText inputLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstName = findViewById(R.id.et_input_name);
        inputLastName = findViewById(R.id.et_input_last_name);

        Button btSubmit = findViewById(R.id.bt_submit);
        btSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (!inputFirstName.getText().toString().isEmpty() &&
                !inputLastName.getText().toString().isEmpty()) {
            Intent intent = new Intent(this, ViewActivity.class);
            intent.putExtra("fname", inputFirstName.getText().toString());
            intent.putExtra("lname", inputLastName.getText().toString());
            startActivity(intent);
        }else {
            Toast.makeText(this, "Names should be not null", Toast.LENGTH_SHORT).show();
        }
    }
}