package com.springcloud.keycloak.msavaliadorcredito.application.usecases;


import com.springcloud.keycloak.msavaliadorcredito.domain.models.DadosCliente;
import com.springcloud.keycloak.msavaliadorcredito.infrastructure.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetDadosClienteUseCase {

    private final ClienteResourceClient clientesClient;

    public DadosCliente execute (String cpf) {
        ResponseEntity<DadosCliente> dadosClienteResponse = clientesClient.dadosCliente(cpf);
        return dadosClienteResponse.getBody();
    }
}
