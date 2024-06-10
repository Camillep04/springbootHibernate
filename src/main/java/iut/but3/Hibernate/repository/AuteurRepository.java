package iut.but3.Hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import iut.but3.Hibernate.model.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Integer>{
    
}
