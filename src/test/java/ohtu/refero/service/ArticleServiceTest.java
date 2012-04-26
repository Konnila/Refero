package ohtu.refero.service;
import ohtu.refero.models.Article;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class ArticleServiceTest {

    @Autowired
    ArticleService articleRepo;
    @Autowired
    StringToAuthorConverter converter;
    Article testArticle;

    @Before
    public void initialize() {
        testArticle = new Article();
        testArticle.setAuthors(converter.convertToAuthor("author aatami"));
        testArticle.setTitle("t");
        testArticle.setJournal("j");
        testArticle.setNumber(254);
        testArticle.setReleaseYear(1999);
        testArticle.setVolume(2);
        testArticle.setId(Long.MIN_VALUE);
    }

    @Test
    public void addingNullReturnsNull() {
        assertEquals(null, articleRepo.save(null));
    }

    @Test
    public void addAndfindArticleTest() {
        Article article = articleRepo.save(testArticle);
        assertEquals(articleRepo.findById(article.getId()), article);
    }

    @Test
    public void findAllArticles() {
        assertTrue(articleRepo.findAll() != null);
    }
}