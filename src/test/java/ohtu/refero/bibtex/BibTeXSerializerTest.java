package ohtu.refero.bibtex;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import ohtu.refero.models.Article;
import ohtu.refero.models.Author;
import ohtu.refero.models.Book;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.models.ReferenceID;
import ohtu.refero.service.StringToAuthorConverter;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BibTeXSerializerTest {
    @Autowired
    StringToAuthorConverter converter;
    private Article article;
    private Book book;
    private Inproceedings i;
    private StringBuilder builder;
    private ReferenceID refID;
    
    @Before
    public void setUp() {   
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
        
        article.setAuthors(authors);
        article.setTitle("An approach to teaching Java using computers");
        article.setJournal("SIGCSE Bull.");
        article.setVolume(35);
        article.setNumber(4);
        article.setReleaseYear(2003);
        article.setPages("94--99");
        article.setPublisher("ACM");
        
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
    public void serializeArticle() throws NoIdException {       
        builder.append("@article{Br03,\n");
        builder.append("  author = {Bruhn, Russel E., Philip J.},\n");
        builder.append("  journal = {SIGCSE Bull.},\n");
        builder.append("  number = {4},\n");
        builder.append("  pages = {94--99},\n");
        builder.append("  publisher = {ACM},\n");
        builder.append("  year = {2003},\n");
        builder.append("  title = {An approach to teaching Java using computers},\n");
        builder.append("  volume = {35}\n");
        builder.append("}");
        
        String expected = builder.toString();
        String actual = BibTeXSerializer.serialize(article);
        
        assertEquals(expected, actual);          
    }
    
    @Test
    public void serializeBook() throws NoIdException {       
        builder.append("@book{Br03,\n");
        builder.append("  author = {Bruhn, Russel E., Philip J.},\n");
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
        builder.append("  author = {Bruhn, Russel E., Philip J.},\n");
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
        builder.append("  author = {Bruhn, Russel E., Philip J.},\n");
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