package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.universityapp.utils.sharedPreference;

public class splashActivity extends AppCompatActivity {
    sharedPreference sharedPreferenceData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        sharedPreferenceData = sharedPreference.getInstance(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer is over
                // Start your app main activity

                if(sharedPreferenceData.getStudentId().equals("")){
                    goto_login();
                }else{
                    goto_home();
                }

                // close this activity
                finish();
            }
        }, 2000);
    }


    public void goto_login(){
        Intent i = new Intent(getApplicationContext(), login_activity.class);
        startActivity(i);
    }

    public void goto_home(){
        Intent i = new Intent(getApplicationContext(), dashboard.class);
        startActivity(i);
    }
    }

