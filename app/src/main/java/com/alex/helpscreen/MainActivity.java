package com.alex.helpscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        int type=1;
        switch (view.getId()){
            case R.id.btn_simple:
                type=1;
                break;
            case R.id.btn_shader:
                type=2;
                break;
            case R.id.btn_style:
                type=3;
                break;
            case R.id.btn_custom:
                type=4;
                break;

        }
        Intent intent = new Intent(this, HelpScreenDemoActivity.class);
        intent.putExtra("TYPE", type);
        startActivity(intent);
    }



}
