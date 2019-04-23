package com.example.admin.movieapi;

import java.util.List;

public interface MainView {
    void onSuccess(List<ResultsItem> resultsItemList);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}