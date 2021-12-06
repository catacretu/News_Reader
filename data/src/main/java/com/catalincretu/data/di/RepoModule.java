package com.catalincretu.data.di;

import android.app.Application;
import android.content.Context;

import com.catalincretu.data.NewsRepository;
import com.catalincretu.data.feature.NewsRepositoryImpl;
import com.catalincretu.data.feature.remote.NewsRemoteSource;
import com.catalincretu.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private final HttpClientFactory httpClientFactory;
    @NonNull
    private Context context;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
}
