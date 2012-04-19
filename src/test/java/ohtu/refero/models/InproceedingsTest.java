package ohtu.refero.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class InproceedingsTest {

    Inproceedings i;

    @Before
    public void initialize() {
        i = new Inproceedings();
        i.setPages("1--2");
        i.setBookTitle("tit");
    }

    @Test
    public void isNew() {
        Book b = new Book();
        assertTrue(b.isNew());
    }

    @Test
    public void gettersAndSetters() {
        assertEquals(i.getBookTitle(), "tit");
        assertEquals(i.getPages(), "1--2");
        i.setPages("aasd1--6");
        i.setBookTitle("title");
        assertTrue(i.getPages().equals("aasd1--6"));
        assertTrue(i.getBookTitle().equals("title"));
    }
}
