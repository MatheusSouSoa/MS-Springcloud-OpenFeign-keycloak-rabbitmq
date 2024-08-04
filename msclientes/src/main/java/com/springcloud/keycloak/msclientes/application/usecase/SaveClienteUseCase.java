package com.springcloud.keycloak.msclientes.application.usecase;

import com.springcloud.keycloak.msclientes.domain.model.Cliente;
import com.springcloud.keycloak.msclientes.infra.persistence.JpaClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SaveClienteUseCase {

    private final JpaClienteRepository repository;

    @Transactional
    public Cliente execute(Cliente cliente) {
        return repository.save(cliente);
    }
}
