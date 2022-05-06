package com.example.randomfox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button=findViewById(R.id.backButton);//описали переменную и связали с кнопкой
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")//базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create())//конвертер
                .build();
        RandomFoxApi randomFoxApi;
        randomFoxApi=retrofit.create(RandomFoxApi.class);//создали объект, с его помощью будем отправлять запросы
        randomFoxApi.getImage("3d822b9dce4e57f12b9b3400d480a358").
                enqueue(new Callback<Example>() {//aссинхронный вызов (для синхронного был бы метод execute() )
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if (response.isSuccessful()) {
                            Log.i("Sveta", response.body().getLink().toString());
                            Log.i("Sveta", "OK");
                        } else Log.i("Sveta", "no reponse");
                    }
                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.i("Sveta","Failure "+t);
                    }
                });
        ImageView imageView=findViewById(R.id.pic);
        Random rand = new Random();
        int random = rand.nextInt(123);
        new ImageDownloader(imageView).execute("https:\\/\\/randomfox.ca\\/images\\/"+random+".jpg");


    }
}