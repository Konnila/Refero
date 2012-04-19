package ohtu.refero.bibtex;

import org.junit.Before;
import ohtu.refero.models.Article;
import ohtu.refero.models.Book;
import ohtu.refero.models.Inproceedings;
import static org.junit.Assert.*;
import org.junit.Test;

public class BibTeXSerializerTest {

    private Article article;
    private Book book;
    private Inproceedings i;
    private StringBuilder builder;
    
    @Before
    public void setUp() {   
        article = new Article();
        book = new Book();
        i = new Inproceedings();
        
        article.setId(1L);
        article.setAuthor("Bruhn, Russel E. and Burton, Philip J.");
        article.setTitle("An approach to teaching Java using computers");
        article.setJournal("SIGCSE Bull.");
        article.setVolume(35);
        article.setNumber(4);
        article.setReleaseYear(2003);
        article.setPages("94--99");
        article.setPublisher("ACM");
        
        book.setId(5L);
        book.setAuthor("Bruhn, Russel E. and Burton, Philip J.");
        book.setTitle("An approach to teaching Java using computers");
        book.setReleaseYear(2003);
        book.setPublisher("LUKE");
        
        i.setId(6L);
        i.setAuthor("Bruhn, Russel E. and Burton, Philip J.");
        i.setTitle("An approach to teaching Java using computers");
        i.setBookTitle("SKYWALKER");
        i.setPages("1--5");
        i.setReleaseYear(2003);
        i.setPublisher("LUKE");
        
        builder = new StringBuilder();
    }
    
    @Test
    public void serializeArticle() throws NoIdException {       
        builder.append("@article{1,\n");
        builder.append("author = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("journal = {SIGCSE Bull.},\n");
        builder.append("number = {4},\n");
        builder.append("pages = {94--99},\n");
        builder.append("publisher = {ACM},\n");
        builder.append("year = {2003},\n");
        builder.append("title = {An approach to teaching Java using computers},\n");
        builder.append("volume = {35}\n");
        builder.append("}");
        
        String expected = builder.toString();
        String actual = BibTeXSerializer.serialize(article);
        
        assertEquals(expected, actual);          
    }
    
    @Test
    public void serializeBook() throws NoIdException {       
        builder.append("@book{5,\n");
        builder.append("author = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("publisher = {LUKE},\n");
        builder.append("year = {2003},\n");
        builder.append("title = {An approach to teaching Java using computers}\n");
        builder.append("}");
        
        String expected = builder.toString();
        String actual = BibTeXSerializer.serialize(book);
        
        assertEquals(expected, actual);          
    }
    
    @Test
    public void serializeInproceedings() throws NoIdException {
        builder.append("@inproceedings{6,\n");
        builder.append("author = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("booktitle = {SKYWALKER},\n");
        builder.append("pages = {1--5},\n");
        builder.append("publisher = {LUKE},\n");
        builder.append("year = {2003},\n");
        builder.append("title = {An approach to teaching Java using computers}\n");     
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
        builder.append("author = {Bruhn, Russel E. and Burton, Philip J.},\n");
        builder.append("journal = {SIGCSE Bull.},\n");
        builder.append("number = {4},\n");
        builder.append("pages = {94--99},\n");
        builder.append("publisher = {},\n");
        builder.append("year = {2003},\n");
        builder.append("title = {An approach to teaching Java using computers},\n");
        builder.append("volume = {35}\n");
        builder.append("}");
        
        assertFalse(builder.toString().equals(BibTeXSerializer.serialize(article)));
    }
    
}