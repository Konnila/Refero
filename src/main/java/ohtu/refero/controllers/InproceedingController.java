/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.controllers;

import java.util.List;
import javax.validation.Valid;
import ohtu.refero.bibtex.BibTeXSerializer;
import ohtu.refero.bibtex.NoIdException;
import ohtu.refero.models.Article;
import ohtu.refero.models.Author;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.service.ArticleService;
import ohtu.refero.service.AuthorService;
import ohtu.refero.service.InproceedingsService;
import ohtu.refero.service.StringToAuthorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
public class InproceedingController {
    @Autowired
    StringToAuthorConverter authorConv;
    @Autowired
    AuthorService authorServ;
    @Autowired
    InproceedingsService inprocService;
    
    @RequestMapping(value = "inproceeding", method = RequestMethod.GET)
    public String directToForm(Model model) {   
        model.addAttribute("inproceedingForm", new Inproceedings());
        return "new_inproceeding";
    }
    
    @RequestMapping(value = "inproceeding/{id}", method = RequestMethod.GET)
    public String getInproceeding(@PathVariable Long id, Model model) {
        
        Inproceedings inproceedings = inprocService.findById(id);
        String bibtex = null;
        
        try {
            bibtex = BibTeXSerializer.serialize(inproceedings);
        } catch (NoIdException ex) {}
        
        model.addAttribute("inproceedings", inproceedings);
        model.addAttribute("bibtex", bibtex);
        
        return "inproceedings";
    }
    
    @RequestMapping(value = "inproceeding", method = RequestMethod.POST)
    public String postInproceeding(@RequestParam String author, @Valid @ModelAttribute("inproceedingForm") Inproceedings inproceedings, BindingResult result) {    
        FieldError fe = new FieldError("author","author", "Author field may not be empty");
        if(author.isEmpty()) result.addError(fe);
        if (result.hasErrors())
            return "new_inproceeding";
        List<Author> auth = authorConv.convertToAuthor(author);
        List<Author> seivatut = authorServ.save(auth);
        inproceedings.setAuthors(seivatut);
        inprocService.save(inproceedings);
        return "redirect:/";
    }
}