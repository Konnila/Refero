/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import java.util.ArrayList;
import java.util.List;
import ohtu.refero.models.*;
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
public class ReferenceGeneratorTest {

    @Autowired
    BookService bookServ;
    @Autowired
    ReferenceGenerator refGen;
    Book book;
    ReferenceID refID;
    @Autowired
    StringToAuthorConverter authorConv;
    @Autowired
    AuthorService authorServ;

    @Before
    public void initialize() {
        book = new Book();
        refID = new ReferenceID();

    }

    @Test
    public void referenceOnOneBook() {
        List<Author> authors = new ArrayList<Author>();
        Author author = new Author();
        author.setFirstName("Kasper");
        author.setSurName("Hirvikoski");
        authors.add(author);
        book.setAuthors(authors);
        book.setTitle("Ulinoita");
        book.setPublisher("Kum-pula");
        book.setReleaseYear(2010);
        book.setReferenceID(refGen.generateReferenceId(book));
        refID.setReferenceID("Hi10");
        assertEquals(refID, book.getReferenceID());
    }

    @Test
    public void referenceOnTwoReferenceConflictingBooks() {
        String author = "Toni Konnila";
        List<Author> auth = authorConv.convertToAuthor(author);
        List<Author> saved = authorServ.save(auth);
        book.setAuthors(saved);
        book.setTitle("Ulinoita");
        book.setPublisher("Kum-pula");
        book.setReleaseYear(2010);
        Long id = bookServ.save(book).getId();
        
        assertEquals(bookServ.findById(id).getReferenceID().getReferenceID(),"Ko10");
      
        author = "Tommi Komola";
        auth = authorConv.convertToAuthor(author);
        saved = authorServ.save(auth);
        Book book2 = new Book();
        book2.setAuthors(saved);
        book2.setTitle("Uskomattomia tarinoita");
        book2.setPublisher("Kumpulan kiroukset");
        book2.setReleaseYear(2010);
        id = bookServ.save(book2).getId();
        
        assertEquals(bookServ.findById(id).getReferenceID().getReferenceID(),"Ko10a");



    }
}
