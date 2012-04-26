package ohtu.refero.bibtex;

import ohtu.refero.models.*;
import org.junit.Before;
import ohtu.refero.service.StringToAuthorConverter;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-database.xml"})

public class BibTeXSerializerTest {
    @Autowired
    StringToAuthorConverter converter;
    Article article;
    Book book;
    Inproceedings i;
    StringBuilder builder;
    ReferenceID refID;
    
    @Before
    public void setUp() {   
        article = new Article();
        book = new Book();
        i = new Inproceedings();
        refID = new ReferenceID();
        refID.setReferenceID("Br03");
        
        article.setReferenceID(refID);
        article.setId(1L);
        article.setAuthors(converter.convertToAuthor("Bruhn, Russel E. and Burton, Philip J."));
        article.setTitle("An approach to teaching Java using computers");
        article.setJournal("SIGCSE Bull.");
        article.setVolume(35);
        article.setNumber(4);
        article.setReleaseYear(2003);
        article.setPages("94--99");
        article.setPublisher("ACM");
        
        book.setReferenceID(refID);
        book.setId(5L);
        book.setAuthors(converter.convertToAuthor("Bruhn, Russel E. and Burton, Philip J."));
        book.setTitle("An approach to teaching Java using computers");
        book.setReleaseYear(2003);
        book.setPublisher("LUKE");
        
        i.setReferenceID(refID);
        i.setId(6L);
        i.setAuthors(converter.convertToAuthor("Bruhn, Russel E. and Burton, Philip J."));
        i.setTitle("An approach to teaching Java using computers");
        i.setBookTitle("SKYWALKER");
        i.setPages("1--5");
        i.setReleaseYear(2003);
        i.setPublisher("LUKE");
        
        builder = new StringBuilder();
    }
    
    @Test
    public void serializeArticle() throws NoIdException {       
        builder.append("@article{Br03,\n");
        builder.append("  authors = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("  journal = {SIGCSE Bull.},\n");
        builder.append("  number = {4},\n");
        builder.append("  pages = {94--99},\n");
        builder.append("  publisher = {ACM},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers},\n");
        builder.append("  volume = {35}\n");
        builder.append("}");
        
        
        String expected = builder.toString();
        System.out.println(expected);
        String actual = BibTeXSerializer.serialize(article);
        System.out.println(actual);
        
        assertEquals(expected, actual);          
    }
    
    @Test
    public void serializeBook() throws NoIdException {       
        builder.append("@book{Br03,\n");
        builder.append("  authors = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("  publisher = {LUKE},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers}\n");
        builder.append("}");
        
        String expected = builder.toString();
        String actual = BibTeXSerializer.serialize(book);
        
        assertEquals(expected, actual);          
    }
    
    @Test
    public void serializeInproceedings() throws NoIdException {
        builder.append("@inproceedings{Br03,\n");
        builder.append("  authors = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("  booktitle = {SKYWALKER},\n");
        builder.append("  pages = {1--5},\n");
        builder.append("  publisher = {LUKE},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers}\n");     
        builder.append("}");
        
        String expected = builder.toString();
        String actual = BibTeXSerializer.serialize(i);
        
        assertEquals(expected, actual); 
    }
    
    @Test
    public void doesNotAcceptNullPointers() {
        try {
            BibTeXSerializer.serialize(new BibTeXSerializerTest());
            fail("BibTeXSerializer should throw a new NoIdException");
        } catch (Exception e) {         
        }
    }
    
    @Test
    public void doesNotWriteEmptyStrings() throws NoIdException {
        article.setPublisher("");
        
        builder.append("@article{1,\n");
        builder.append("  author = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("  journal = {SIGCSE Bull.},\n");
        builder.append("  number = {4},\n");
        builder.append("  pages = {94--99},\n");
        builder.append("  publisher = {},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers},\n");
        builder.append("  volume = {35}\n");
        builder.append("}");
        
        assertFalse(builder.toString().equals(BibTeXSerializer.serialize(article)));
    }
    
}