package com.springcloud.keycloak.msclientes.infra.web.controllers;

import com.springcloud.keycloak.msclientes.application.service.ClienteService;
import com.springcloud.keycloak.msclientes.domain.model.Cliente;
import com.springcloud.keycloak.msclientes.infra.persistence.mapper.ClienteEntityMapper;
import com.springcloud.keycloak.msclientes.infra.web.dtos.ClienteSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;
    private final ClienteEntityMapper clienteEntityMapper;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteSaveRequest request) {
        var cliente = clienteEntityMapper.requestToCliente(request);
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<?> dadosCliente (@RequestParam("cpf") String cpf) {
        var cliente = service.getByCpf(cpf);

        if(cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}
