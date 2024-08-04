package com.springcloud.keycloak.msclientes.application.service;

import com.springcloud.keycloak.msclientes.application.usecase.GetClienteByCpfUseCase;
import com.springcloud.keycloak.msclientes.application.usecase.SaveClienteUseCase;
import com.springcloud.keycloak.msclientes.domain.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final SaveClienteUseCase saveClienteUseCase;
    private final GetClienteByCpfUseCase getClienteByCpfUseCase;

    public Cliente save(Cliente cliente) {
        return saveClienteUseCase.execute(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf) {
        return getClienteByCpfUseCase.execute(cpf);
    }
}
