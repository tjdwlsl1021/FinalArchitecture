package com.charlezz.javaapp.feature.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostService {
    @GET("posts")
    Call<List<Post>> getPosts(@Query("_page") int page);
}