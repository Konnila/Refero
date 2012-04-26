package ohtu.refero.controllers;

import java.util.List;
import ohtu.refero.models.Author;
import ohtu.refero.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    @RequestMapping("authors")
    public String getAuthors(Model model) {
        
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        
        return "authors";
    }

}
