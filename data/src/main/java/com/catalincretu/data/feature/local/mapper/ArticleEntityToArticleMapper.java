package com.catalincretu.data.feature.local.mapper;

import androidx.annotation.NonNull;

import com.catalincretu.data.feature.local.model.ArticleEntity;
import com.catalincretu.data.feature.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class ArticleEntityToArticleMapper implements Function<List<ArticleEntity>, List<Article>> {

    @Override
    public List<Article> apply(@NonNull List<ArticleEntity> articleEntities) {
        List<Article> articleList = new ArrayList<>();
        for (ArticleEntity entity : articleEntities)
            articleList.add(new Article(entity.urlToImage, entity.url, entity.title, entity.content, entity.description));

        return articleList;
    }
}


