package com.example.mechrevo.xysdemoset.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.mechrevo.xysdemoset.R;


public class StatusChangeView extends View {

    private Paint mRoundGreenaint, mRoundGrayPaint, mTextPaint;

    private String focusText = "+关注";

    private float mTextStartX;
    private float mTextStartY;
    //文字X起点
    private float mCloneTxtStartX;

    private boolean isOpened;
    private int mTextCurrentValue;
    private float mTextHalfValue = 0.5f;
    private boolean isFirst = true;
    private ValueAnimator mValueAnim;

    private int mAnimDuration = 100;

    public StatusChangeView(Context context) {
        this(context, null);
    }

    public StatusChangeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusChangeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //绿色圆角矩形画笔
        mRoundGreenaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRoundGreenaint.setStrokeWidth(12);
        mRoundGreenaint.setStyle(Paint.Style.FILL);
        mRoundGreenaint.setColor(getResources().getColor(R.color.colorGreenDrop));
        mRoundGreenaint.setStrokeCap(Paint.Cap.ROUND);
        mRoundGreenaint.setStrokeJoin(Paint.Join.ROUND);

        //灰色圆角矩形画笔
        mRoundGrayPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRoundGrayPaint.setStrokeWidth(12);
        mRoundGrayPaint.setStyle(Paint.Style.FILL);
        mRoundGrayPaint.setColor(getResources().getColor(R.color.colorGray));
        mRoundGrayPaint.setStrokeCap(Paint.Cap.ROUND);
        mRoundGrayPaint.setStrokeJoin(Paint.Join.ROUND);

        //文字画笔
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStrokeWidth(12);
        mTextPaint.setTextSize(40);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(getResources().getColor(R.color.colorWhite));
        mTextPaint.setStrokeCap(Paint.Cap.ROUND);
        mTextPaint.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("Bob,", "onMeasure()");//layout
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float measureText = mTextPaint.measureText(focusText);
        mTextStartX = getWidth() / 2 - measureText / 2;
        mCloneTxtStartX = mTextStartX;
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        int dy = (int) ((fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent);
        mTextStartY = getHeight() / 2 + dy;
        if (isFirst) {
            mTextCurrentValue = getLeft();
            isFirst = false;
        }
//        Log.d("Bob,", "触发了onSizeChanged");
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLeftTxt(canvas);
    }

    private void drawLeftTxt(Canvas canvas) {
        canvas.drawText(focusText, mTextStartX, mTextStartY, mTextPaint);
    }

    /**
     * 处理点击事件
     */
    public void onHandleText() {
        mValueAnim = ValueAnimator.ofInt(isOpened ? 0 : mTextCurrentValue, isOpened ? mTextCurrentValue : 0);
        mValueAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int fraction = (int) animation.getAnimatedFraction();
                int curValue = 0;
                curValue = (int) animation.getAnimatedValue();
                drawBackGround(fraction);
                layout(curValue, getTop(), getRight(), getBottom());
//                Log.d("Bob", getLeft() + "" + isOpened);
                postInvalidate();
            }
        });
        mValueAnim.setDuration(mAnimDuration);
        mValueAnim.start();
        isOpened = !isOpened;
    }

    public StatusChangeView setDuration(int duration) {
        this.mAnimDuration = duration;
        return this;
    }

    //从服务器拉去的时候设置初始化的状态
    public void init(boolean isOpened) {
        this.isOpened = isOpened;
        onHandleText();
    }

    //获取当前开关的状态 表示是否关注的状态
    public boolean getCurrentValue() {
        return isOpened;
    }

    /**
     * 绘制切换时候的背景颜色
     *
     * @param fraction
     */
    private void drawBackGround(int fraction) {
        if (fraction > mTextHalfValue) {
            setBackgroundResource(isOpened ? R.drawable.bg_ovl: R.drawable.bg_ovl_gray);
        } else {
            setBackgroundResource(isOpened ? R.drawable.bg_ovl_gray : R.drawable.bg_ovl);
        }
    }

    private float getCurrentTextX(float fraction) {
        if (isOpened) {
            mTextStartX = fraction * mCloneTxtStartX;
        } else {
            mTextStartX = mCloneTxtStartX - fraction * mCloneTxtStartX;
        }
        return mTextStartX;
    }


    public void recycle() {
        if (mValueAnim != null && mValueAnim.isRunning()) {
            mValueAnim.cancel();
        }
    }
}
