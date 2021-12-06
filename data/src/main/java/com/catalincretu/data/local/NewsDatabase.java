package com.catalincretu.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.catalincretu.data.feature.local.model.ArticleEntity;
import com.catalincretu.data.feature.local.model.ArticlesDao;

@Database(entities = {ArticleEntity.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract ArticlesDao articlesDao();
}
