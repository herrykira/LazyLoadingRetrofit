package com.example.kinhangpoon.lazyloadingretrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kinhangpoon.lazyloadingretrofit.R;
import com.example.kinhangpoon.lazyloadingretrofit.module.MovieResponse;

import java.util.List;

/**
 * Created by KinhangPoon on 16/3/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<MovieResponse> movies;

    public MovieAdapter(List<MovieResponse> movies) {
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieResponse movie = movies.get(position);
        holder.Title.setText(movie.getTitle());
        holder.Rating.setText(movie.getRating());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView Title,Rating;
        public MovieViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.title);
            Rating = itemView.findViewById(R.id.rating);
        }
    }
}
