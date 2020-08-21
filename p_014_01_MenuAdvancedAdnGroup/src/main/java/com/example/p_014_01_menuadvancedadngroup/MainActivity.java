package com.example.p_014_01_menuadvancedadngroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvShowItemInfo;
    CheckBox chbExtendMenu1;
    CheckBox chbExtendMenu2;
    Button btnStartXMLmenuActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShowItemInfo = findViewById(R.id.tv_show_item_info);
        chbExtendMenu1 = findViewById(R.id.chb_extend_menu1);
        chbExtendMenu2 = findViewById(R.id.chb_extend_menu2);
        btnStartXMLmenuActivity = findViewById(R.id.bt_start_activity_with_xml_menu);


        btnStartXMLmenuActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, XML_MenuCreateActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "add0");
        menu.add(0, 2, 0, "edit0");
        menu.add(0, 3, 3, "delete0");
        menu.add(1, 4, 1, "copy1");
        menu.add(1, 5, 2, "paste1");
        menu.add(1, 6, 7, "exit1");
        menu.add(2, 7, 5, "share2");
        menu.add(2, 8, 6, "post2");
        menu.add(2, 9, 7, "send2");

        return super.onCreateOptionsMenu(menu);
    }

    //update and extend menu
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //if 1 group is visible
        menu.setGroupVisible(1, chbExtendMenu1.isChecked());
        //if 2 group is visible
        menu.setGroupVisible(2, chbExtendMenu2.isChecked());
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
