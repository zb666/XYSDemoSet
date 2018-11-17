package com.example.mechrevo.xysdemoset.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mechrevo.xysdemoset.A;
import com.example.mechrevo.xysdemoset.R;
import com.example.mechrevo.xysdemoset.fm.OneFm;
import com.example.mechrevo.xysdemoset.fm.ThreeFm;
import com.example.mechrevo.xysdemoset.fm.TwoFm;
import com.example.mechrevo.xysdemoset.view.LoveLayout;

import java.lang.reflect.Field;

public class DemoActivity extends AppCompatActivity {

    ViewPager mViewPager;
    private LoveLayout loveLayout;

    

    private LinearLayout linearLayout;
    private TabLayout tabLayout;
    private String [] str = new String[]{"厉害","哈哈","地方"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mViewPager = findViewById(R.id.viewpager);
        loveLayout = findViewById(R.id.lllayout);
        tabLayout = findViewById(R.id.tabLayout);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return i == 0 ? new OneFm() : i == 1 ? new TwoFm() : new ThreeFm();
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return str[position];
            }
        });
        tabLayout.setupWithViewPager(mViewPager);
        setTabWidth(tabLayout,100);

        A a = new A();
        A aa = new A();

        Class<? extends A> aClass = a.getClass();

        Class<? extends A> aClass1 = aa.getClass();

        boolean b = aClass == aClass1;

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                try {
                    Field fieldView = tab.getClass().getDeclaredField("view");
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        linearLayout= findViewById(R.id.llbottom);
        loveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loveLayout.addLoveView();
            }
        });
        setTabWidth(tabLayout,50);
    }

    public static void setTabWidth(final TabLayout tabLayout, final int padding){
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);
                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距 注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = padding;
                        params.rightMargin = padding;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

    }



}
