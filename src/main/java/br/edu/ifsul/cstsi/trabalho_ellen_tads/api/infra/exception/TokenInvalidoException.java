package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.infra.exception;

public class TokenInvalidoException extends RuntimeException {
    public TokenInvalidoException(String mensagem) {
        super(mensagem);
    }
}
