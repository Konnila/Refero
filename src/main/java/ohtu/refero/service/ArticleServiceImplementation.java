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
    ArticleRepository articleRepository;

    @Transactional
    @Override
    public Article save(Article article) {
        
        if (article == null) {
            return null;
        }
        
        article = articleRepository.save(article);
        
        return article;
    }

    @Override
    
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
    
    @Override
    public Article findById(Long id) {
        return articleRepository.findOne(id);
    }
}