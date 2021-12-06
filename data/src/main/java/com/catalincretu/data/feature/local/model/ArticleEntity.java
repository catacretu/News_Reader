package com.catalincretu.data.feature.local.model;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity {

    public final String urlToImage;
    public final String url;
    public final String content;
    public final String description;
    public final String title;
    public final String author;
    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public ArticleEntity(String urlToImage, String url, String content, String description, String title, String author) {
        this.urlToImage = urlToImage;
        this.url = url;
        this.content = content;
        this.description = description;
        this.title = title;
        this.author = author;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }
}


