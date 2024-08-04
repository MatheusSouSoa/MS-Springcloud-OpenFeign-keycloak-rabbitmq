package com.springcloud.keycloak.msavaliadorcredito.application.usecases;


import com.springcloud.keycloak.msavaliadorcredito.domain.models.CartaoCliente;
import com.springcloud.keycloak.msavaliadorcredito.infrastructure.clients.CartoesResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCartoesByClienteUseCase {

    private final CartoesResourceClient cartoesResourceClient;

    public List<CartaoCliente> execute(String cpf) {
        ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesResourceClient.getCartoesByCliente(cpf);
        return cartoesResponse.getBody();
    }
}
