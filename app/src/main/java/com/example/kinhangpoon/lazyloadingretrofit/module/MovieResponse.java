package com.example.kinhangpoon.lazyloadingretrofit.module;

import com.google.gson.annotations.SerializedName;


public class MovieResponse{

	@SerializedName("rating")
	private String rating;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	public MovieResponse(String rating, String title, String type) {
		this.rating = rating;
		this.title = title;
		this.type = type;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"MovieResponse{" + 
			"rating = '" + rating + '\'' + 
			",title = '" + title + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}