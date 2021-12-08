package com.catalincretu.newsreader;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.catalincretu.newsreader.feature.newslist.fragment.NewsFragment;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsFragment.newInstance())
                    .commitNow();
        }
    }
}