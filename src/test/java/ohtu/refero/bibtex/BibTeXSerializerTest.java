package ohtu.refero.bibtex;

import ohtu.refero.models.Article;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BibTeXSerializerTest {

    private Article article;
    
    public BibTeXSerializerTest() {
        
        article = new Article();
        
        article.setId(1L);
        article.setAuthor("Bruhn, Russel E. and Burton, Philip J.");
        article.setTitle("An approach to teaching Java using computers");
        article.setJournal("SIGCSE Bull.");
        article.setVolume(35);
        article.setNumber(4);
        article.setReleaseYear(2003);
        article.setPages("94--99");
        article.setPublisher("ACM");
    }
    
    @Test
    public void serialize() throws NoIdException {
        
        StringBuilder builder = new StringBuilder();
        
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
}