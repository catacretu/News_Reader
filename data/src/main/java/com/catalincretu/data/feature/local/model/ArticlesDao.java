package com.catalincretu.data.feature.local.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ArticlesDao {
    @Query("SELECT * FROM articles")
    Single<List<ArticleEntity>> queryArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<ArticleEntity> articles);

    @Query("SELECT * FROM articles where id= :id")
    Single<ArticleEntity> queryArticleItem(int id);

    @Query("DELETE FROM articles where id=:id")
    Completable deleteArticleItem(int id);

    @Query("DELETE FROM articles")
    Completable deleteAllArticles();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity article);

    @Query("UPDATE articles SET urlToImage = :urlToImage, url = :url,content = :content, description = :description," +
            "title = :title, author = :author where id=:id")
    Completable updateArticle(String urlToImage, String url, String content, String description, String title, String author, int id);
}


