package ohtu.refero.models;

import com.sun.crypto.provider.ARCFOURCipher;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AuthorTest {

    Author a;
    List<Article> articles;
    List<Inproceedings> inproceedings;
    List<Book> books;

    @Before
    public void initialize() {
        a = new Author();
        articles = new ArrayList<Article>();
        inproceedings = new ArrayList<Inproceedings>();
        books = new ArrayList<Book>();
        
        articles.add(new Article());
        inproceedings.add(new Inproceedings());
        books.add(new Book());
        
        a.setFirstName("kontsa");
        a.setSurName("toniboy");
        
        a.setArticleReferenceList(articles);
        a.setBookReferenceList(books);
        a.setInproceedingsReferenceList(inproceedings);
    }

    @Test
    public void isNew() {
        Author b = new Author();
        assertTrue(b.isNew());
    }

    @Test
    public void gettersAndSetters() {
        assertEquals(a.getFirstName(), "kontsa");
        assertEquals(a.getSurName(), "toniboy");
        assertEquals(a.getArticleReferenceList().toString(), articles.toString());
        assertEquals(a.getBookReferenceList().toString(), books.toString());
        assertEquals(a.getInproceedingsReferenceList().toString(), inproceedings.toString());
    }
}
