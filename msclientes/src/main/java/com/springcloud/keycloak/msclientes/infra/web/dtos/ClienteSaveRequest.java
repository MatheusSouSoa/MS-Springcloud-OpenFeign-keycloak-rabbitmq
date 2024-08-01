package com.springcloud.keycloak.msclientes.infra.web.dtos;

public record ClienteSaveRequest(String cpf, String nome, Integer idade) {
}
