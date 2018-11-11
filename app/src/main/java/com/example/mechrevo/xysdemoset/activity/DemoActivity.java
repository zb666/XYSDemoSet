package com.example.mechrevo.xysdemoset.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mechrevo.xysdemoset.R;
import com.example.mechrevo.xysdemoset.fm.OneFm;
import com.example.mechrevo.xysdemoset.fm.ThreeFm;
import com.example.mechrevo.xysdemoset.fm.TwoFm;
import com.example.mechrevo.xysdemoset.view.LoveLayout;

public class DemoActivity extends AppCompatActivity {

    ViewPager mViewPager;
    private LoveLayout loveLayout;

    private LinearLayout linearLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mViewPager = findViewById(R.id.viewpager);
        loveLayout = findViewById(R.id.lllayout);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return i == 0 ? new OneFm() : i == 1 ? new TwoFm() : new ThreeFm();
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        linearLayout= findViewById(R.id.llbottom);
        loveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loveLayout.addLoveView();
            }
        });
        loveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loveLayout.addLoveView();
            }
        });
    }
}
