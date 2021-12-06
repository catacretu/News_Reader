package com.catalincretu.data.feature;

import com.catalincretu.data.NewsRepository;
import com.catalincretu.data.feature.local.model.NewsLocalSource;
import com.catalincretu.data.feature.model.Article;
import com.catalincretu.data.feature.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {
    private final NewsLocalSource localSource;
    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsLocalSource localSource, NewsRemoteSource remoteSource) {
        this.localSource = localSource;
        this.remoteSource = remoteSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(localSource::saveArticles)
                .onErrorResumeNext(localSource.getArticles());
    }

}
