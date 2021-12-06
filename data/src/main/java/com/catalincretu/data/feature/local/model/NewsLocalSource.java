package com.catalincretu.data.feature.local.model;

import com.catalincretu.data.feature.local.mapper.ArticleEntityToArticleMapper;
import com.catalincretu.data.feature.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalSource {
    private final ArticlesDao dao;

    public NewsLocalSource(ArticlesDao dao) {
        this.dao = dao;
    }

    public Single<List<Article>> getArticles() {
        return dao.queryArticles().map(new ArticleEntityToArticleMapper());
    }

    public Completable saveArticles(List<Article> articles) {
        List<ArticleEntity> entityList = new ArrayList<>();

        //convert an Article to an ArticleEntity
        for (Article article : articles) {
            ArticleEntity articleEntity = new ArticleEntity(
                    article.imageUrl,
                    article.url,
                    article.content,
                    article.description,
                    article.title,
                    ""
            );
            entityList.add(articleEntity);
        }
        return (Completable) dao.insertArticles(entityList)
                .observeOn(Schedulers.io())
                .subscribe();
    }

   /* public Single<ArticleEntity> getArticleItem(int id) {
        return dao.queryArticleItem(id);
    }

    public Completable deleteArticleItem(int id) {
        return dao.deleteArticleItem(id);
    }

    public Completable saveItem(ArticleEntity article) {
        if (article.id == null) {
            return dao.insertArticle(article);
        } else {
            return dao.updateArticle(article.urlToImage, article.url, article.content, article.description,
                    article.title, article.author, article.id);
        }
    public Completable saveArticle(ArticleEntity article) {
        return dao.insertArticle(article);
    } */

}


