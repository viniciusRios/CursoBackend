package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long>  {

}
