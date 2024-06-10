package iut.but3.Hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livre {
    //Attributs
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //il faut qu'il soit devant les attribut qu'il prend comme valeurs
    private String titre;
    private String editeur;


    //constructeur vide
    public Livre() {}

    //constructeur non vide sans l'id
    public Livre(String titre, String editeur) {
        this.titre = titre;
        this.editeur = editeur;
    }

    //getters et setters
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getEditeur() {
        return editeur;
    }
    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    //toString
    public String toString() {
        //recupérer l'id d'un livre : 
        return " Id : " + id +"Titre : " + titre + " Editeur : " + editeur;
    }
}