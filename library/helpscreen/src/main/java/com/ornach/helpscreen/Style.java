package com.ornach.helpscreen;

import android.support.annotation.ColorInt;

public class Style {

    Builder builder;


    private Style(Builder builder) {
        this.builder = builder;
    }

    public static class Builder{

        @ColorInt int backgroundColor;
        int gravity;
        int marginTop;
        int marginLeft;
        int marginRight;
        int marginBottom;
        int paddingTop;
        int paddingLeft;
        int paddingRight;
        int paddingBottom;
        int width;
        int height;

        public Style build(){
            return new Style(this);
        }


        public int getGravity() {
            return gravity;
        }

        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public int getMarginTop() {
            return marginTop;
        }

        public Builder setMarginTop(int marginTop) {
            this.marginTop = marginTop;
            return this;
        }

        public int getMarginLeft() {
            return marginLeft;
        }

        public Builder setMarginLeft(int marginLeft) {
            this.marginLeft = marginLeft;
            return this;
        }

        public int getMarginRight() {
            return marginRight;
        }

        public Builder setMarginRight(int marginRight) {
            this.marginRight = marginRight;
            return this;
        }

        public int getMarginBottom() {
            return marginBottom;
        }

        public Builder setMarginBottom(int marginBottom) {
            this.marginBottom = marginBottom;
            return this;
        }

        public Builder setMargin(int left, int top, int right, int bottom){
            this.marginLeft=left;
            this.marginTop=top;
            this.marginRight=right;
            this.marginBottom=bottom;

            return this;
        }

        public int getPaddingTop() {
            return paddingTop;
        }

        public Builder setPaddingTop(int paddingTop) {
            this.paddingTop = paddingTop;
            return this;
        }

        public int getPaddingLeft() {
            return paddingLeft;
        }

        public Builder setPaddingLeft(int paddingLeft) {
            this.paddingLeft = paddingLeft;
            return this;
        }

        public int getPaddingRight() {
            return paddingRight;
        }

        public Builder setPaddingRight(int paddingRight) {
            this.paddingRight = paddingRight;
            return this;
        }

        public int getPaddingBottom() {
            return paddingBottom;
        }

        public Builder setPaddingBottom(int paddingBottom) {
            this.paddingBottom = paddingBottom;
            return this;
        }

        public Builder setPadding(int left, int top, int right, int bottom){
            this.paddingLeft=left;
            this.paddingTop=top;
            this.paddingRight=right;
            this.paddingBottom=bottom;

            return this;
        }

        public int getWidth() {
            return width;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public int getHeight() {
            return height;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public int getBackgroundColor() {
            return backgroundColor;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }
    }
}
