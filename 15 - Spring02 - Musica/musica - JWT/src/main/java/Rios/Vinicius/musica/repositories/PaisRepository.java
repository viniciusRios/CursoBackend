package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>  {

}
