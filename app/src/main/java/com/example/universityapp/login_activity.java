package com.example.universityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.universityapp.api.ApiServices;
import com.example.universityapp.utils.sharedPreference;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.universityapp.api.ApiClient;
public class login_activity extends AppCompatActivity {
    ApiServices apiInterface = ApiClient.getClient().create(ApiServices.class);
    sharedPreference sharedPreferencedata;
    ProgressBar progressBar;
    Button btn;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        getSupportActionBar().hide();

        sharedPreferencedata = sharedPreference.getInstance(this);

        progressBar = findViewById(R.id.progressBar1);
        btn = findViewById(R.id.btn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), dashboard.class);
//                startActivity(i);

                if(username.getText().toString().isEmpty()){
                    Toast.makeText(login_activity.this, "Username requried", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(login_activity.this, "Password required", Toast.LENGTH_SHORT).show();
                } else {
                    Login(username.getText().toString(), password.getText().toString());
                }




            }

            private void Login(String username, String password) {
                progressBar.setVisibility(View.VISIBLE);
                final JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("Username", username);
                jsonObject.addProperty("Password", password);
                Log.d("loginss", new Gson().toJson(jsonObject));
                progressBar.setVisibility(View.VISIBLE);
                Call<JsonObject> call = apiInterface.login_user(ApiClient.makeJSONRequestBody(jsonObject));
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        Log.d("uuuuuuuuuuuuuuuuuuu", new Gson().toJson(response.body()));
//                        Log.d("response_data", response.body().toString());
                        JsonObject userData = response.body().get("d").getAsJsonArray().get(0).getAsJsonObject();
                    if(userData.get("MSG").getAsString().equals("Error")){

                        Toast.makeText(login_activity.this, "User not found", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                    }else{
                        Toast.makeText(login_activity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);


                        sharedPreferencedata.putStudentId(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("StudentId").getAsString());
                        sharedPreferencedata.putCode(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("Code").getAsString());
                        sharedPreferencedata.putClassID(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("ClassID").getAsString());
                        sharedPreferencedata.putClassName(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("ClassName").getAsString());
                        sharedPreferencedata.putStatus(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("Status").getAsString());
                        sharedPreferencedata.putSemesterID(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("SemesterID").getAsString());
                        sharedPreferencedata.putStudentName(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("StudentName").getAsString());
                        sharedPreferencedata.putSemesterName(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("SemesterName").getAsString());
                        sharedPreferencedata.putParentName(response.body().get("d").getAsJsonArray().get(0).getAsJsonObject().get("ParentName").getAsString());

                        goto_home();
                    }

                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("response_data", t.getMessage());
                    }
                });
            }
        });

    }

    public void goto_home() {

        Intent i = new Intent(this, dashboard.class);

        startActivity(i);
    }
}
