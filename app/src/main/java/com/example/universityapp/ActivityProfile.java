package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.universityapp.utils.sharedPreference;

public class ActivityProfile extends AppCompatActivity {
sharedPreference sharedPreferenceData;
TextView telephone,semester,classs,name,parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPreferenceData = sharedPreference.getInstance(this);
        telephone = (TextView) findViewById(R.id.telephone);
        semester = (TextView) findViewById(R.id.semester);
        classs = (TextView) findViewById(R.id.classs);
        name = (TextView) findViewById(R.id.name);
        parent = (TextView) findViewById(R.id.parent);

        name.setText((sharedPreferenceData.getStdName()));
        semester.setText(sharedPreferenceData.getSemName());
        classs.setText(sharedPreferenceData.getClassName());
        parent.setText(sharedPreferenceData.getPARENT());



    }


    // Menu Items Start
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      //  Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.logout:
                // do your code
                sharedPreferenceData.putParentName("");
                sharedPreferenceData.putSemesterName("");
                sharedPreferenceData.putStatus("");
                sharedPreferenceData.putStudentName("");
                sharedPreferenceData.putSemesterID("");
                sharedPreferenceData.putClassName("");
                sharedPreferenceData.putCode("");
                sharedPreferenceData.putClassID("");
                sharedPreferenceData.putStudentId("");

                Intent i = new Intent(getApplicationContext(), login_activity.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}