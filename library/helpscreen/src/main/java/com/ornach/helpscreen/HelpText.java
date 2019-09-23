package com.ornach.helpscreen;

public class HelpText{

    String text="";
    TextStyle style = new TextStyle.Builder().build();

    public HelpText() {
    }

    public HelpText(String text) {
        this.text = text;
    }

    public HelpText(String text, TextStyle style) {
        this.text = text;
        this.style = style;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextStyle getStyle() {
        return style;
    }

    public void setStyle(TextStyle style) {
        this.style = style;
    }
}
