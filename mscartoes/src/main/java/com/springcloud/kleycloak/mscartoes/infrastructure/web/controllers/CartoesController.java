package com.springcloud.kleycloak.mscartoes.infrastructure.web.controllers;

import com.springcloud.kleycloak.mscartoes.application.services.CartoesService;
import com.springcloud.kleycloak.mscartoes.application.services.ClienteCartaoService;
import com.springcloud.kleycloak.mscartoes.domain.models.Cartoes;
import com.springcloud.kleycloak.mscartoes.domain.models.ClienteCartao;
import com.springcloud.kleycloak.mscartoes.infrastructure.persistence.mappers.CartaoEntityMapper;
import com.springcloud.kleycloak.mscartoes.infrastructure.persistence.mappers.ClienteCartaoEntityMapper;
import com.springcloud.kleycloak.mscartoes.infrastructure.web.dtos.CartaoSaveRequest;
import com.springcloud.kleycloak.mscartoes.infrastructure.web.dtos.CartoesPorClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cartoes")
@RequiredArgsConstructor
public class CartoesController {

    private final CartaoEntityMapper cartaoEntityMapper;
    private final CartoesService cartaoService;
    private final ClienteCartaoService clienteCartaoService;
    private final ClienteCartaoEntityMapper clienteCartaoEntityMapper;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Optional<Cartoes>> cadastra(@RequestBody CartaoSaveRequest request) {
        Cartoes cartao = cartaoEntityMapper.requestToEntity(request);
        cartaoService.salvarCartao(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartoes>> getCartoesRendaAte(@RequestParam("renda") Long renda) {
        List<Cartoes> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf) {
        List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> resultList = lista.stream()
                .map(clienteCartaoEntityMapper::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }

}