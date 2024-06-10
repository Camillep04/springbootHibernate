package iut.but3.Hibernate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;

import iut.but3.Hibernate.model.Livre;
import iut.but3.Hibernate.repository.LivreRepository;

@Controller
public class LivreController {
    @Autowired
    private LivreRepository livreRepository;
    
    @GetMapping("/livre-ajouter")
    @ResponseBody
    public String ajouterLivre() {
        Livre livre = new Livre("keleana", "Maas");
        livreRepository.save(livre);
        return "Livre ajouté";
    }

    @GetMapping("/livre-liste")
    public String list(ModelMap map) {
        List<Livre> livres = livreRepository.findAll();
        map.put("livres", livres);
        return "hibernate/livre/livreListe";
    }

    @GetMapping("/livre/detail")
    public String getLivre(@RequestParam("id") Integer id, ModelMap map) {
        Optional<Livre> livreOptional = livreRepository.findById(id);
        if (livreOptional.isPresent()) {
            Livre livre = livreOptional.get();
            map.put("livre", livre);
            return "hibernate/livre/livreDetail";
        } else {
            map.put("message", "Livre non trouvé");
            return "error"; // Vous pouvez avoir un template 'error.html' pour les messages d'erreur
        }
    }

    @GetMapping("/livre/supprimer")
    @ResponseBody
    public String supprimer(@RequestParam Integer id) {
        Optional<Livre> livreOptional = livreRepository.findById(id);
        if (livreOptional.isPresent()) {
            livreRepository.deleteById(id);
            return "Supprimé avec succès";
        } else {
            return "Livre non trouvé";
        }
    }

    @GetMapping("/livre/modifier")
    @ResponseBody
    public String modifier(@RequestParam Integer id, @RequestParam String titre, @RequestParam String editeur) {
        Optional<Livre> livreOptional = livreRepository.findById(id);
        if (livreOptional.isPresent()) {
            Livre livre = livreOptional.get();
            livre.setTitre(titre);
            livre.setEditeur(editeur);
            livreRepository.save(livre);
            return "Livre modifié";
        } else {
            return "Livre non trouvé";
        }
    }
}
