package com.example.universityapp.api;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.universityapp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    public static final String Tag = "ApiClient";
    private static MediaType MEDIA_TYPE_TEXT = MediaType.parse("multipart/form-data");
    private static final String BASE_URL = "http://demo2.tabaarak.com/Portal/StudentLoginWebService.asmx/";
    public static MediaType MEDIA_TYPE_IMAGE = MediaType.parse("placeholder/*");
    public static Retrofit getClient(){
 /*       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;*/

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

    @NonNull
    public static RequestBody makeJSONRequestBody(JsonObject jsonObject) {
        String params = jsonObject.toString();
        return RequestBody.create(MEDIA_TYPE_TEXT, params);
    }

    @NonNull
    public static RequestBody makeTextRequestBody(Object stringData) {
        return RequestBody.create(MEDIA_TYPE_TEXT, String.valueOf(stringData));
    }


    @NonNull
    public static MultipartBody.Part makeMultipartRequestBody(Context context, String
            photoPath, String partName) {
        try {
            File file = new File(photoPath);
            RequestBody requestFile = RequestBody.create(MEDIA_TYPE_IMAGE, file);
            return MultipartBody.Part.createFormData(partName, context.getResources().getString(
                    R.string.app_name),
                    requestFile);
        } catch (NullPointerException e) {
            Log.d("Tgggg", e.getMessage());
            return null;
        }

    }
}
