package com.Esprit.sim.kidzwo.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Esprit.sim.kidzwo.R;

public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(FirstScreen.this, LoginActivity.class);

                startActivity(i);

                // close this activity

                finish();

            }

        }, 2000); // wait for 5 seconds
    }
}
