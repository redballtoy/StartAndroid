package com.example.p_014_01_menuadvancedadngroup;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvShowItemInfo;
    CheckBox chbExtendMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShowItemInfo = findViewById(R.id.tv_show_item_info);
        chbExtendMenu = findViewById(R.id.chb_extend_menu1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "add");
        menu.add(0, 2, 0, "edit");
        menu.add(0, 3, 3, "delete");
        menu.add(1, 4, 1, "copy");
        menu.add(1, 5, 2, "paste");
        menu.add(1, 6, 7, "exit");
        menu.add(2, 7, 5, "share");
        menu.add(3, 8, 6, "post");
        menu.add(4, 9, 7, "send");

        return super.onCreateOptionsMenu(menu);
    }

    //update and extende menu


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //if 1 group is visible
        menu.setGroupVisible(1,chbExtendMenu.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        StringBuffer sbItemInfo = new StringBuffer();

        //output info about selected item
        sbItemInfo.append("Item menu info:");
        sbItemInfo.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sbItemInfo.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sbItemInfo.append("\r\n order: " + String.valueOf(item.getOrder()));
        sbItemInfo.append("\r\n title: " + String.valueOf(item.getTitle()));
        tvShowItemInfo.setText(sbItemInfo.toString());

        return super.onOptionsItemSelected(item);
    }
}
