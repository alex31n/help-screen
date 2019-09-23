package com.ornach.helpscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HelpScreen {

    protected Builder builder;
    protected OnHelpScreenListener onHelpScreenListener;

    private HelpScreen(Builder builder) {
        this.builder = builder;
    }

    public void show() {
        if (builder.getActivity() != null) {
            HelpScreenActivity.setHelpScreen(this);
            builder.getActivity().startActivity(new Intent(builder.getActivity(), HelpScreenActivity.class));
        }
    }


    public void dismiss() {
        HelpScreenActivity.dismiss();
    }

    public void setOnHelpScreenListener(@Nullable OnHelpScreenListener l) {
        this.onHelpScreenListener = l;
    }


    public static class Builder {
        Activity activity;
        View customView = null;
        int radius;
        int cx;
        int cy;
        int backgroundColor = 0xDD000000;
        int borderColor = 0x00000000;
        int borderSize = 0;
        private boolean cancelable = true;
        private boolean tapToDismiss = true;

        HelpText title;
        HelpText message;

        List<Shader> shaders = new ArrayList<>();

        Style style=null;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public HelpScreen build() {
            return new HelpScreen(this);
        }

        public Builder setCustomView(View customView) {
            this.customView = customView;
            return this;
        }

        public Builder setFocusRadius(int radius) {
            this.radius = radius;
            return this;
        }

        public Builder setFocusCx(int cx) {
            this.cx = cx;
            return this;
        }

        public Builder setFocusCy(int cy) {
            this.cy = cy;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Context getActivity() {
            return activity;
        }

        public View getCustomView() {
            return customView;
        }

        public int getRadius() {
            return radius;
        }

        public int getCx() {
            return cx;
        }

        public int getCy() {
            return cy;
        }

        public int getBackgroundColor() {
            return backgroundColor;
        }

        public int getBorderColor() {
            return borderColor;
        }

        public Builder setBorderColor(int borderColor) {
            this.borderColor = borderColor;
            return this;
        }

        public int getBorderSize() {
            return borderSize;
        }

        public Builder setBorderSize(int borderSize) {
            this.borderSize = borderSize;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "activity=" + activity +
                    ", customView=" + customView +
                    ", radius=" + radius +
                    ", cx=" + cx +
                    ", cy=" + cy +
                    ", backgroundColor=" + backgroundColor +
                    ", borderColor=" + borderColor +
                    ", borderSize=" + borderSize +
                    '}';
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public boolean isCancelable() {
            return cancelable;
        }

        public Builder setTapToDismiss(boolean tapToDismiss) {
            this.tapToDismiss = tapToDismiss;
            return this;
        }

        public boolean isTapToDismiss() {
            return tapToDismiss;
        }

        public Builder setTitle(HelpText title) {
            this.title = title;
            return this;
        }
        public Builder setMessage(HelpText message) {
            this.message = message;
            return this;
        }


        public Builder addShader(Shader shader) {
            this.shaders.add(shader);
            return this;
        }

        public Builder clearShader(){
            this.shaders.clear();
            return this;
        }

        public List<Shader> getShaders() {
            return shaders;
        }

        public Style getStyle() {
            return style;
        }

        public Builder setStyle(Style style) {
            this.style = style;
            return this;
        }
    }
}
