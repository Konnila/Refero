package ohtu.refero.controllers;

import javax.validation.Valid;
import ohtu.refero.models.Article;
import ohtu.refero.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {
    
    @Autowired
    ArticleService articleService;
    
    @RequestMapping(value="article", method= RequestMethod.GET)
    public String directToForm(Model model) {   
        model.addAttribute("articleForm", new Article());
        return "new_article";
    }
    
    @RequestMapping(value="article", method= RequestMethod.POST)
    public String dealWithForm(@Valid @ModelAttribute("articleForm") Article article, BindingResult result) {    
        if (result.hasErrors())
            return "new_article";
        
        articleService.save(article);
        return "redirect:/";
    }
}