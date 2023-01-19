package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>  {

}
