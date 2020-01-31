package com.example.boomdesign;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.boomdesign.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout selectedFirst, selectedSecond, selectThird, selectFourth, selectFifth;
    private boolean isButtonClicked = false;
    private TextView textSelectFirst, textSelectSecond, textSelectThird, textSelectFourth, textSelectFifth;
    private int previousState = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_number);


        selectedFirst = findViewById(R.id.rel_select_first);
        selectedSecond = findViewById(R.id.rel_select_second);
        selectThird = findViewById(R.id.rel_select_third);
        selectFourth = findViewById(R.id.rel_select_fourth);
        selectFifth = findViewById(R.id.rel_select_fifth);


        textSelectFirst = findViewById(R.id.tv_select_first);
        textSelectSecond = findViewById(R.id.tv_select_second);
        textSelectThird = findViewById(R.id.tv_select_third);
        textSelectFourth = findViewById(R.id.tv_select_fourth);
        textSelectFifth = findViewById(R.id.tv_select_fifth);


        textSelectFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonClicked) {
                    selectedFirst.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                } else {
                    selectedFirst.setBackgroundResource(R.drawable.bg_outline_number_active);
                    selectedSecond.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectThird.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectFourth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectFifth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                }
                isButtonClicked = !isButtonClicked;
            }
        });


        textSelectSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonClicked) {
                    selectedSecond.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                } else {
                    selectedFirst.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectedSecond.setBackgroundResource(R.drawable.bg_outline_number_active);
                    selectThird.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectFourth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectFifth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                }
                isButtonClicked = !isButtonClicked;
            }
        });


        textSelectThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonClicked) {
                    selectThird.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                } else {
                    selectedFirst.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectedSecond.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectThird.setBackgroundResource(R.drawable.bg_outline_number_active);
                    selectFourth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectFifth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                }
                isButtonClicked = !isButtonClicked;

            }
        });


        textSelectFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isButtonClicked) {
                    selectFourth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                } else {
                    selectedFirst.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectedSecond.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectThird.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectFourth.setBackgroundResource(R.drawable.bg_outline_number_active);
                    selectFifth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                }
                isButtonClicked = !isButtonClicked;
            }
        });


        textSelectFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isButtonClicked) {
                    selectFifth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                } else {
                    selectedFirst.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectedSecond.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectThird.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectFourth.setBackgroundResource(R.drawable.bg_outline_number_inactive);
                    selectFifth.setBackgroundResource(R.drawable.bg_outline_number_active);
                }
                isButtonClicked = !isButtonClicked;
            }
        });

    }
}
