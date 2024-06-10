package iut.but3.Hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Auteur {
    //Attributs
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //il faut qu'il soit devant les attribut qu'il prend comme valeurs
    private String nom;
    private String prenom;


    //constructeur vide
    public Auteur() {}

    //constructeur non vide sans l'id
    public Auteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    //getters et setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //toString
    public String toString() {
        //recupérer l'id d'un auteur : 
        return "Id : " + id + " Nom : " + nom + " Prénom : " + prenom;
    }
}