package com.springcloud.keycloak.msavaliadorcredito.infrastructure.clients;

import com.springcloud.keycloak.msavaliadorcredito.domain.models.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclientes", path = "/api/clientes")
public interface ClienteResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> dadosCliente (@RequestParam("cpf") String cpf);

}
