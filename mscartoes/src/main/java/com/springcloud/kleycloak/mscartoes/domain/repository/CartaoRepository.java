package com.springcloud.kleycloak.mscartoes.domain.repository;

import com.springcloud.kleycloak.mscartoes.domain.models.Cartoes;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoRepository {
    List<Cartoes> findByRendaLessThanEqual(BigDecimal rendaBigDecimal);
}
