package com.example.project_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Showlogo3s extends Activity {
    // Set Time Waitting
    private final int TimeWait = 3000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.showlogo3s);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent intent = new Intent(Showlogo3s.this, MainActivity.class);
                Showlogo3s.this.startActivity(intent);
                Showlogo3s.this.finish();
            }
        }, TimeWait);
    }
}