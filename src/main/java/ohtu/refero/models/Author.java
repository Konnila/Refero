
package ohtu.refero.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;

public class Author {
    private String author;

    @ManyToMany
    private List<Article> articleList;
    @ManyToMany
    private List<Book> bookList;
    @ManyToMany
    private List<Inproceedings> inprocList;

    public Author() {
        articleList = new ArrayList<Article>();
        bookList = new ArrayList<Book>();
        inprocList = new ArrayList<Inproceedings>();
    }
    
    
    public Author(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
}