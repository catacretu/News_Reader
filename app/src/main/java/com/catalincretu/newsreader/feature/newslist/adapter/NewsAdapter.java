package com.catalincretu.newsreader.feature.newslist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.catalincretu.newsreader.databinding.ArticleItemBinding;
import com.catalincretu.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<ArticleItemViewModel> articlesList;

    public NewsAdapter() {
        this.articlesList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticleItemBinding binder = ArticleItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setViewModel(articlesList.get(position));

    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public void setItems(List<ArticleItemViewModel> articlesList) {
        this.articlesList = articlesList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ArticleItemBinding binding;

        public ViewHolder(ArticleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

