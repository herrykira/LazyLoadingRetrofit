package com.example.kinhangpoon.lazyloadingretrofit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.AbsListView;

import com.example.kinhangpoon.lazyloadingretrofit.adapter.MovieAdapter;
import com.example.kinhangpoon.lazyloadingretrofit.module.MovieResponse;
import com.example.kinhangpoon.lazyloadingretrofit.network.RetrofitInstance;
import com.example.kinhangpoon.lazyloadingretrofit.network.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    static int index = 1;
    boolean isScrolling = false;
    List<MovieResponse> movieList;
    int currentItem,totalItem,scrollOutItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        movieList = new ArrayList<>();
        movieAdapter = new MovieAdapter(movieList);
        fetchData(index);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,LinearLayoutManager.VERTICAL));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItem = linearLayoutManager.getChildCount();
                totalItem = linearLayoutManager.getItemCount();
                scrollOutItem = linearLayoutManager.findFirstVisibleItemPosition();

                if(isScrolling && totalItem == currentItem+scrollOutItem){
                    isScrolling = false;
                    index++;
                    Log.i("update",index+"");
                    fetchData(index);
                }
            }
        });
    }

    private void fetchData(final int index) {
        if(index>10){
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData(index);
            }
        },1000);
    }
    private void loadData(int index){
        UserService userService = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<List<MovieResponse>> call = userService.getMovieDetail(index+"");
        call.enqueue(new Callback<List<MovieResponse>>() {
            @Override
            public void onResponse(Call<List<MovieResponse>> call, Response<List<MovieResponse>> response) {
                Log.i("Success",response.body().toString());
                movieList.addAll(response.body());
                movieAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<MovieResponse>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
}
