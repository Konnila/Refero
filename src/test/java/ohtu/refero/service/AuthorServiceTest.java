
package ohtu.refero.service;

import java.util.ArrayList;
import java.util.List;
import ohtu.refero.models.Article;
import ohtu.refero.models.Author;
import ohtu.refero.models.Book;
import ohtu.refero.models.Inproceedings;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class AuthorServiceTest {
    
    @Autowired
    AuthorService authorRepo;
    Author testAuthor;

    @Before
    public void initialize() {
        testAuthor = new Author();
        testAuthor.setFirstName("KONNA");
        testAuthor.setSurName("KONNILA");       
    }

    @Test
    public void addAndfindAuthorTest() {
        testAuthor = authorRepo.save(testAuthor);      
        assertTrue(testAuthor.getFirstName().equals("KONNA"));
    }
    
    @Test
    public void addManyAuthors() {
        Author another = new Author();
        another.setFirstName("kasper");
        another.setSurName("sf");
        
        List<Author> authors = new ArrayList<Author>();
        authors.add(another);
        authors.add(another);
        authors.add(testAuthor);
        authorRepo.save(another);
        
        assertTrue(authorRepo.save(authors).size() == 3);   
    }
    
    @Test
    public void findByID() {
        testAuthor.setId(25L);
        authorRepo.save(testAuthor);
        assertEquals(authorRepo.findById(25L).getFirstName(), testAuthor.getFirstName());
    }
}
