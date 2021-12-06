package com.catalincretu.newsreader.feature.newslist.model;

public class ArticleItemViewModel {

    public final String imageUrl;
    public final String url;
    public final String title;
    public final String news_content;
    // public final String descrition;

    public ArticleItemViewModel(String imageUrl, String url, String title, String news_content) {
        this.imageUrl = imageUrl;
        this.url = url;
        this.title = title;
        this.news_content = news_content;
        // this.descrition = descrition;
    }
}
