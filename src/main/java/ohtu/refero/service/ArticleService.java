package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Article;

public interface ArticleService {
    Article addArticle(Article article);
    List<Article> getArticles();
    Article getArticleById(Long id);
}