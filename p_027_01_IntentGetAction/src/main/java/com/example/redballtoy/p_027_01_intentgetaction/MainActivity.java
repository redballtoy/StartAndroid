package com.example.redballtoy.p_027_01_intentgetaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btmShowDate = findViewById(R.id.bt_show_date);
        Button btnShowTime = findViewById(R.id.bt_show_time);

        btmShowDate.setOnClickListener(this);
        btnShowTime.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.bt_show_date:
                intent = new Intent(getString(R.string.INTENT_ACTIVITY_SHOW_DATE));
                if (isHasActivity(intent,this)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No activity!", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.bt_show_time:
                intent = new Intent(getString(R.string.INTENT_ACTIVITY_SHOW_TIME));
                if (isHasActivity(intent,this)) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "No activity!", Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }

    private boolean isHasActivity(Intent intent, Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> infos = packageManager.queryIntentActivities(intent, 0);
        if (infos.size() > 0) {
            return true;
        }
        return false;
    }
}