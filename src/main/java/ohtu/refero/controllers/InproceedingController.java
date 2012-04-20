/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.controllers;

import javax.validation.Valid;
import ohtu.refero.bibtex.BibTeXSerializer;
import ohtu.refero.bibtex.NoIdException;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.service.InproceedingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InproceedingController {
    
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
    public String postInproceeding(@Valid @ModelAttribute("inproceedingForm") Inproceedings inproceedings, BindingResult result) {    
        if (result.hasErrors())
            return "new_inproceeding";
        
        inprocService.save(inproceedings);
        return "redirect:/";
    }
}