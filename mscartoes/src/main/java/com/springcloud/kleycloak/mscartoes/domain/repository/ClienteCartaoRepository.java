package com.springcloud.kleycloak.mscartoes.domain.repository;

import com.springcloud.kleycloak.mscartoes.domain.models.ClienteCartao;

import java.util.List;

public interface ClienteCartaoRepository {
    List<ClienteCartao> findByCpf(String cpf);
}
