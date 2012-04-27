
package ohtu.refero.service;

import java.util.ArrayList;
import java.util.List;
import ohtu.refero.models.*;
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
    Article testArticle;
    Book book;
    Inproceedings i;

    @Before
    public void initialize() {
        testAuthor = new Author();
        testAuthor.setFirstName("KONNA");
        testAuthor.setSurName("KONNILA");       

        testArticle = new Article();           
        book = new Book();           
        i = new Inproceedings();
        
        testArticle.setTitle("artikkeli");
        testArticle.setTitle("An approach to teaching Java using computers");
        testArticle.setJournal("SIGCSE Bull.");
        testArticle.setVolume(35);
        testArticle.setNumber(4);
        testArticle.setReleaseYear(2003);

        book.setTitle("kirja");
        book.setId(5L);
        book.setTitle("An approach to teaching Java using computers");
        book.setReleaseYear(2003);
        book.setPublisher("LUKE");
        
        i.setTitle("inpronoob");
        i.setTitle("An approach to teaching Java using computers");
        i.setBookTitle("SKYWALKER");
        i.setPages("1--5");
        i.setReleaseYear(2003);
        i.setPublisher("LUKE");
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
    
    @Test
    public void setAuthorOnReferences() {
        testAuthor.setId(25L);
        authorRepo.save(testAuthor);
        authorRepo.setArticle(25L, testArticle);
        authorRepo.setBook(25L, book);
        authorRepo.setInproceedings(25L, i);
        assertEquals(authorRepo.findById(25L).getArticleReferenceList().size(), 1);
        assertEquals(authorRepo.findById(25L).getBookReferenceList().size(), 1);
        assertEquals(authorRepo.findById(25L).getInproceedingsReferenceList().size(), 1);
    }
    
    @Test
    public void findAllAuthors() {
        assertTrue(authorRepo.findAll() != null);
    }
}
