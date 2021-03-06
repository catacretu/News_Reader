package com.catalincretu.newsreader;

import android.app.Application;

import com.catalincretu.data.di.RepoModule;

public class NewsApplication extends Application {
    private static RepoModule repoModule;

    public static RepoModule getRepoProvider() {
        return repoModule;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        repoModule = new RepoModule(this);
    }
}

