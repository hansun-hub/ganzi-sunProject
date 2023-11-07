package com.example.ganzisunProject.repository;

import com.example.ganzisunProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
