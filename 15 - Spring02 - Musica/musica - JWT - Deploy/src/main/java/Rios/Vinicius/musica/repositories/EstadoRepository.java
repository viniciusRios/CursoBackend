package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>  {

}
