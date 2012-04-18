package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Article;

public interface ArticleService {

    public Article save(Article article);

    public List<Article> findAll();

    public Article findById(Long id);
}