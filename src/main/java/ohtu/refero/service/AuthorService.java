/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Article;
import ohtu.refero.models.Author;
import ohtu.refero.models.Book;
import ohtu.refero.models.Inproceedings;


public interface AuthorService {
    public Author save(Author author);
    public List<Author> findAll();
    public Author findById(Long id);
    public List<Author> save(List<Author> authors);
    public void setArticle(Long id, Article article);
    public void setBook(Long id, Book book);
    public void setInproceedings(Long id, Inproceedings inproc);
}
