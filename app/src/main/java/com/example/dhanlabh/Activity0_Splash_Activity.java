package com.example.dhanlabh;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Activity0_Splash_Activity extends AppCompatActivity{
    private static final long SPLASH_SCREEN_DELAY = 1500; // Delay in milliseconds

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity0_splash_activity);

            // Delayed navigation to the main activity
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(Activity0_Splash_Activity.this, Activity1_Main.class);
                startActivity(intent);
                finish();   // this will close splash activity so that on clicking back button while on home activity it should not again go to splash activity
            }, SPLASH_SCREEN_DELAY);
        }
}
