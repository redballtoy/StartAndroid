package com.example.p_016_01_layoutdynamiccreate;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;
    final int MENU_COLOR_GRAY = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(this);

        //set vertical orietation
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.GRAY);

        //create LayoutParam
        LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        setContentView(linearLayout, linLayoutParam);

        //change Layout color via Context Menu
        registerForContextMenu(linearLayout);
    }

    //create context menu for linear layout
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, MENU_COLOR_RED, 0, "Red");
        menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
        menu.add(0, MENU_COLOR_GREEN, 0, "Green");
        menu.add(0, MENU_COLOR_GRAY, 0, "Grey");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_COLOR_RED:
                linearLayout.setBackgroundColor(Color.RED);
                break;
            case MENU_COLOR_BLUE:
                linearLayout.setBackgroundColor(Color.BLUE);
                break;
            case MENU_COLOR_GREEN:
                linearLayout.setBackgroundColor(Color.GREEN);
                break;
            case MENU_COLOR_GRAY:
                linearLayout.setBackgroundColor(Color.GRAY);
                break;
        }
        return super.onContextItemSelected(item);
    }
}


