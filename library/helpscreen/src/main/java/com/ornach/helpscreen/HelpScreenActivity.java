package com.ornach.helpscreen;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelpScreenActivity extends AppCompatActivity {

    private static final String TAG = "HelpScreenActivity";

    private static HelpScreen helpScreen;
    private static HelpScreenActivity activity;

    FrameLayout container;
    HelpScreenView helpScreenView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_help_screen);
        activity = this;

        container = findViewById(R.id.container);

        /*if (helpScreen.getView() != null)
            container.addView(helpScreen.getView());

        Log.e(TAG, "onCreate: "+(helpScreen.getView() != null) );
*/
        helpScreenView = new HelpScreenView(this);
        initView();

        if (helpScreen.onHelpScreenListener != null) {
            helpScreen.onHelpScreenListener.onShow();
        }

        if (helpScreen.builder.isTapToDismiss()) {
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }


        if (helpScreen.builder.customView == null) {
            Log.e(TAG, "onCreate: not null");
            generateView();
        }
    }


    private void initView() {
        if (helpScreen == null || helpScreen.builder == null) {
            throw new RuntimeException("You must be initialize this through HelpScreen.");
        }

        if (helpScreen.builder.cx > 0)
            helpScreenView.setCenterX(helpScreen.builder.cx);
        if (helpScreen.builder.cy > 0)
            helpScreenView.setCenterY(helpScreen.builder.cy);
        if (helpScreen.builder.radius > 0)
            helpScreenView.setRadius(helpScreen.builder.radius);
        if (helpScreen.builder.backgroundColor != 0)
            helpScreenView.setBackgroundColor(helpScreen.builder.backgroundColor);
        if (helpScreen.builder.borderColor != 0)
            helpScreenView.setBorderColor(helpScreen.builder.borderColor);
        if (helpScreen.builder.borderSize > 0)
            helpScreenView.setBorderSize(helpScreen.builder.borderSize);

        container.addView(helpScreenView);

        if (helpScreen.builder.customView != null) {
            if (helpScreen.builder.customView.getParent() != null) {
                ((ViewGroup) helpScreen.builder.customView.getParent())
                        .removeView(helpScreen.builder.customView);
            }
            container.addView(helpScreen.builder.customView);
        }


        if (helpScreen.builder.shaders.size() > 0) {
            helpScreenView.setShaders(helpScreen.builder.getShaders());
        }
    }

    public static void setHelpScreen(HelpScreen helpScreen) {
        HelpScreenActivity.helpScreen = helpScreen;
    }


    @Override
    public void onBackPressed() {
        if (helpScreen.builder.isCancelable()) {
            // super.onBackPressed();
            dismiss();
        }


    }

    public static void dismiss() {
        activity.finish();
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        if (helpScreen.onHelpScreenListener != null) {
            helpScreen.onHelpScreenListener.onDismiss();
        }
    }

    private void generateView() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_content, null);
        container.addView(view);

        updateContentPanelView(view);

        // update title textview
        generateTitleView(view);

        // update message textview
        generateMessageView(view);

    }

    private void updateContentPanelView(View view) {
        LinearLayout content = view.findViewById(R.id.contentPanel);
        if (helpScreen.builder.style != null) {
            Style style = helpScreen.builder.style;

            if (style.builder.getBackgroundColor() != 0)
                content.setBackgroundColor(style.builder.getBackgroundColor());

            if (style.builder.getGravity() != 0)
                content.setGravity(style.builder.getGravity());

            // padding
            content.setPadding(style.builder.getPaddingLeft(), style.builder.getPaddingTop(), style.builder.getPaddingRight(), style.builder.getPaddingBottom());

            // margin
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) content.getLayoutParams();
            if (style.builder.width > 0) params.width = style.builder.width;
            if (style.builder.height > 0) params.height = style.builder.height;
            params.setMargins(
                    style.builder.getMarginLeft() > 0 ? style.builder.getMarginLeft() : params.leftMargin,
                    style.builder.getMarginTop() > 0 ? style.builder.getMarginTop() : params.topMargin,
                    style.builder.getMarginRight() > 0 ? style.builder.getMarginRight() : params.rightMargin,
                    style.builder.getMarginRight() > 0 ? style.builder.getMarginRight() : params.bottomMargin
            );
            content.setLayoutParams(params);
            content.invalidate();

        }
    }

    private void generateTitleView(View view) {

        TextView title = view.findViewById(R.id.title);

        if (helpScreen.builder.title != null) {

            title.setText(helpScreen.builder.title.getText());

            TextStyle style = helpScreen.builder.title.style;

            if (style.builder.getTextSize() > 0) title.setTextSize(style.builder.getTextSize());
            if (style.builder.getTextColor() != 0) title.setTextColor(style.builder.getTextColor());
            if (style.builder.getBackgroundColor() != 0)
                title.setBackgroundColor(style.builder.getBackgroundColor());

            title.setTypeface(title.getTypeface(), style.builder.getFontStyle() == TextStyle.FontStyle.BOLD ? Typeface.BOLD : Typeface.NORMAL);

            if (style.builder.getTextGravity() != 0)
                title.setGravity(style.builder.getTextGravity());

            if (style.builder.getWidth() > 0) title.setWidth(style.builder.getWidth());

            if (style.builder.getHeight() > 0) title.setHeight(style.builder.getHeight());

            // padding
            title.setPadding(style.builder.getPaddingLeft(), style.builder.getPaddingTop(), style.builder.getPaddingRight(), style.builder.getPaddingBottom());

            // margin
            if (style.builder.getMarginLeft() > 0 || style.builder.getMarginTop() > 0 || style.builder.getMarginRight() > 0 || style.builder.getMarginBottom() > 0) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) title.getLayoutParams();
                params.setMargins(style.builder.getMarginLeft(), style.builder.getMarginTop(), style.builder.getMarginRight(), style.builder.getMarginBottom());
                title.setLayoutParams(params);
            }

        }
    }

    private void generateMessageView(View view) {

        TextView message = view.findViewById(R.id.message);

        if (helpScreen.builder.message != null) {

            message.setText(helpScreen.builder.message.getText());

            TextStyle style = helpScreen.builder.message.style;

            if (style.builder.getTextSize() > 0) message.setTextSize(style.builder.getTextSize());
            if (style.builder.getTextColor() != 0)
                message.setTextColor(style.builder.getTextColor());
            if (style.builder.getBackgroundColor() != 0)
                message.setBackgroundColor(style.builder.getBackgroundColor());

            message.setTypeface(message.getTypeface(),
                    style.builder.getFontStyle() == TextStyle.FontStyle.BOLD ? Typeface.BOLD : Typeface.NORMAL);

            if (style.builder.getTextGravity() != 0)
                message.setGravity(style.builder.getTextGravity());

            if (style.builder.getWidth() > 0) message.setWidth(style.builder.getWidth());

            if (style.builder.getHeight() > 0) message.setHeight(style.builder.getHeight());

            // padding
            message.setPadding(style.builder.getPaddingLeft(), style.builder.getPaddingTop(), style.builder.getPaddingRight(), style.builder.getPaddingBottom());

            // margin
            if (style.builder.getMarginLeft() > 0 || style.builder.getMarginTop() > 0 || style.builder.getMarginRight() > 0 || style.builder.getMarginBottom() > 0) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) message.getLayoutParams();
                params.setMargins(
                        style.builder.getMarginLeft() > 0 ? style.builder.getMarginLeft() : params.leftMargin,
                        style.builder.getMarginTop() > 0 ? style.builder.getMarginTop() : params.topMargin,
                        style.builder.getMarginRight() > 0 ? style.builder.getMarginRight() : params.topMargin,
                        style.builder.getMarginBottom() > 0 ? style.builder.getMarginBottom() : params.bottomMargin
                );
                message.setLayoutParams(params);
            }
        }
    }
}
