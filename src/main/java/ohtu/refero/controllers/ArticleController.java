package ohtu.refero.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import ohtu.refero.bibtex.BibTeXSerializer;
import ohtu.refero.bibtex.NoIdException;
import ohtu.refero.models.Article;
import ohtu.refero.models.Author;
import ohtu.refero.service.ArticleService;
import ohtu.refero.service.AuthorService;
import ohtu.refero.service.StringToAuthorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleController {
    @Autowired
    StringToAuthorConverter authorConv;
    @Autowired
    ArticleService articleService;
    @Autowired
    AuthorService authorServ;
    
    @RequestMapping(value = "article", method = RequestMethod.GET)
    public String directToForm(Model model) {
        model.addAttribute("articleForm", new Article());
        return "new_article";
    }

    @RequestMapping(value = "article/{id}", method = RequestMethod.GET)
    public String getArticle(@PathVariable Long id, Model model) {

        Article article = articleService.findById(id);
        String bibtex = null;

        try {
            bibtex = BibTeXSerializer.serialize(article);
        } catch (NoIdException ex) {
        }

        model.addAttribute("article", article);
        model.addAttribute("bibtex", bibtex);

        return "article";
    }

    @RequestMapping(value = "article", method = RequestMethod.POST)
    public String postArticle(@RequestParam String author, @Valid @ModelAttribute("articleForm") Article article, BindingResult result) {
        FieldError fe = new FieldError("articleForm", "author", "Author field may not be empty");
        if (author.isEmpty()) {
            result.addError(fe);
        }
        if (result.hasErrors()) {
            return "new_article";
        }
        List<Author> auth = authorConv.convertToAuthor(author);   
        List<Author> saved = authorServ.save(auth);
             
        article.setAuthors(saved);
        Article art = articleService.save(article);
        
         for (Author author1 : saved) {
            authorServ.setArticle(author1.getId(), art);
        }
        
        
        return "redirect:/";
    }
}