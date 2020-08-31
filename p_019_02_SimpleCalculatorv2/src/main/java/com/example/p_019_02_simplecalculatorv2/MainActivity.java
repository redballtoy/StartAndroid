package com.example.p_019_02_simplecalculatorv2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvMplus, tvMc;
    EditText etDiplay;

    final int MENU_EXIT_ITEM_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMplus = findViewById(R.id.tv_m_plus);
        tvMplus.setOnClickListener(this);
        tvMc = findViewById(R.id.tv_m_c);
        tvMc.setOnClickListener(this);


        etDiplay = findViewById(R.id.et_display);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_m_plus:
                tvMplus.setBackgroundResource(R.drawable.ic_calcbutton);
                sleepButton(0.5f);
                //tvMplus.setBackground(getDrawable(R.drawable.ic_calcbutton_2));
                etDiplay.setText("M+");
                tvMplus.setBackgroundResource(R.drawable.ic_calcbutton_2);
                break;
            case R.id.tv_m_c:
                tvMplus.setBackgroundResource(R.drawable.ic_calcbutton);
                sleepButton(0.5f);
                //tvMplus.setBackground(getDrawable(R.drawable.ic_calcbutton_2));
                etDiplay.setText("");
                tvMplus.setBackgroundResource(R.drawable.ic_calcbutton_2);
                break;
        }

    }

    private void sleepButton(float seconds) {
        try {
            //sleeping tread
            Thread.sleep(Long.parseLong(String.valueOf(seconds*1000)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,MENU_EXIT_ITEM_ID,0,"Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_EXIT_ITEM_ID:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
