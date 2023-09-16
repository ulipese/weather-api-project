package com.example.wapp;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class WeatherApi extends AsyncTaskLoader<String> {
    private String mQueryString;
    WeatherApi(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return Connection.buscaTempo(mQueryString);
    }

}
