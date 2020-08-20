package com.example.p_013_01_menusimplecreate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("menu_01");
        menu.add("menu_02");
        menu.add("menu_03");
        menu.add("menu_04");
        menu.add("menu_05");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        String itemTitle = item.getTitle().toString();
        Toast.makeText(this, "Id= " + itemId + "\nTitle= " + itemTitle, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
