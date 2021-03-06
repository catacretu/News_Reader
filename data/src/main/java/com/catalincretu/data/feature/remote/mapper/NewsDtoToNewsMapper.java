package com.catalincretu.data.feature.remote.mapper;

import com.catalincretu.data.feature.model.Article;
import com.catalincretu.data.feature.remote.model.ArticleDto;
import com.catalincretu.data.feature.remote.model.ArticleListDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsDtoToNewsMapper implements Function<ArticleListDto, List<Article>> {

    @Override
    public List<Article> apply(ArticleListDto articleDtos) {
        List<Article> articles = new ArrayList<>();

        for (ArticleDto dto : articleDtos.articles) {
            Article article = new Article(
                    dto.urlToImage != null ? dto.urlToImage : "",
                    dto.url != null ? dto.url : "",
                    dto.title != null ? dto.title : "",
                    dto.content != null ? dto.content : "",
                    dto.description != null ? dto.description : ""
            );

            articles.add(article);
        }

        return articles;
    }
}

