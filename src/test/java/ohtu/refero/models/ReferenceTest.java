package ohtu.refero.models;

import ohtu.refero.service.StringToAuthorConverter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-database.xml"})


public class ReferenceTest {
    
    @Autowired
    StringToAuthorConverter converter;
    Reference testReference = mock(Reference.class);
    
    @Before
    public void initialize() {   
        testReference = new Article();
        testReference.setAuthors(converter.convertToAuthor("Pertti Erapertti"));
        testReference.setTitle("t");
        testReference.setReleaseYear(new Integer(1999));
        testReference.setPublisher("Luke");
        testReference.setAddress("kuNpula");
        testReference.setId(25l);
    }
    
    @Test
    public void gettersAndSetters() {       
        assertEquals(testReference.getAuthors().toString(), converter.convertToAuthor("Pertti Erapertti").toString());
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
