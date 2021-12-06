package com.catalincretu.data.feature.model;

import io.reactivex.annotations.NonNull;

public class Article {
    @NonNull
    public final String imageUrl;
    @NonNull
    public final String url;
    @NonNull
    public final String title;
    @NonNull
    public final String content;
    @NonNull
    public final String description;

    public Article(@NonNull String imageUrl, @NonNull String url, @NonNull String title, @NonNull String content, @NonNull String description) {
        this.imageUrl = imageUrl;
        this.url = url;
        this.title = title;
        this.content = content;
        this.description = description;
    }
}
