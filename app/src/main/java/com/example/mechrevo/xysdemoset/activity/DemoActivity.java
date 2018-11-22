package com.example.mechrevo.xysdemoset.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mechrevo.xysdemoset.A;
import com.example.mechrevo.xysdemoset.DisplayUtils;
import com.example.mechrevo.xysdemoset.R;
import com.example.mechrevo.xysdemoset.fm.OneFm;
import com.example.mechrevo.xysdemoset.fm.ThreeFm;
import com.example.mechrevo.xysdemoset.fm.TwoFm;
import com.example.mechrevo.xysdemoset.view.LoveLayout;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class DemoActivity extends AppCompatActivity {

    ViewPager mViewPager;
    private LoveLayout loveLayout;

    private LinearLayout linearLayout;
    private TabLayout tabLayout;
    private String[] str = new String[]{"厉害", "哈哈", "地方"};
    private boolean isFirst = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        animA();
        mViewPager = findViewById(R.id.viewpager);
        loveLayout = findViewById(R.id.lllayout);
        tabLayout = findViewById(R.id.tabLayout);

        ViewStub viewStub = findViewById(R.id.viewstub);
        viewStub.inflate();

//        try {
//            Socket mSocket = new Socket("www.baidu.com",443);
//            InputStream inputStream = mSocket.getInputStream();
//
//            Socket socket = SSLSocketFactory.getDefault().createSocket("www.baidu.com", 443);
//            InputStream inputStream1 = socket.getInputStream();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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
        setTabWidth(tabLayout, 100);

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
        linearLayout = findViewById(R.id.llbottom);
        loveLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loveLayout.addLoveView();
            }
        });
        setTabWidth(tabLayout, 50);
    }

    private void animA() {
        final LinearLayout llColorContainer = findViewById(R.id.llColorContainer);

        final LinearLayout llMove = findViewById(R.id.llMove);

        final ImageView ivMove = findViewById(R.id.ivFocus);

        final TextView tvMove = findViewById(R.id.tvFocus);

        ObjectAnimator ivXAnim = ObjectAnimator.ofFloat(ivMove, "scaleX", 0f, 1f);
        ObjectAnimator ivYAnim = ObjectAnimator.ofFloat(ivMove, "scaleY", 0f, 1f);


        ObjectAnimator llMoveX = ObjectAnimator.ofFloat(llMove, "translationX", 0, DisplayUtils.dip2px(this, 15));

        ObjectAnimator translaX = ObjectAnimator.ofFloat(tvMove, "translationX", 0, DisplayUtils.dip2px(this, 28));

        final ObjectAnimator llColorX = ObjectAnimator.ofFloat(llColorContainer, "scaleX", 1f, 0.7f);

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ivXAnim, ivYAnim, translaX, llColorX, llMoveX);
        animatorSet.start();


        ObjectAnimator ivXAnimR = ObjectAnimator.ofFloat(ivMove, "scaleX", 1f, 0f);
        ObjectAnimator ivYAnimR = ObjectAnimator.ofFloat(ivMove, "scaleY", 1f, 0f);

        ObjectAnimator translaXR = ObjectAnimator.ofFloat(tvMove, "translationX", -DisplayUtils.dip2px(this, 10));

        ObjectAnimator llMoveXR = ObjectAnimator.ofFloat(llMove, "translationX", -DisplayUtils.dip2px(this, 15));

//                ObjectAnimator llColorXR = ObjectAnimator.ofFloat(llColorContainer, "translationX", -DisplayUtils.dip2px(v.getContext(),30));
        ObjectAnimator llColorXR = ObjectAnimator.ofFloat(llColorContainer, "scaleX", 1f, 1.425f);

        final AnimatorSet animatorSetR = new AnimatorSet();
        animatorSetR.playTogether(ivXAnimR, ivYAnimR, translaXR, llColorXR, llMoveXR);
        animatorSetR.setDuration(300);

        llColorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedFraction = animation.getAnimatedFraction();
                Log.d("BobX",animatedFraction+"  ");
                if (animatedFraction > 0.5f) {
                    llColorContainer.setBackgroundResource(R.drawable.bg_left);
                }
            }
        });

        llColorXR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedFraction = animation.getAnimatedFraction();
                Log.d("BobX",animatedFraction+"Rever");

                if (animatedFraction< 0.5f) {
                    llColorContainer.setBackgroundResource(R.drawable.bg);
                }
            }
        });


        llColorContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.setDuration(300);
                if (!isFirst) {
                    animatorSet.start();
                } else {
                    animatorSetR.start();
                }
                isFirst = !isFirst;

            }
        });

    }

    public static void setTabWidth(final TabLayout tabLayout, final int padding) {
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
                        params.width = width;
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
