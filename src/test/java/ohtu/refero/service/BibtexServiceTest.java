package ohtu.refero.service;
import ohtu.refero.models.Article;
import ohtu.refero.models.Book;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.models.ReferenceID;
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
    InproceedingsService inprocService;
    @Autowired
    ArticleService articleService;
    @Autowired
    BookService bookService;
    @Autowired
    BibtexService bibtexService;
    
    Article testArticle;
    Book testBook;
    Inproceedings testI;
    ReferenceID refID;
    
    StringBuilder builder;
    

    @Before
    public void initialize() {
        testArticle = new Article();
        testBook = new Book();
        testI = new Inproceedings();
        refID = new ReferenceID();
        refID.setReferenceID("Br03");
        
        testArticle.setReferenceID(refID);
        testArticle.setId(1L);
        testArticle.setAuthor("Bruhn, Russel E. and Burton, Philip J.");
        testArticle.setTitle("An approach to teaching Java using computers");
        testArticle.setJournal("SIGCSE Bull.");
        testArticle.setVolume(35);
        testArticle.setNumber(4);
        testArticle.setReleaseYear(2003);
        testArticle.setPages("94--99");
        testArticle.setPublisher("ACM");
        
        testBook.setReferenceID(refID);
        testBook.setId(5L);
        testBook.setAuthor("Bruhn, Russel E. and Burton, Philip J.");
        testBook.setTitle("An approach to teaching Java using computers");
        testBook.setReleaseYear(2003);
        testBook.setPublisher("LUKE");
        
        testI.setReferenceID(refID);
        testI.setId(6L);
        testI.setAuthor("Bruhn, Russel E. and Burton, Philip J.");
        testI.setTitle("An approach to teaching Java using computers");
        testI.setBookTitle("SKYWALKER");
        testI.setPages("1--5");
        testI.setReleaseYear(2003);
        testI.setPublisher("LUKE");
        
        builder = new StringBuilder();
    }

    
    @Test
    public void testFindAllMethod() {
        //articleService.save(testArticle);
        bookService.save(testBook);
        inprocService.save(testI);
        
        builder.append("@article{Br03,\n");
        builder.append("  author = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("  journal = {SIGCSE Bull.},\n");
        builder.append("  number = {4},\n");
        builder.append("  pages = {94--99},\n");
        builder.append("  publisher = {ACM},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers},\n");
        builder.append("  volume = {35}\n");
        builder.append("}\n\n");  
        
        builder.append("@book{Br03a,\n");
        builder.append("  author = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("  publisher = {LUKE},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers}\n");
        builder.append("}\n\n");
        
        builder.append("@inproceedings{Br03b,\n");
        builder.append("  author = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("  booktitle = {SKYWALKER},\n");
        builder.append("  pages = {1--5},\n");
        builder.append("  publisher = {LUKE},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers}\n");     
        builder.append("}\n\n");
        
        assertEquals(builder.toString(), bibtexService.findAll());
    }
   
}