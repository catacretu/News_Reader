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
import com.catalincretu.data.feature.model.Article;
import com.catalincretu.newsreader.feature.newslist.reactive.SingleLiveEvent;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;


public class NewsListViewModel extends AndroidViewModel {


    @NonNull
    public final ObservableList<ArticleItemViewModel> articlesList;
    private final static String LINK = "https://newsapi.org/";
    public final ObservableBoolean visibility_views;
    public final ObservableBoolean isLoading;
    public final ObservableField<String> resultText;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;
    private final NewsRepository repo;


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
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }

    private void onNewsArticlesReceived(@NonNull List<Article> articles) {
        isLoading.set(false);
        //resultText.set(getApplication().getString(R.string.results, articles.size()));

        for (Article item : articles) {
            ArticleItemViewModel articleItemViewModel = new ArticleItemViewModel(item.imageUrl, item.title, item.content);
            this.articlesList.add(articleItemViewModel);
        }

    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }


}
