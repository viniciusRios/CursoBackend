package Rios.Vinicius.musica.controllers.exceptions;

import Rios.Vinicius.musica.services.exceptions.IntegridadeBD;
import Rios.Vinicius.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(RecursoNaoEncontrado e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao erro = new ErroPadrao();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value());//404
        erro.setError("ERRO NA REQUISIÇÂO! 404 ");
        erro.setMessage(e.getMessage());// erro da camada de service, Recurso não encontrado
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);


    }

    @ExceptionHandler(IntegridadeBD.class)
    public ResponseEntity<ErroPadrao> integridadeBD(IntegridadeBD e, HttpServletRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erro = new ErroPadrao();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value());//400
        erro.setError("ERRO NA REQUISIÇÂO DO BD! 400 ");
        erro.setMessage(e.getMessage());// erro da camada de service, Recurso não encontrado
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);


    }
}
