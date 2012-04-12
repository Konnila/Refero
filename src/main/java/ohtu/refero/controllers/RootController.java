package ohtu.refero.controllers;

import java.util.List;
import ohtu.refero.models.Article;
import ohtu.refero.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    @Autowired
    ArticleService articleServ;
    
    @RequestMapping("/")
    public String root(Model model) {
        List<Article> articles = articleServ.getArticles();
        model.addAttribute("list", articles);
        return "index";
    }
}