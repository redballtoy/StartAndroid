package com.example.p_015_01_menucontext;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvChangeColor;
    TextView tvChangeTextSize;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvChangeTextSize = findViewById(R.id.tv_text_size);
        tvChangeColor = findViewById(R.id.tv_text_color);

        //register for context menu
        //registerForContextMenu(tvChangeColor);
        //registerForContextMenu(tvChangeTextSize);

        //other variant
        tvChangeColor.setOnCreateContextMenuListener(this);
        tvChangeTextSize.setOnCreateContextMenuListener(this);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.tv_text_color:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                break;
            case R.id.tv_text_size:
                menu.add(0, MENU_SIZE_22, 0, "Size 22");
                menu.add(0, MENU_SIZE_26, 0, "Size 26");
                menu.add(0, MENU_SIZE_30, 0, "Size 30");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_COLOR_RED:
                tvChangeColor.setTextColor(Color.RED);
                tvChangeColor.setText("Text color = red");
                break;
            case MENU_COLOR_GREEN:
                tvChangeColor.setTextColor(Color.GREEN);
                tvChangeColor.setText("Text color = green");
                break;
            case MENU_COLOR_BLUE:
                tvChangeColor.setTextColor(Color.BLUE);
                tvChangeColor.setText("Text color = blue");
                break;
            case MENU_SIZE_22:
                tvChangeTextSize.setTextSize(22);
                tvChangeTextSize.setText("Text size = 22");
                break;
            case MENU_SIZE_26:
                tvChangeTextSize.setTextSize(26);
                tvChangeTextSize.setText("Text size = 26");
                break;
            case MENU_SIZE_30:
                tvChangeTextSize.setTextSize(30);
                tvChangeTextSize.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
    }
}
