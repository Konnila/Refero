package ohtu.refero.controllers;

import java.util.List;
import ohtu.refero.models.Article;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.service.ArticleService;
import ohtu.refero.service.InproceedingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
    
    @Autowired
    ArticleService articleService;
    
    @Autowired
    InproceedingsService inpService;
    
    @RequestMapping("/")
    public String root(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        List<Inproceedings> inproceedings = inpService.findAll();
        model.addAttribute("inproceedings", inproceedings);
        
        return "index";
    }
}