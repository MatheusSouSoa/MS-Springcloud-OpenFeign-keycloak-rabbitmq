package com.springcloud.kleycloak.mscartoes.infrastructure.web.dtos;


import java.math.BigDecimal;

public record CartoesPorClienteResponse(String nome, String bandeira, BigDecimal limiteLiberado) {
}
