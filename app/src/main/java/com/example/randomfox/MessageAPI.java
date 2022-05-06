package com.example.randomfox;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageAPI {
    @GET("https://randomfox.ca/floof/")
    Call<String> message();

}