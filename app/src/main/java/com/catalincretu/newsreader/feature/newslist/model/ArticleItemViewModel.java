package com.catalincretu.newsreader.feature.newslist.model;

public class ArticleItemViewModel {

    public final String imageUrl;
    public final String title;
    public final String news_content;

    public ArticleItemViewModel(String imageUrl, String title, String news_content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.news_content = news_content;
    }

}
