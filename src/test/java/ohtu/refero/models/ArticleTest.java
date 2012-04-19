package ohtu.refero.models;

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
        testArticle.setAuthor("author");
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
        
        assertEquals(testArticle.getAuthor(), "author");
        assertEquals(testArticle.getTitle(), "t");
        assertEquals(testArticle.getJournal(), "j");
        assertEquals(testArticle.getPages(), "1-15");
        assertEquals(testArticle.getNumber(), new Integer(254));       
        assertEquals(testArticle.getReleaseYear(), new Integer(1999));       
        assertEquals(testArticle.getVolume(), new Integer(2));     
    }   
}