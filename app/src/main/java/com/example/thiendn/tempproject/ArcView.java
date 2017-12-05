package com.example.thiendn.tempproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by thiendn on 10/24/17.
 */

public class ArcView extends View {

    private final Paint mPaint;
    private final RectF mRect;
    private float arcAngle;

    Paint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

    public ArcView(Context context, AttributeSet attrs) {

        super(context, attrs);

        // Set Angle to 0 initially or whatever you want
        arcAngle = 0;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(60);
        mPaint.setColor(Color.RED);
        mRect = new RectF(0, 0, 450, 450);

        mTextPaint.setColor(Color.parseColor("#16a085"));
        mTextPaint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(mRect, 180, arcAngle, false, mPaint);
        canvas.drawText("hehehehe", 0, 40, mTextPaint);
    }

    public float getArcAngle() {
        return arcAngle;
    }

    public void setArcAngle(float arcAngle) {
        this.arcAngle = arcAngle;
    }
}
