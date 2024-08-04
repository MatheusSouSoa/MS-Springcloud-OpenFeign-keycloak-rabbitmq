package com.springcloud.kleycloak.mscartoes.infrastructure.web.dtos;

import com.springcloud.kleycloak.mscartoes.domain.enums.BandeiraCartao;

import java.math.BigDecimal;

public record CartaoSaveRequest(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limite) {
}
