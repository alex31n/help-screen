package com.ornach.helpscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.support.annotation.ColorInt;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HelpScreenView extends View {

    Bitmap bm;
    Canvas cv;
    Paint paint;
    //    Paint shadowPaint;

    private int radius;
    private int centerY;
    private int centerX;

    @ColorInt
    private int backgroundColor = 0x00000000;

    @ColorInt
    private int borderColor = 0x00000000;

    private int borderSize = 0;

    private List<Shader> shaders = new ArrayList<>();


    public HelpScreenView(Context context) {
        super(context);
        Init();
    }

    public HelpScreenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Init();
    }

    public HelpScreenView(Context context, AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init();
    }

    private void Init() {

        paint = new Paint();
        paint.setAntiAlias(true);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        if (w != oldw || h != oldh) {
            bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            cv = new Canvas(bm);
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(backgroundColor);

        for (Shader shader : shaders) {

            float shaderPrtge = 0.7f;
            float innerRadius = shader.getRadius()*shaderPrtge;
            paint.reset();
            paint.setColor(shader.getColor());
            paint.setAlpha(200);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(centerX, centerY, innerRadius, paint);

            int bgColor = ColorUtils.setAlphaComponent(backgroundColor, 10);
            int shaderColor = ColorUtils.setAlphaComponent(shader.getColor(), 150);

            paint.reset();
            paint.setColor(backgroundColor);
            paint.setStyle(Paint.Style.FILL);
            float[] stopColors = {0, shaderPrtge, shaderPrtge, 1};
            int[] shadeColors = {Color.TRANSPARENT, Color.TRANSPARENT, shaderColor, bgColor};
            paint.setShader(new RadialGradient(centerX, centerY,
                    shader.getRadius(), shadeColors, stopColors, android.graphics.Shader.TileMode.CLAMP));
            canvas.drawCircle(centerX, centerY, shader.getRadius(), paint);



        }

//        canvas.drawBitmap(bm, 0, 0, null);

        if (borderSize > 0) {
            paint.reset();
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(borderColor);
            paint.setStrokeWidth(borderSize);
            canvas.drawCircle(centerX, centerY, radius, paint);
        }

        paint.reset();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawCircle(centerX, centerY, radius, paint);

        super.onDraw(canvas);
    }


    public void setRadius(int radius) {
        this.radius = radius;
        invalidate();
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
        invalidate();
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
        invalidate();
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        invalidate();
    }

    public void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        invalidate();
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        invalidate();
    }

    public void setShaders(List<Shader> shaders) {
        this.shaders = shaders;
        invalidate();
    }
}