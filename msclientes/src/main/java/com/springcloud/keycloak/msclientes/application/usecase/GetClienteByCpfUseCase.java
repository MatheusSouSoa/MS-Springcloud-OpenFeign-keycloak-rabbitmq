package com.springcloud.keycloak.msclientes.application.usecase;

import com.springcloud.keycloak.msclientes.domain.model.Cliente;
import com.springcloud.keycloak.msclientes.infra.persistence.JpaClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetClienteByCpfUseCase {

    private final JpaClienteRepository repository;

    public Optional<Cliente> execute(String cpf) {
        return repository.findByCpf(cpf);
    }
}
