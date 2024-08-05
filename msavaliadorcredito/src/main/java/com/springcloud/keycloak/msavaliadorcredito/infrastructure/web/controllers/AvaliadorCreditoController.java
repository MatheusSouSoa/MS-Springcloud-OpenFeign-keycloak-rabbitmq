package com.springcloud.keycloak.msavaliadorcredito.infrastructure.web.controllers;

import com.springcloud.keycloak.msavaliadorcredito.application.service.AvaliadorCreditoService;
import com.springcloud.keycloak.msavaliadorcredito.domain.models.*;
import com.springcloud.keycloak.msavaliadorcredito.exceptions.DadosClienteNotFoundException;
import com.springcloud.keycloak.msavaliadorcredito.exceptions.ErroComunicacaoMicroservicesException;
import com.springcloud.keycloak.msavaliadorcredito.exceptions.ErroSolicitacaoCartaoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/avaliacoes-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping(value = "/situacao-cliente", params = "cpf")
    public ResponseEntity<?> consultaSituacaoCliente (@RequestParam("cpf") String cpf) {
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e) {
            HttpStatus status = HttpStatus.resolve(e.getStatus());
            if (status == null) {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            return ResponseEntity.status(status).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
    }

    @PostMapping
    public ResponseEntity<?> realizarAvaliacao (@RequestBody DadosAvaliacao dados) {
        try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliadorCreditoService.realizarAvaliacao(dados.getCpf(), dados.getRenda());
            return ResponseEntity.ok(retornoAvaliacaoCliente);
        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e) {
            HttpStatus status = HttpStatus.resolve(e.getStatus());
            if (status == null) {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            return ResponseEntity.status(status).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
    }

    @PostMapping("solicitacoes-cartao")
    public ResponseEntity<?> solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados) {

        try {
            ProtocoloSolicitacaoCartao protocoloSolicitacaoCartao = avaliadorCreditoService.solicitarEmissaoCartao(dados);
            return ResponseEntity.ok(protocoloSolicitacaoCartao);
        } catch (ErroSolicitacaoCartaoException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
