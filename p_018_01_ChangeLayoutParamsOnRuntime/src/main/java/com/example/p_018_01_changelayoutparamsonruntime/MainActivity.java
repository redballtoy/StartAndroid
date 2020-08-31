package com.example.p_018_01_changelayoutparamsonruntime;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {

    SeekBar sbChangeWeightButton;
    Button btLeft;
    Button btRight;

    LinearLayout.LayoutParams leftBtnParams;
    LinearLayout.LayoutParams rightBtnParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbChangeWeightButton = findViewById(R.id.sb_changeButton);
        btLeft = findViewById(R.id.bt_left);
        btRight = findViewById(R.id.bt_right);

        sbChangeWeightButton.setOnSeekBarChangeListener(this);

        leftBtnParams = (LinearLayout.LayoutParams) btLeft.getLayoutParams();
        rightBtnParams = (LinearLayout.LayoutParams) btRight.getLayoutParams();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        int leftValue = progress;
        int righValue = seekBar.getMax() - progress;
        //change weight
        leftBtnParams.weight = leftValue;
        rightBtnParams.weight = righValue;
        //output weight value to button's text
        btLeft.setText(String.valueOf(leftValue));
        btRight.setText(String.valueOf(righValue));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
