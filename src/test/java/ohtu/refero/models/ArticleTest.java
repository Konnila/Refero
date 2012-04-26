package ohtu.refero.models;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArticleTest {

    Article testArticle;

    @Before
    public void initialize() {
        testArticle = new Article();
        List<Author> authors = new ArrayList<Author>();
        Author author = new Author();
        author.setFirstName("Kalle");
        author.setSurName("Havumaki");
        authors.add(author);
        testArticle.setAuthors(authors);
        testArticle.setTitle("t");
        testArticle.setJournal("j");
        testArticle.setNumber(254);
        testArticle.setReleaseYear(1999);
        testArticle.setVolume(2);
        testArticle.setPages("1-15");
        testArticle.setId(Long.MIN_VALUE);
    }

    @Test
    public void isNew() {
        Article article = new Article();
        assertTrue(article.isNew());
    }

    @Test
    public void gettersAndSetters() {
        List<Author> authors = new ArrayList<Author>();
        Author author = new Author();
        author.setFirstName("Kalle");
        author.setSurName("Havumaki");
        authors.add(author);
        assertEquals(testArticle.getAuthors().get(0).toString(), author.toString());
        assertEquals(testArticle.getTitle(), "t");
        assertEquals(testArticle.getJournal(), "j");
        assertEquals(testArticle.getPages(), "1-15");
        assertEquals(testArticle.getNumber(), new Integer(254));
        assertEquals(testArticle.getReleaseYear(), new Integer(1999));
        assertEquals(testArticle.getVolume(), new Integer(2));
    }
}