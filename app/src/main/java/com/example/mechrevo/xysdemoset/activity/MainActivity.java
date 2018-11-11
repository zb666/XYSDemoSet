package com.example.mechrevo.xysdemoset.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mechrevo.xysdemoset.R;
import com.example.mechrevo.xysdemoset.view.StatusChangeView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    StatusChangeView statusChangeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statusChangeView = findViewById(R.id.statusChangeView);
        statusChangeView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        statusChangeView.onHandleText();
    }
}
