package ohtu.refero.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Author extends JPAObject {

    private String firstName;
    private String surName;
    
    @ManyToMany
    List<Article> articleReferenceList;
    
    @ManyToMany
    List<Book> bookReferenceList;
    
    @ManyToMany
    List<Inproceedings> inproceedingsReferenceList;

    public Author() {
        bookReferenceList = new ArrayList<Book>();
        articleReferenceList = new ArrayList<Article>();
        inproceedingsReferenceList = new ArrayList<Inproceedings>();
    }
    
    public List<Article> getArticleReferenceList() {
        return articleReferenceList;
    }

    public void setArticleReferenceList(List<Article> articleReferenceList) {
        this.articleReferenceList = articleReferenceList;
    }

    public List<Book> getBookReferenceList() {
        return bookReferenceList;
    }

    public void setBookReferenceList(List<Book> bookReferenceList) {
        this.bookReferenceList = bookReferenceList;
    }

    public List<Inproceedings> getInproceedingsReferenceList() {
        return inproceedingsReferenceList;
    }

    public void setInproceedingsReferenceList(List<Inproceedings> inproceedingsReferenceList) {
        this.inproceedingsReferenceList = inproceedingsReferenceList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        
        if (firstName == null) {
            return surName;
        }
        
        return firstName + " " + surName;
    }
}
