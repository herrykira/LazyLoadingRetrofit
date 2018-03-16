package com.example.kinhangpoon.lazyloadingretrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KinhangPoon on 16/3/2018.
 */

public class RetrofitInstance {
    static Retrofit retrofit = null;
    static String BASE_URL ="http://www.sab99r.com/demos/api/";
    public static Retrofit getRetrofitInstance(){
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
