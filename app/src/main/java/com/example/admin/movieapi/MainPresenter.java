package com.example.admin.movieapi;

;

import android.content.Context;

import com.example.admin.movieapi.MainView;
import com.example.admin.movieapi.koneksi.BaseApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private Context context;
    private MainView mainView;


    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;
    }
    public void loadMovies(String api_key, String language, int page, String region){
        BaseApp.apiService.getMovies(api_key, language, page, region).enqueue(new Callback<com.example.apimovies.model.Movieresponse>() {
            @Override
            public void onResponse(Call<com.example.apimovies.model.Response> call, Response<com.example.apimovies.model.Movieresponse> response) {
                if (response.isSuccessful()){
                    mainView.onSuccess(response.body().getResults());
                }else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<com.example.apimovies.model.Movieresponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());

            }
        });
    }
}