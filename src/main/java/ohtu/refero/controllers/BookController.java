
package ohtu.refero.controllers;

import javax.validation.Valid;
import ohtu.refero.bibtex.BibTeXSerializer;
import ohtu.refero.bibtex.NoIdException;
import ohtu.refero.models.Book;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.service.BookService;
import ohtu.refero.service.InproceedingsService;
import ohtu.refero.service.ReferenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @Autowired
    ReferenceGenerator refGen;
    
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
    public String postBook(@Valid @ModelAttribute("bookForm") Book book, BindingResult result) {
        book.setReferenceId(refGen.generateReferenceId(book,bookService));
        if (result.hasErrors())
            return "new_book";
        
        bookService.save(book);
        return "redirect:/";
    }
}