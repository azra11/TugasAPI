package com.example.admin.movieapi.koneksi;

import com.example.admin.movieapi.model.Movieresponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("3/trending/get-trending")
    Call<Movieresponse> getMovies(@Query("api_key") String api_key,
                                           @Query("language") String language,
                                           @Query("page") int page,
                                           @Query("region") String region);
}
