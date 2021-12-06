package com.catalincretu.newsreader.feature.newslist.listener;

import com.catalincretu.newsreader.feature.newslist.model.ArticleItemViewModel;

public interface Handler {
    void onItemSelected(ArticleItemViewModel item);
}

