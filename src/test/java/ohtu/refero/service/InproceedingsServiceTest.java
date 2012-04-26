package ohtu.refero.service;


import java.util.ArrayList;
import java.util.List;
import ohtu.refero.models.Author;
import ohtu.refero.models.Inproceedings;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class InproceedingsServiceTest {

    @Autowired
    InproceedingsService inproceedingsRepo;
    Inproceedings testInpro;

    @Before
    public void initialize() {
        testInpro = new Inproceedings();
         List<Author> authors = new ArrayList<Author>();
        Author author = new Author();
        author.setFirstName("Kalle");
        author.setSurName("Havumaki");
        authors.add(author);
        testInpro.setAuthors(authors);
        testInpro.setTitle("t");
        testInpro.setBookTitle("Book");
        testInpro.setPages("1--5");
        testInpro.setPublisher("Luke");
        testInpro.setReleaseYear(1999);
        testInpro.setAddress("kuNpula");
        testInpro.setId(Long.MAX_VALUE);
    }

    @Test
    public void addingNullReturnsNull() {
        assertEquals(null, inproceedingsRepo.save(null));
    }

    @Test
    public void addAndfindInproceedingsTest() {
        Inproceedings i = inproceedingsRepo.save(testInpro);
        assertEquals(inproceedingsRepo.findById(i.getId()), i);
    }
    
    @Test
    public void findAllBooks() {
        assertTrue(inproceedingsRepo.findAll() != null);
    }
}