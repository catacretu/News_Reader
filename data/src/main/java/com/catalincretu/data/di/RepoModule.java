package com.catalincretu.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.catalincretu.data.NewsRepository;
import com.catalincretu.data.feature.NewsRepositoryImpl;
import com.catalincretu.data.feature.local.model.NewsLocalSource;
import com.catalincretu.data.feature.remote.NewsRemoteSource;
import com.catalincretu.data.local.NewsDatabase;
import com.catalincretu.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private final HttpClientFactory httpClientFactory;
    @NonNull
    private Context context;

    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideLocalDataStore(), provideNewsRemoteSource());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    NewsLocalSource provideLocalDataStore() {
        NewsDatabase database = getInstance();
        return new NewsLocalSource(database.articlesDao());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context,
                            NewsDatabase.class, "News.db")
                            .build();
                }
            }
        }
        return database;
    }
}
