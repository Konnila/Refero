package ohtu.refero.service;

import ohtu.refero.models.Book;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class BookServiceTest {

    @Autowired
    BookService bookRepo;
    @Autowired
    StringToAuthorConverter converter;
    Book testBook;

    @Before
    public void initialize() {
        testBook = new Book();
        testBook.setAuthors(converter.convertToAuthor("author aatami"));
        testBook.setTitle("t");
        testBook.setPublisher("Luke");
        testBook.setReleaseYear(1999);
        testBook.setAddress("kuNpula");
        testBook.setId(Long.MAX_VALUE);
    }

    @Test
    public void addingNullReturnsNull() {
        assertEquals(null, bookRepo.save(null));
    }

    @Test
    public void addAndfindBookTest() {
        Book book = bookRepo.save(testBook);
        assertEquals(bookRepo.findById(book.getId()), book);
    }

    @Test
    public void findAllBooks() {
        assertTrue(bookRepo.findAll() != null);
    }
}