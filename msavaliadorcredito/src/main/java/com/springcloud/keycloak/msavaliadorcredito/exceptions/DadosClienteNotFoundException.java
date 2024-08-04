package com.springcloud.keycloak.msavaliadorcredito.exceptions;

public class DadosClienteNotFoundException extends Exception{

    public DadosClienteNotFoundException() {
        super("Dados do Cliente nâo  encontrado para o CPF informado.");
    }
}
