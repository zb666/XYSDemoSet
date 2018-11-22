package com.example.mechrevo.xysdemoset;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SwitchView extends LinearLayout {

    private boolean isFirst = true;

    public SwitchView(Context context) {
        this(context, null);
    }

    public SwitchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SwitchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(getContext()).inflate(R.layout.switchfocus, this);
        init();
    }

    private void init() {
        final LinearLayout llColorContainer = findViewById(R.id.llColorContainer);

        final LinearLayout llMove = findViewById(R.id.llMove);

        final ImageView ivMove = findViewById(R.id.ivFocus);

        final TextView tvMove = findViewById(R.id.tvFocus);

        ObjectAnimator ivXAnim = ObjectAnimator.ofFloat(ivMove, "scaleX", 0f, 1f);
        ObjectAnimator ivYAnim = ObjectAnimator.ofFloat(ivMove, "scaleY", 0f, 1f);

        ObjectAnimator llMoveX = ObjectAnimator.ofFloat(llMove, "translationX", 0, DisplayUtils.dip2px(getContext(), 15));

        ObjectAnimator translaX = ObjectAnimator.ofFloat(tvMove, "translationX", 0, DisplayUtils.dip2px(getContext(), 28));

        final ObjectAnimator llColorX = ObjectAnimator.ofFloat(llColorContainer, "scaleX", 1f, 0.7f);

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ivXAnim, ivYAnim,llMoveX);
        animatorSet.start();


        ObjectAnimator ivXAnimR = ObjectAnimator.ofFloat(ivMove, "scaleX", 1f, 0f);
        ObjectAnimator ivYAnimR = ObjectAnimator.ofFloat(ivMove, "scaleY", 1f, 0f);

        ObjectAnimator translaXR = ObjectAnimator.ofFloat(tvMove, "translationX", -DisplayUtils.dip2px(getContext(), 10));

        ObjectAnimator llMoveXR = ObjectAnimator.ofFloat(llMove, "translationX", -DisplayUtils.dip2px(getContext(), 15));

//                ObjectAnimator llColorXR = ObjectAnimator.ofFloat(llColorContainer, "translationX", -DisplayUtils.dip2px(v.getContext(),30));
        ObjectAnimator llColorXR = ObjectAnimator.ofFloat(llColorContainer, "scaleX", 1f, 1.425f);

        final AnimatorSet animatorSetR = new AnimatorSet();
        animatorSetR.playTogether(ivXAnimR, ivYAnimR, translaXR, llColorXR, llMoveXR);
        animatorSetR.setDuration(300);

        llColorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedFraction = animation.getAnimatedFraction();
                Log.d("BobX", animatedFraction + "  ");
                if (animatedFraction > 0.5f) {
                    llColorContainer.setBackgroundResource(R.drawable.bg_left);
                }
            }
        });

        llColorXR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedFraction = animation.getAnimatedFraction();

                if (animatedFraction < 0.5f) {
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
                   // animatorSetR.start();
                }
                isFirst = !isFirst;

            }
        });

    }


}
