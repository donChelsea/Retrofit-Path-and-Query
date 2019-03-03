package com.example.retrofitqueryandpathexercise.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "http://numbersapi.com/";
    private Retrofit instance;

    public RetrofitSingleton() {
    }

    public Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
