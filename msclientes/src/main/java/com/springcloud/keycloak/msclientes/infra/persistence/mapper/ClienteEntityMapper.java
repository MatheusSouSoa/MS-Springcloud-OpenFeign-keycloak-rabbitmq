package com.springcloud.keycloak.msclientes.infra.persistence.mapper;

import com.springcloud.keycloak.msclientes.domain.model.Cliente;
import com.springcloud.keycloak.msclientes.infra.web.dtos.ClienteSaveRequest;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityMapper {

    public Cliente requestToCliente (ClienteSaveRequest request) {
        return new Cliente(request.cpf(), request.nome(), request.idade());
    }

    public ClienteSaveRequest clienteToRequest(Cliente cliente) {
        return new ClienteSaveRequest(cliente.getCpf(), cliente.getNome(), cliente.getIdade());
    }
}
