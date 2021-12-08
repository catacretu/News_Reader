package com.catalincretu.newsreader.feature.newslist.mapper;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.catalincretu.data.feature.model.Article;
import com.catalincretu.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.List;

import io.reactivex.functions.Function;

public class ArticleToArticleItemViewModelMapper implements Function<List<Article>, ObservableList<ArticleItemViewModel>> {

    @Override
    public ObservableList<ArticleItemViewModel> apply(@NonNull List<Article> articles) {
        ObservableList<ArticleItemViewModel> articleList = new ObservableArrayList<>();
        for (Article article : articles)
            articleList.add(new ArticleItemViewModel(article.imageUrl, article.url, article.title, article.content));

        return articleList;
    }
}

