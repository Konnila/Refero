
package ohtu.refero.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import ohtu.refero.bibtex.BibTeXSerializer;
import ohtu.refero.bibtex.NoIdException;
import ohtu.refero.models.Author;
import ohtu.refero.models.Book;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.service.AuthorService;
import ohtu.refero.service.BookService;
import ohtu.refero.service.InproceedingsService;
import ohtu.refero.service.StringToAuthorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
    @Autowired
    StringToAuthorConverter authorConv;
    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorServ;
    
    @RequestMapping(value = "book", method = RequestMethod.GET)
    public String directToForm(Model model) {   
        model.addAttribute("bookForm", new Book());
        return "new_book";
    }
    
    @RequestMapping(value = "book/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable Long id, Model model) {
        
        Book book = bookService.findById(id);
        String bibtex = null;
        
        try {
            bibtex = BibTeXSerializer.serialize(book);
        } catch (NoIdException ex) {}
        
        model.addAttribute("book", book);
        model.addAttribute("bibtex", bibtex);
        
        return "book";
    }
    
    @RequestMapping(value = "book", method = RequestMethod.POST)
    public String postBook(@RequestParam String author, @Valid @ModelAttribute("bookForm") Book book, BindingResult result) {    
        FieldError fe = new FieldError("author","author", "Author field may not be empty");
        if(author.isEmpty()) result.addError(fe);
        if (result.hasErrors())
            return "new_book";
        List<Author> auth = authorConv.convertToAuthor(author);
        List<Author> saved = authorServ.save(auth);
        
        book.setAuthors(saved);
        Book bok = bookService.save(book);
        
        
         for (Author author1 : saved) {
            authorServ.setBook(author1.getId(), bok);
        }
//        book.setAuthors(authorServ.save(authorConv.convertToAuthor(author)));
        
//        bookService.save(book);
        return "redirect:/";
    }
}