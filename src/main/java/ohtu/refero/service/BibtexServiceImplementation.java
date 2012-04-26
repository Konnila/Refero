package ohtu.refero.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.refero.bibtex.BibTeXSerializer;
import ohtu.refero.bibtex.NoIdException;
import ohtu.refero.models.*;
import ohtu.refero.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BibtexServiceImplementation implements BibtexService {

    @Autowired
    InproceedingsService inprocService;
    @Autowired
    ArticleService articleService;
    @Autowired
    BookService bookService;

    @Override
    public String findAll() {
        StringBuilder builder = new StringBuilder();
        List<Article> articles = articleService.findAll();
        List<Inproceedings> inproceedings = inprocService.findAll();
        List<Book> books = bookService.findAll();
        try {
            for (Book book : books) {
                builder.append(BibTeXSerializer.serialize(book) + "\n\n");
            } for (Article a : articles) {
                builder.append(BibTeXSerializer.serialize(a) + "\n\n");
            } for (Inproceedings i : inproceedings) {
                builder.append(BibTeXSerializer.serialize(i) + "\n\n");
            }
        } catch (NoIdException ex) {
        }
        return builder.toString();
    }
}