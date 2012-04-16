package ohtu.refero.controllers;

import java.util.List;
import ohtu.refero.models.Article;
import ohtu.refero.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleServ;
    
    
    @RequestMapping(value="article", method= RequestMethod.GET)
    public String directToForm(Model model) {
        model.addAttribute("articleForm", new Article());
        return "new_article";
    }
    
    @RequestMapping(value="article", method= RequestMethod.POST)
    public String dealWithForm(@ModelAttribute("articleForm") Article article) {
        if (article == null)
            return "redirect:/article";
        articleServ.addArticle(article);
        return "redirect:/";
    }
    

    

}