package com.catalincretu.newsreader.feature.newslist.model;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {

    @NonNull
    public final ObservableList<ArticleItemViewModel> articlesList;

    public NewsListViewModel() {
        this.articlesList = new ObservableArrayList<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        articlesList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Android_robot.svg/220px-Android_robot.svg.png", "GSP", "News1"));
        articlesList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Android_robot.svg/220px-Android_robot.svg.png", "Digi", "News2"));
        articlesList.add(new ArticleItemViewModel("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Android_robot.svg/220px-Android_robot.svg.png", "Sport.ro", "News3"));
        // articlesList.add(new ArticleItemViewModel("Title1","Content1"));
        //articlesList.add(new ArticleItemViewModel("Title2","Content2"));
    }
}
