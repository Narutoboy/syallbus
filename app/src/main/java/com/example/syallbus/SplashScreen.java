package com.example.syallbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView splashimg= (ImageView) findViewById(R.id.image);
        Animation a1= AnimationUtils.loadAnimation(this, R.anim.scale_up);
        splashimg.startAnimation(a1);
        Timer t1=new Timer();
        TimerTask tt= new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                SplashScreen.this.finish();
            }
        };
        t1.schedule(tt,2000);

    }
}
