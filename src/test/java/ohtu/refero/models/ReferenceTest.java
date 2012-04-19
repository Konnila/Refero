package ohtu.refero.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class ReferenceTest {
    
    Reference testReference = mock(Reference.class);
    
    @Before
    public void initialize() {   
        testReference = new Article();
        testReference.setAuthor("author");
        testReference.setTitle("t");
        testReference.setReleaseYear(new Integer(1999));
        testReference.setPublisher("Luke");
        testReference.setAddress("kuNpula");
        testReference.setId(Long.MIN_VALUE);
    }
    
    @Test
    public void gettersAndSetters() {       
        assertEquals(testReference.getAuthor(), "author");
        assertEquals(testReference.getTitle(), "t");       
        assertEquals(testReference.getReleaseYear(), new Integer(1999));       
        assertEquals(testReference.getAddress(), "kuNpula");
        assertEquals(testReference.getPublisher(), "Luke");
    }
    
    @Test
    public void equalsIsValid() {      
        Article article = new Article();
        Article b = new Article();
    
        //obj == null
        assertEquals(article.equals(null), false);
        
        //getClass() != obj.getClass()
        assertEquals(article.equals(new ArticleTest()), false);
       
        //other.getId() == null
        article.setId(null);
        b.setId(Long.MAX_VALUE);
        assertFalse(article.equals(b));

        //this.getId() == null
        assertFalse(b.equals(article));
        
        //this.getId() != other.getId()
        article.setId(Long.MIN_VALUE);      
        assertFalse(article.equals(b));
        
        //this.getId() == other.getId() 
        assertTrue(article.equals(article));    
        
    }
}
