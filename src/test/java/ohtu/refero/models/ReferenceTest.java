package ohtu.refero.models;

import java.util.ArrayList;
import java.util.List;
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
        List<Author> authors = new ArrayList<Author>();
        Author author = new Author();
        author.setFirstName("Kalle");
        author.setSurName("Havumaki");
        authors.add(author);
        testReference.setAuthors(authors);
        testReference.setTitle("t");
        testReference.setReleaseYear(new Integer(1999));
        testReference.setPublisher("Luke");
        testReference.setAddress("kuNpula");
        testReference.setId(Long.MIN_VALUE);
    }

    @Test
    public void gettersAndSetters() {
         List<Author> authors = new ArrayList<Author>();
        Author author = new Author();
        author.setFirstName("Kalle");
        author.setSurName("Havumaki");
        authors.add(author);
        assertEquals(testReference.getAuthors(), authors);
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
