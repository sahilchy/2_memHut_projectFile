package com.astechnologies.memhut.welcome;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.astechnologies.memhut.Check;
import astechnologies.memhut.R;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences settings=getSharedPreferences("prefs",0);
        boolean firstRun=settings.getBoolean("firstRun",false);
        if(!firstRun)//if running for first time
        //Splash will load for first time
        {
            SharedPreferences.Editor editor=settings.edit();
            editor.putBoolean("firstRun",true);
            editor.apply();
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(getApplicationContext(), IntroActivity.class );
                startActivity(intent);
                finish();


            },3000);
        }
        else
        {
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(getApplicationContext(), Check.class );
                startActivity(intent);
                finish();


            },3000);
        }
    }

}
