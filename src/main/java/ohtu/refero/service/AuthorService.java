package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Author;

public interface AuthorService {

    public Author save(Author author);

    public List<Author> findAll();

    public Author findById(Long id);
}
