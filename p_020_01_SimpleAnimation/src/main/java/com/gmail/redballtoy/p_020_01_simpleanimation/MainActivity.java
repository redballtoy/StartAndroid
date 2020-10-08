package com.gmail.redballtoy.p_020_01_simpleanimation;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //для выбора типа анимации используем контекстное меню
    //константы для ID пунктов меню
    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANSLATE_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

    TextView animatedTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatedTv = findViewById(R.id.tv_anim);
        //регистрируем контекстное меню для компонента tv
        //registerForContextMenu(animatedTv);
        //или что тоже самое подключаем слушателя
        //view.setOnCreateContextMenuListener(this);
        animatedTv.setOnCreateContextMenuListener(MainActivity.this);
    }

    //создаем контекстное меню

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        //добавляем пункты
        switch (v.getId()) {
            case R.id.tv_anim:
                menu.add(0, MENU_ALPHA_ID, 0, getString(R.string.context_menu_alpha));
                menu.add(0, MENU_SCALE_ID, 0, getString(R.string.context_menu_scale));
                menu.add(0, MENU_TRANSLATE_ID, 0, getString(R.string.context_menu_translate));
                menu.add(0, MENU_ROTATE_ID, 0, getString(R.string.context_menu_rotate));
                menu.add(0, MENU_COMBO_ID, 0, getString(R.string.context_menu_combo));
        }


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation animation = null;
        switch (item.getItemId()) {
            case MENU_ALPHA_ID:
                //создаем объект анимации из файла anim/myalpha
                animation = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case MENU_SCALE_ID:
                //создаем объект анимации из файла anim/myalpha
                animation = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case MENU_TRANSLATE_ID:
                //создаем объект анимации из файла anim/myalpha
                animation = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            case MENU_ROTATE_ID:
                //создаем объект анимации из файла anim/myalpha
                animation = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case MENU_COMBO_ID:
                //создаем объект анимации из файла anim/myalpha
                animation = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
        }
        //запускаем анимацию для компонента tv_anim
        animatedTv.startAnimation(animation);
        return super.onContextItemSelected(item);
    }
}
