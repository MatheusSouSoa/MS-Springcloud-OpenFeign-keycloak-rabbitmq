package com.springcloud.keycloak.msclientes.application.service;

import com.springcloud.keycloak.msclientes.domain.model.Cliente;
import com.springcloud.keycloak.msclientes.infra.persistence.JpaClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final JpaClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
