package com.springcloud.keycloak.msavaliadorcredito.application.service;

import com.springcloud.keycloak.msavaliadorcredito.application.usecases.GetCartoesByClienteUseCase;
import com.springcloud.keycloak.msavaliadorcredito.application.usecases.GetDadosClienteUseCase;
import com.springcloud.keycloak.msavaliadorcredito.application.usecases.GetRendaAteUseCase;
import com.springcloud.keycloak.msavaliadorcredito.domain.models.*;
import com.springcloud.keycloak.msavaliadorcredito.exceptions.DadosClienteNotFoundException;
import com.springcloud.keycloak.msavaliadorcredito.exceptions.ErroComunicacaoMicroservicesException;
import com.springcloud.keycloak.msavaliadorcredito.infrastructure.clients.CartoesResourceClient;
import com.springcloud.keycloak.msavaliadorcredito.infrastructure.clients.ClienteResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final GetDadosClienteUseCase getDadosClienteUseCase;
    private final GetCartoesByClienteUseCase getCartoesByCliente;
    private final GetRendaAteUseCase getRendaAteUseCase;

    public SituacaoCliente obterSituacaoCliente(String cpf) throws  DadosClienteNotFoundException, ErroComunicacaoMicroservicesException{

        try {
            var cartoesCliente = getCartoesByCliente.execute(cpf);
            var dadosCliente = getDadosClienteUseCase.execute(cpf);

            return SituacaoCliente
                    .builder()
                    .cliente(dadosCliente)
                    .cartoes(cartoesCliente)
                    .build();
        } catch (FeignException.FeignClientException e) {
            int status = e.status();

            if(HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException();
            }
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }

    public RetornoAvaliacaoCliente realizarAvaliacao(String cpf, Long renda) throws  DadosClienteNotFoundException, ErroComunicacaoMicroservicesException{
        try {
            var dadosCliente = getDadosClienteUseCase.execute(cpf);
            var cartoes = getRendaAteUseCase.execute(renda);


            var listaCartoesAprovados = cartoes.stream().map(cartao -> {

                BigDecimal limiteBasico = cartao.getLimiteBasico();
                BigDecimal idadeBD = BigDecimal.valueOf(dadosCliente.getIdade());
                var fator = idadeBD.divide(BigDecimal.valueOf(10));
                BigDecimal limiteAprovado =  fator.multiply(limiteBasico);

                CartaoAprovado aprovado = new CartaoAprovado();
                aprovado.setCartao(cartao.getNome());
                aprovado.setBandeira(cartao.getBandeiraCartao());
                aprovado.setLimiteAprovado(limiteAprovado);

                return aprovado;
            }).collect(Collectors.toList());

            return new RetornoAvaliacaoCliente(listaCartoesAprovados);

        } catch (FeignException.FeignClientException e) {
            int status = e.status();

            if(HttpStatus.NOT_FOUND.value() == status) {
                throw new DadosClienteNotFoundException();
            }
            throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
        }
    }
}
