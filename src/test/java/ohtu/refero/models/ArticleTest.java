package ohtu.refero.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class ArticleTest {
 
    Article a;
    
    @Before
    public void initialize() {
        a = new Article();
        a.setAuthor("author");
        a.setTitle("t");
        a.setJournal("j");
        a.setNumber(254);
        a.setReleaseYear(1999);
        a.setVolume(2);
        a.setId(Long.MIN_VALUE);
    }
    
    @Test
    public void gettersAndSetters() {
        assertEquals(a.getAuthor(), "author");
        assertEquals(a.getTitle(), "t");
        assertEquals(a.getJournal(), "j");       
        assertEquals(a.getNumber(), 254);       
        assertEquals(a.getReleaseYear(), 1999);       
        assertEquals(a.getVolume(), 2);     
    }
    
    @Test
    public void equalsIsValid() {
        Article b = new Article();
        b.setId(a.getId());
        assertEquals(b.equals(a), true);    
        assertEquals(b.equals(null), false);
        assertEquals(b.equals(new ArticleTest()), false);
       
        b.setId(Long.MAX_VALUE);      
        assertEquals(b.equals(a), false);
        b.setId(null);
        assertEquals(b.equals(a), false);
    }
    
}