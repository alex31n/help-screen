package com.ornach.helpscreen;

import android.support.annotation.ColorInt;

public class Shader {

    private @ColorInt int color;
    private int radius;


    public Shader(int color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
