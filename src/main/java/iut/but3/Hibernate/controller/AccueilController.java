package iut.but3.Hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccueilController {
    @GetMapping("/")
    
    public String accueil(ModelMap map, @RequestParam(required=false, defaultValue="valParDefaut")String nom) {
        map.put("nom", nom);
        return "hibernate/accueil";
    }
}
