package com.example.p_014_01_menuadvancedadngroup;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class XML_MenuCreateActivity extends AppCompatActivity {

    CheckBox chbExtendMenu_xml_0;
    CheckBox chbExtendMenu_xml_1;
    CheckBox chbExtendMenu_xml_2;
    TextView tvShowInfoMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml__menu_create);

        chbExtendMenu_xml_0 = findViewById(R.id.ch_showGroup0);
        chbExtendMenu_xml_1 = findViewById(R.id.ch_showGroup1);
        chbExtendMenu_xml_2 = findViewById(R.id.ch_showGroup2);
        tvShowInfoMenuItem = findViewById(R.id.tv_show_info_menu_item_xml);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    //update and extend menu
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //if 0 group is visible
        menu.setGroupVisible(2131165279, chbExtendMenu_xml_0.isChecked());
        //if 1 group is visible
        menu.setGroupVisible(2131165280, chbExtendMenu_xml_1.isChecked());
        //if 2 group is visible
        menu.setGroupVisible(2131165281, chbExtendMenu_xml_2.isChecked());

        tvShowInfoMenuItem
                .setText("\r\n chbExtendMenu_xml_0 = " + chbExtendMenu_xml_0.isChecked()
                + "\r\n chbExtendMenu_xml_1 = " + chbExtendMenu_xml_1.isChecked()
                + "\r\n chbExtendMenu_xml_2 = " + chbExtendMenu_xml_2.isChecked());

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        StringBuffer sbItemInfo = new StringBuffer();

        //output info about selected item
        sbItemInfo.append("Show Information about item menu:");
        sbItemInfo.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sbItemInfo.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sbItemInfo.append("\r\n order: " + String.valueOf(item.getOrder()));
        sbItemInfo.append("\r\n title: " + String.valueOf(item.getTitle()));
        tvShowInfoMenuItem.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        tvShowInfoMenuItem.setText(sbItemInfo.toString());

        return super.onOptionsItemSelected(item);
    }

}