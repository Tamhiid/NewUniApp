package com.example.universityapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.universityapp.utils.sharedPreference;
import com.google.android.material.navigation.NavigationView;

public class announcementActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    TextView txtusername, txtclasss;
    sharedPreference sharedPreferencedata;
    public NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        navigationView = (NavigationView) findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);


        sharedPreferencedata = sharedPreference.getInstance(this);

        navigationView = (NavigationView) findViewById(R.id.nav);
        View headerView = navigationView.getHeaderView(0);

        txtusername =(TextView) headerView.findViewById(R.id.txtusername);
        txtclasss = (TextView) headerView.findViewById(R.id.txtclass);

        txtusername.setText(sharedPreferencedata.getStdName());
        txtclasss.setText(sharedPreferencedata.getClassName());

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    // Menu Items Start
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.logout){
            sharedPreferencedata.putParentName("");
            sharedPreferencedata.putSemesterName("");
            sharedPreferencedata.putStatus("");
            sharedPreferencedata.putStudentName("");
            sharedPreferencedata.putSemesterID("");
            sharedPreferencedata.putClassName("");
            sharedPreferencedata.putCode("");
            sharedPreferencedata.putClassID("");
            sharedPreferencedata.putStudentId("");

            Intent i = new Intent(getApplicationContext(), login_activity.class);
            startActivity(i);
        }else if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.announcement){
            //Toast.makeText(getApplicationContext(), "You clicked announcement", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), announcementActivity.class);
            startActivity(i);
        }else  if(id == R.id.student_statement){
            Intent i = new Intent(getApplicationContext(), StudentStatementActivity.class);
            startActivity(i);
        }else if(id == R.id.result){
            Intent i = new Intent(getApplicationContext(), resultsActivity.class);
            startActivity(i);
        }else if(id == R.id.student_material){
            Intent i = new Intent(getApplicationContext(), studentMaterialActivity.class);
            startActivity(i);
        }else if(id == R.id.view){
            Intent i = new Intent(getApplicationContext(), viewActivity.class);
            startActivity(i);
        }else if(id == R.id.upload_assignment){
            Intent i = new Intent(getApplicationContext(), uploadAssignmentActivity.class);
            startActivity(i);
        }else if(id == R.id.assignment_you_sent){
            Intent i = new Intent(getApplicationContext(), assignmentYouSent.class);
            startActivity(i);
        }else if(id == R.id.view_teachers){
            Intent i = new Intent(getApplicationContext(), viewTeachers.class);
            startActivity(i);
        }else if(id == R.id.logout){
            Intent i = new Intent(getApplicationContext(), login_activity.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


