package iut.but3.Hibernate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import iut.but3.Hibernate.model.Auteur;
import iut.but3.Hibernate.repository.AuteurRepository;

@Controller
public class AuteurController {
    @Autowired
    private AuteurRepository auteurRepository;

    @GetMapping("/auteur-ajouter")
    @ResponseBody
    public String ajouterAuteur() {
        Auteur auteur = new Auteur("Prothin", "Camille");
        auteurRepository.save(auteur);
        return "Auteur ajouté";
    }

    @GetMapping("/auteur-liste")
    public String list(ModelMap map) {
        List<Auteur> auteurs = auteurRepository.findAll();
        map.put("auteurs", auteurs);
        return "hibernate/auteur/auteurListe";
    }

    @GetMapping("/auteur/detail")
    public String getAuteur(@RequestParam("id") Integer id, ModelMap map) {
        Optional<Auteur> auteurOptional = auteurRepository.findById(id);
        Auteur auteur = auteurOptional.get();
        map.put("auteur", auteur);
        return "hibernate/auteur/auteurDetail";
    }

    @GetMapping("/auteur/supprimer")
    @ResponseBody
    public String supprimer(@RequestParam Integer id) {
        Optional<Auteur> auteurOptional = auteurRepository.findById(id);
        if (auteurOptional.isPresent()) {
            auteurRepository.deleteById(id);
            return "Supprimé avec succès";
        } else {
            return "Auteur non trouvé";
        }
    }

    @GetMapping("/auteur/modifier")
    @ResponseBody
    public String modifier(@RequestParam Integer id, @RequestParam String nom, @RequestParam String prenom) {
        Optional<Auteur> auteurOptional = auteurRepository.findById(id);
        if (auteurOptional.isPresent()) {
            Auteur auteur = auteurOptional.get();
            auteur.setNom(nom);
            auteur.setPrenom(prenom);
            auteurRepository.save(auteur);
            return "Auteur modifié";
        } else {
            return "Auteur non trouvé";
        }
    }
}
