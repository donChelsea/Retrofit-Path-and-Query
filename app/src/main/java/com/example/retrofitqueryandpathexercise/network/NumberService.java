package com.example.retrofitqueryandpathexercise.network;

import com.example.retrofitqueryandpathexercise.model.Number;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NumberService {

    @GET("{number}/math?json")
    Call<Number> getText(@Path("number") int number);
}
