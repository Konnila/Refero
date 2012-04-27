/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml",
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class StringToAuthorConverterTest {
    
    @Autowired
    StringToAuthorConverter s;
    String authors;
    
    @Before
    public void setUp() {
        authors = "Konnilan Pony, Hirvikoskessa Kasperboy";
    }
    
    @Test
    public void generateAuthors() {
        assertEquals(s.convertToAuthor(authors).size(), 2);
    }
    
    @Test
    public void generateShortAuthor() {
        assertEquals(s.convertToAuthor("Ab").size(), 1);
        assertEquals(s.convertToAuthor("").size(), 1);
    }
    
}
