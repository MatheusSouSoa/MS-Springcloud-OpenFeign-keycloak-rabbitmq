package com.springcloud.kleycloak.mscartoes.application.usecases.clientecartao;

import com.springcloud.kleycloak.mscartoes.domain.models.ClienteCartao;
import com.springcloud.kleycloak.mscartoes.infrastructure.persistence.JpaClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class ListCartoesByCpfUseCase {

    private final JpaClienteCartaoRepository repository;

    public List<ClienteCartao> execute(String cpf) {
        return repository.findByCpf(cpf);
    }
}
