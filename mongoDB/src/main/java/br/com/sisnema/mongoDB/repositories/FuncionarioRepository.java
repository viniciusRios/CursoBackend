package br.com.sisnema.mongoDB.repositories;

import br.com.sisnema.mongoDB.entities.Funcionario;
import br.com.sisnema.mongoDB.entities.Setor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

}
