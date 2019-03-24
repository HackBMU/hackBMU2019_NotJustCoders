package com.clorify.clorify;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent SplashScreen = new Intent(SplashScreen.this, HomeActivity.class );
                startActivity(SplashScreen);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
