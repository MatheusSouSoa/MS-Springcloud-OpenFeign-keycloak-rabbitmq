package com.springcloud.kleycloak.mscartoes.application.services;


import com.springcloud.kleycloak.mscartoes.application.usecases.clientecartao.ListCartoesByCpfUseCase;
import com.springcloud.kleycloak.mscartoes.domain.models.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ListCartoesByCpfUseCase listCartoesByCpfUseCase;

    public List<ClienteCartao> listCartoesByCpf (String cpf) {
        return listCartoesByCpfUseCase.execute(cpf);
    }
}
