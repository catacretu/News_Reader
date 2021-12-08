package com.catalincretu.newsreader.feature.newslist.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;

import com.catalincretu.data.NewsRepository;
import com.catalincretu.newsreader.feature.newslist.listener.Handler;
import com.catalincretu.newsreader.feature.newslist.mapper.ArticleToArticleItemViewModelMapper;
import com.catalincretu.newsreader.feature.newslist.reactive.SingleLiveEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class NewsListViewModel extends AndroidViewModel implements Handler {


    @NonNull
    public ObservableList<ArticleItemViewModel> articlesList;
    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;
    public final ObservableBoolean visibility_views;
    public final ObservableBoolean isLoading;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;


    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.articlesList = new ObservableArrayList<>();
        this.isLoading = new ObservableBoolean();
        this.visibility_views = new ObservableBoolean(true);
        this.resultText = new ObservableField<>();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();

    }

    @SuppressLint("CheckResult")
    public void refreshData() {
        isLoading.set(true);
        visibility_views.set(false);
        repo.getNewsArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .map(new ArticleToArticleItemViewModelMapper())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull ObservableList<ArticleItemViewModel> articleItemViewModels) {
        isLoading.set(false);
        this.articlesList.addAll(articleItemViewModels);
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }


    @Override
    public void onItemSelected(ArticleItemViewModel item) {
        if (!item.url.equals(""))
            openLink.setValue(item.url);


    }
}
