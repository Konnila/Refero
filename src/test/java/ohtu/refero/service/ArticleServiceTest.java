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
    Article testArticle;

    @Before
    public void initialize() {
        testArticle = new Article();
        testArticle.setId(1L);
        testArticle.setAuthor("Bruhn, Russel E. and Burton, Philip J.");
        testArticle.setTitle("An approach to teaching Java using computers");
        testArticle.setJournal("SIGCSE Bull.");
        testArticle.setVolume(35);
        testArticle.setNumber(4);
        testArticle.setReleaseYear(2003);
        testArticle.setPages("94--99");
        testArticle.setPublisher("ACM");
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