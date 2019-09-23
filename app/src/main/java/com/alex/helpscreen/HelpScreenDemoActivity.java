package com.alex.helpscreen;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ornach.helpscreen.HelpScreen;
import com.ornach.helpscreen.HelpText;
import com.ornach.helpscreen.OnHelpScreenListener;
import com.ornach.helpscreen.Shader;
import com.ornach.helpscreen.TextStyle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;

public class HelpScreenDemoActivity extends AppCompatActivity {
    private static final String TAG = "HelpScreenDemoActivity";

    BottomNavigationView navView;
    int type = 1;

    private int displayWidth;
    private int displayHeight;
    private int statusBarHeight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen_demo);
        navView = findViewById(R.id.nav_view);

        if (getIntent() != null && getIntent().hasExtra("TYPE")) {
            type = getIntent().getIntExtra("TYPE", 1);
        }


        calculateDimension();
        helpScreenShow();


//        View anchor =navView.getChildAt(0);
//
//        Log.e(TAG, "customViewHelpScreenShow_2: anchor "+  (anchor !=null));

    }

    private void calculateDimension() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        displayWidth = displayMetrics.widthPixels;
        displayHeight = displayMetrics.heightPixels;

        int resource = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resource > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resource);
        }
    }

    private void helpScreenShow() {
        switch (type) {
            case 1:
                simpleHelpScreenShow();
                break;
            case 2:
                shaderHelpScreenShow();
                break;
            case 3:
                styleHelpScreenShow();
                break;
            case 4:
                customViewHelpScreenShow();
                break;

        }
    }

    private void simpleHelpScreenShow() {

        int x = 150;
        int y = displayHeight-statusBarHeight;

        HelpScreen helpScreen = new HelpScreen.Builder(this)
                .setFocusCx(x)
                .setFocusCy(y)
                .setFocusRadius(200)
                .setBorderColor(Color.parseColor("#99FFFFFF"))
                .setBorderSize(50)
                .setTitle(new HelpText("Simple Title"))
                .setMessage(new HelpText("This is a simple message. You can change this later. \nTap anywhere to dismiss"))
                .build();
        helpScreen.show();
    }

    private void shaderHelpScreenShow() {

        int x = displayWidth / 2;
        int y = displayHeight - statusBarHeight;

        HelpScreen helpScreen = new HelpScreen.Builder(this)
                .setFocusCx(x)
                .setFocusCy(y)
                .setFocusRadius(150)
                .setTitle(new HelpText("Simple Title"))
                .setMessage(new HelpText("This is a simple message. You can customize shader \nwith color & radius as you want"))
                .addShader(new Shader(Color.parseColor("#DDDDDD"), 700))
                .addShader(new Shader(Color.parseColor("#DDDDDD"), 400))
                .build();
        helpScreen.show();
    }

    private void styleHelpScreenShow() {

        int x = displayWidth / 2;
        int y = displayHeight - statusBarHeight;

        HelpScreen helpScreen = new HelpScreen.Builder(this)
                .setFocusCx(x)
                .setFocusCy(y)
                .setFocusRadius(150)
                .setBorderSize(20)
                .setBorderColor(Color.parseColor("#00FFFC"))
                .setBackgroundColor(Color.parseColor("#BB0C377E"))
                .setTitle(
                        new HelpText(
                                "Simple Title",
                                new TextStyle.Builder()
                                        .setTextColor(Color.YELLOW)
                                        .setFontStyle(TextStyle.FontStyle.BOLD)
                                        .setTextSize(22)
                                .build()
                        )
                )
                .setMessage(
                        new HelpText(
                                "This is a simple message. You can customize shader with color & radius as you want",
                                new TextStyle.Builder()
                                        .setWidth(800)
                                        .setMargin(10,50,10,0)
                                        .build()
                        )
                )
                .addShader(new Shader(Color.parseColor("#00D3F7"), 700))
                .addShader(new Shader(Color.parseColor("#00D3F7"), 400))
                .build();
        helpScreen.show();
    }

    private void customViewHelpScreenShow() {


        final View view = LayoutInflater.from(this).inflate(R.layout.custom_layout_help_screen, null);

        HelpScreen helpScreen = new HelpScreen.Builder(this)
                .setCustomView(view)
                .setCancelable(false)
                .build();
        helpScreen.show();
        helpScreen.setOnHelpScreenListener(new OnHelpScreenListener() {
            @Override
            public void onShow() {

            }

            @Override
            public void onDismiss() {
                customViewHelpScreenShow_2();
            }
        });
    }

    private void customViewHelpScreenShow_2() {

//        View anchor =navView.getChildAt(0);

        View anchor = navView.getRootView().findViewById( R.id.navigation_notifications);

        int [] location = new int[2];
        anchor.getLocationOnScreen(location);

        int x = location[0]+anchor.getWidth()/2;
        int y = (location[1]+anchor.getHeight()/2)-80;

        final View view = LayoutInflater.from(this).inflate(R.layout.custom_layout_help_screen_02, null);

        HelpScreen helpScreen = new HelpScreen.Builder(this)
                .setFocusCx(x)
                .setFocusCy(y)
                .setCustomView(view)
                .setFocusRadius(150)
                .setBorderColor(Color.parseColor("#DDFFFFFF"))
                .setBorderSize(30)
                .build();
        helpScreen.show();
    }

}
