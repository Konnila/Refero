/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ohtu.refero.models.Article;
import ohtu.refero.models.Book;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.models.ReferenceID;
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

    @Before
    public void initialize() {
        book = new Book();
        refID = new ReferenceID();
    }

    @Test
    public void referenceOnOneBook() {
        book.setAuthor("Hirvikoski Kasper");
        book.setTitle("Ulinoita");
        book.setPublisher("Kum-pula");
        book.setReleaseYear(2010);
        book.setReferenceID(refGen.generateReferenceId(book));
        refID.setReferenceID("Hi10");
        assertEquals(refID, book.getReferenceID());
    }

    @Test
    public void referenceOnTwoConflictingBooks() {
        book.setAuthor("Konnila Toni");
        book.setTitle("Jorinooita");
        book.setPublisher("Kumpu");
        book.setReleaseYear(1999);
        Long id = bookServ.save(book).getId();
        assertEquals(bookServ.findById(id).getReferenceID().getReferenceID(), "Ko99");

        book.setAuthor("Konn Ton");
        book.setTitle("Jooita");
        book.setPublisher("Kumu");
        book.setReleaseYear(1999);
        id = bookServ.save(book).getId();
        assertEquals(bookServ.findById(id).getReferenceID().getReferenceID(), "Ko99a");

        for (char i = 'a'; i <= 'z'; i++) {          
            if (i == 'z') {
                id =  bookServ.save(book).getId();
                break;
            }
            bookServ.save(book);
        }
        assertEquals(bookServ.findById(id).getReferenceID().getReferenceID(), "Ko99za");
    }
}
