package com.springcloud.kleycloak.mscartoes.infrastructure.persistence.mappers;

import com.springcloud.kleycloak.mscartoes.domain.models.Cartoes;
import com.springcloud.kleycloak.mscartoes.infrastructure.web.dtos.CartaoSaveRequest;
import org.springframework.stereotype.Component;

@Component
public class CartaoEntityMapper {

    public Cartoes requestToEntity (CartaoSaveRequest request) {
        return new Cartoes(request.nome(), request.bandeira(), request.renda(), request.limite());
    }

    public CartaoSaveRequest EntityToRequest (Cartoes cartao) {
        return new CartaoSaveRequest(cartao.getNome(), cartao.getBandeiraCartao(), cartao.getRenda(),cartao.getLimiteBasico());
    }
}
