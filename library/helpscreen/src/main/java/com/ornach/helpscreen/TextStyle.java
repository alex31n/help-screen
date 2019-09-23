package com.ornach.helpscreen;

import android.support.annotation.ColorInt;

public class TextStyle {

    Builder builder;

    public enum FontStyle {NORMAL,BOLD}

    private TextStyle(Builder builder) {
        this.builder = builder;
    }

    public static class Builder{

        int textSize;
        FontStyle fontStyle;
        @ColorInt int textColor;
        @ColorInt int backgroundColor;
        int textGravity;
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

        public TextStyle build(){
            return new TextStyle(this);
        }

        public int getTextSize() {
            return textSize;
        }

        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public FontStyle getFontStyle() {
            return fontStyle;
        }

        public Builder setFontStyle(FontStyle fontStyle) {
            this.fontStyle = fontStyle;
            return this;
        }

        public int getTextColor() {
            return textColor;
        }

        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public int getTextGravity() {
            return textGravity;
        }

        public Builder setTextGravity(int textGravity) {
            this.textGravity = textGravity;
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
