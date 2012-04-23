package ohtu.refero.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import ohtu.refero.bibtex.BibTeXSerializer;
import ohtu.refero.bibtex.NoIdException;
import ohtu.refero.models.Article;
import ohtu.refero.service.ArticleService;
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
public class ArticleController {
    
    @Autowired
    ArticleService articleService;
    
    
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
        } catch (NoIdException ex) {}
        
        model.addAttribute("article", article);
        model.addAttribute("bibtex", bibtex);
        
        return "article";
    }
    
    @RequestMapping(value = "article", method = RequestMethod.POST)
    public String postArticle(@Valid @ModelAttribute("articleForm") Article article, BindingResult result) {    
        if (result.hasErrors())
            return "new_article";
        
        articleService.save(article);
        return "redirect:/";
    }
}