package ohtu.refero.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import ohtu.refero.bibtex.BibTeXSerializer;
import ohtu.refero.bibtex.NoIdException;
import ohtu.refero.models.Article;
import ohtu.refero.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BibtexController {
    
    @Autowired
    BibtexService bibtexServ;
    
    @RequestMapping(method = RequestMethod.GET)
    public String root(Model model) { 
        model.addAttribute("bibtex", bibtexServ.findAll());
        return "listbibtex";
    }
    
}