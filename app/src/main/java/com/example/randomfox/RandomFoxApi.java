package com.example.randomfox;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomFoxApi {
    @GET("/randomfox.ca/floof/")
    Call<Example> getImage(@Query("appid") String appID);
}
