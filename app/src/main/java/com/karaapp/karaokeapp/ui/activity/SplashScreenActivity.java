package com.karaapp.karaokeapp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karaapp.karaokeapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final Thread mThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent mIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(mIntent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        mThread.start();
    }
}
