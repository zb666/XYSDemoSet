package com.example.mechrevo.xysdemoset.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.mechrevo.xysdemoset.R;

public class StatusChangeView extends View {

    private Paint mRoundGreenaint, mRoundGrayPaint, mTextPaint;

    private int mWidth;
    private int mHeight;

    private String focusText = "+关注";

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
        mRoundGrayPaint.setStrokeWidth(20);
        mRoundGrayPaint.setStyle(Paint.Style.FILL);
        mRoundGrayPaint.setColor(getResources().getColor(R.color.colorGray));
        mRoundGrayPaint.setStrokeCap(Paint.Cap.ROUND);
        mRoundGrayPaint.setStrokeJoin(Paint.Join.ROUND);

        //文字画笔
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStrokeWidth(12);
        mTextPaint.setTextSize(12);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(getResources().getColor(R.color.colorWhite));
        mTextPaint.setStrokeCap(Paint.Cap.ROUND);
        mTextPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mHeight = getHeight();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLeftTxt(canvas);
    }

    private void drawLeftTxt(Canvas canvas) {
        float textWidth = mTextPaint.measureText(focusText);
        float Textx = getWidth() / 2 - textWidth / 2;
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        int dy = (int) ((fontMetrics.descent - fontMetrics.ascent) / 2 - fontMetrics.descent);
        float Texty = getHeight() / 2 + dy;
        canvas.drawText(focusText, Textx, Texty, mTextPaint);
    }
}
