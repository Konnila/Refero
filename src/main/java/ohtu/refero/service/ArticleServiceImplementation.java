package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Article;
import ohtu.refero.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImplementation implements ArticleService {

    @Autowired
    ArticleRepository articleRepo;

    @Transactional
    @Override
    public Article addArticle(Article article) {
        if (article != null) {
            articleRepo.save(article);
            return article;
        }
        else return null;

    }

    @Override
    public List<Article> getArticles() {
        return articleRepo.findAll();
    }
}