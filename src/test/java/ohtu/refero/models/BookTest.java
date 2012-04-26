package ohtu.refero.models;

import ohtu.refero.service.StringToAuthorConverter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class BookTest {

    Book book;

    @Before
    public void initialize() {
        book = new Book();
        book.setPublisher("Martti A");
    }

    @Test
    public void isNew() {
        Book b = new Book();
        assertTrue(b.isNew());
    }

    @Test
    public void gettersAndSetters() {
        assertEquals(book.getPublisher(), "Martti A");
    }
}
