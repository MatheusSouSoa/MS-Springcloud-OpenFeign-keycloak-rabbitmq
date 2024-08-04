package com.springcloud.kleycloak.mscartoes.infrastructure.persistence.mappers;

import com.springcloud.kleycloak.mscartoes.domain.models.ClienteCartao;
import com.springcloud.kleycloak.mscartoes.infrastructure.web.dtos.CartoesPorClienteResponse;
import org.springframework.stereotype.Component;

@Component
public class ClienteCartaoEntityMapper {

    public CartoesPorClienteResponse fromModel (ClienteCartao model) {
        return new CartoesPorClienteResponse(model.getCartao().getNome(), model.getCartao().getBandeiraCartao().toString(), model.getLimite());
    }
}
