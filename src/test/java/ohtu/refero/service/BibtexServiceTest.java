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
        builder = new StringBuilder();
    }

    @Test
    public void findAllBibtex() {
        
        builder.append("@article{Ha99,\n");
        builder.append("  author = {Kalle Havumaki},\n");
        builder.append("  journal = {j},\n");
        builder.append("  number = {254},\n");
        builder.append("  year = {1999},\n");
        builder.append("  title = {t},\n");
        builder.append("  volume = {2}\n");
        builder.append("}\n\n");
        
        builder.append("@article{null,\n");
        builder.append("  author = {},\n");
        builder.append("  journal = {SIGCSE Bull.},\n");
        builder.append("  number = {4},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers},\n");
        builder.append("  volume = {35}\n");
        builder.append("}\n\n");
        
        builder.append("@book{null,\n");
        builder.append("  author = {},\n");
        builder.append("  publisher = {LUKE},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers}\n");
        builder.append("}\n\n");
        
        
        builder.append("@inproceedings{null,\n");
        builder.append("  author = {},\n");
        builder.append("  booktitle = {SKYWALKER},\n");
        builder.append("  pages = {1--5},\n");
        builder.append("  publisher = {LUKE},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers}\n");     
        builder.append("}\n\n");
        
        assertEquals(bibRepo.findAll(), builder.toString());
    }

}