package ohtu.refero.service;

import java.util.ArrayList;
import java.util.List;
import ohtu.refero.models.Author;
import ohtu.refero.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    @Override
    public Author save(Author author) {

        if (author == null) {
            return null;
        }

        author = authorRepository.save(author);

        return author;
    }

    public Author checkIfExists(Author author) {
        List<Author> allAuthors = findAll();
        for (int i = 0; i < allAuthors.size(); i++) {
            if (allAuthors.get(i).getAuthor().equals(author.getAuthor())) {
                return allAuthors.get(i);
            }
        }
        author = authorRepository.save(author);
        return author;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findOne(id);
    }
}