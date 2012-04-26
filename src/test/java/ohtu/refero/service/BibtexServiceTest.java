package ohtu.refero.service;
import java.util.ArrayList;
import java.util.List;
import ohtu.refero.models.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class BibtexServiceTest {

    @Autowired
    BookService bookRepo;
    @Autowired
    InproceedingsService iRepo;
    @Autowired
    BibtexService bibRepo;
    
    Article article;
    Book book;
    Inproceedings i;
    ReferenceID refID;
    StringBuilder builder;

    @Before
    public void initialize() {
        article = new Article();
        book = new Book();
        i = new Inproceedings();
        refID = new ReferenceID();
        refID.setReferenceID("Br03");
        article.setReferenceID(refID);
        article.setId(1L);
        
        List<Author> authors = new ArrayList<Author>();
        
        Author a = new Author();
        a.setSurName("Bruhn");
        authors.add(a);
        
        Author b = new Author();
        b.setFirstName("Russel");
        b.setSurName("E.");
        authors.add(b);
        
        Author c = new Author();
        c.setFirstName("Philip");
        c.setSurName("J.");
        authors.add(c);
     
        book.setReferenceID(refID);
        book.setId(5L);
        book.setAuthors(authors);
        book.setTitle("An approach to teaching Java using computers");
        book.setReleaseYear(2003);
        book.setPublisher("LUKE");
        
        i.setReferenceID(refID);
        i.setId(6L);
        i.setAuthors(authors);
        i.setTitle("An approach to teaching Java using computers");
        i.setBookTitle("SKYWALKER");
        i.setPages("1--5");
        i.setReleaseYear(2003);
        i.setPublisher("LUKE");
        
        builder = new StringBuilder();
    }

    @Test
    public void findAllBibtex() {
        bookRepo.save(book);
        iRepo.save(i);
        
        builder.append("@article{Ha99,\n");
        builder.append("  author = {Kalle Havumaki},\n");
        builder.append("  journal = {j},\n");
        builder.append("  number = {254},\n");
        builder.append("  year = {1999},\n");
        builder.append("  title = {t},\n");
        builder.append("  volume = {2}\n");
        builder.append("}\n\n");
        
        builder.append("@book{Br03,\n");
        builder.append("  author = {Bruhn, Russel E., Philip J.},\n");
        builder.append("  publisher = {LUKE},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers}\n");
        builder.append("}\n\n");
        
        builder.append("@inproceedings{Br03a,\n");
        builder.append("  author = {Bruhn, Russel E., Philip J.},\n");
        builder.append("  booktitle = {SKYWALKER},\n");
        builder.append("  pages = {1--5},\n");
        builder.append("  publisher = {LUKE},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers}\n");     
        builder.append("}\n\n");
        
        assertEquals(bibRepo.findAll(), builder.toString());
    }

}