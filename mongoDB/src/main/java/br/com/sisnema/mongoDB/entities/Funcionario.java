package br.com.sisnema.mongoDB.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Funcionario {

    @Id
    private String id;
    private String nome;
    private Integer idade;
    private Double salario;

}
