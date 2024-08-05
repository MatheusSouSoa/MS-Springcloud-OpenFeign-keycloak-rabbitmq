package com.springcloud.keycloak.msavaliadorcredito.exceptions;

public class ErroSolicitacaoCartaoException extends  RuntimeException{

    public ErroSolicitacaoCartaoException (String message) {
        super(message);
    }
}
