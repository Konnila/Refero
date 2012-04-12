package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Article;
import ohtu.refero.repositories.ArticleRepository;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring-database.xml"})

public class ArticleServiceTest {
    
    @Autowired
    ArticleService a;
    Article b;
    
    @Before
    public void initialize() {
        b = new Article();
        b.setAuthor("author");
        b.setTitle("t");
        b.setJournal("j");
        b.setNumber(254);
        b.setReleaseYear(1999);
        b.setVolume(2);
        b.setId(Long.MIN_VALUE);
    }
    
    @Test
    public void addArticleTest() {
        a.addArticle(b);
        List<Article> l = a.getArticles();
        assertEquals(l.contains(b), true);
        assertEquals(a.addArticle(null), null);
        assertEquals(a.getArticleById(b.getId()), b);
    }
}