package com.springcloud.keycloak.msavaliadorcredito.domain.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cartao {

    private Long id;
    private String nome;
    private String bandeiraCartao;
    private BigDecimal limiteBasico;

}
