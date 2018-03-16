package com.example.kinhangpoon.lazyloadingretrofit.network;

import com.example.kinhangpoon.lazyloadingretrofit.module.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KinhangPoon on 16/3/2018.
 */

public interface UserService {
    @GET("movies.php")
    public Call<List<MovieResponse>> getMovieDetail (@Query("index") String index);
}
