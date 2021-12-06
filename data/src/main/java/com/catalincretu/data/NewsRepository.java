package com.catalincretu.data;

import androidx.annotation.NonNull;

import com.catalincretu.data.feature.model.Article;

import java.util.List;

import io.reactivex.Single;

public interface NewsRepository {
    @NonNull
    Single<List<Article>> getNewsArticles();

}
