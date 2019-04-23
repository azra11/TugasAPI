package com.example.admin.movieapi;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.admin.movieapi.Adapter.MovieAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView recyclerView;
    private MovieAdapter moviesAdapter;
    private MainPresenter mainPresenter;
    private ActionBar toolbar;
    private String API_KEY = "";
    private String language = "en-US";
    private int page = 1;
    private String region = "indonesia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        toolbar.setTitle("Popular Movies");
        recyclerView = findViewById(R.id.rec_movie);
        mainPresenter = new MainPresenter(this,this);
        mainPresenter.loadMovies(API_KEY, language, page, region);

    }
    @Override
    public void onSuccess(List<ResultsItem> resultsItemList){
        moviesAdapter = new MovieAdapter(getApplicationContext(),resultsItemList);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerView.setAdapter(moviesAdapter);
        moviesAdapter.notifyDataSetChanged();

    }
    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show();
    }
}
