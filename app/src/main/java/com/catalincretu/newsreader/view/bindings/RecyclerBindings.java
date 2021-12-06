package com.catalincretu.newsreader.view.bindings;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.catalincretu.newsreader.feature.newslist.adapter.NewsAdapter;
import com.catalincretu.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {
    @BindingAdapter({"items"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> articlesList) {
        NewsAdapter newsAdapter = (NewsAdapter) recyclerView.getAdapter();

        if (newsAdapter == null) {
            newsAdapter = new NewsAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(newsAdapter);
        }
        newsAdapter.setItems(articlesList);
    }
}
