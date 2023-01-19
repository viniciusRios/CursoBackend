package Rios.Vinicius.musica.repositories;

import Rios.Vinicius.musica.entities.Funcao;
import Rios.Vinicius.musica.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long>  {


}
