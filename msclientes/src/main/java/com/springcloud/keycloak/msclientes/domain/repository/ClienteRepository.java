package com.springcloud.keycloak.msclientes.domain.repository;

import com.springcloud.keycloak.msclientes.domain.model.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> findByCpf(String cpf);
}
