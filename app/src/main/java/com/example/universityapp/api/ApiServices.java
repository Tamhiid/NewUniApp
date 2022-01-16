package com.example.universityapp.api;

import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import retrofit2.http.Headers;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface ApiServices {

   @Headers("Content-Type: application/json")
   @POST("API_UserLogin")
   Call<JsonObject> login_user(@Body RequestBody requestBody);

//   @Headers("Content-Type: application/json")
//   @POST("announcement")
//   Call<announcement> SetAnnouncement(@Body SetAnnouncement setannouncement);


}
