package iut.but3.Hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import iut.but3.Hibernate.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer>{
    
}