package com.catalincretu.newsreader.feature.newslist.model.factory;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.catalincretu.data.NewsRepository;
import com.catalincretu.newsreader.NewsApplication;
import com.catalincretu.newsreader.feature.newslist.model.NewsListViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            NewsRepository repo = NewsApplication.getRepoProvider().provideNewsRepository();
            return (T) new NewsListViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
