package com.springcloud.keycloak.msavaliadorcredito.application.usecases;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.ListType;
import com.springcloud.keycloak.msavaliadorcredito.domain.models.Cartao;
import com.springcloud.keycloak.msavaliadorcredito.infrastructure.clients.CartoesResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetRendaAteUseCase {

    private final CartoesResourceClient cartoesResourceClient;

    public List<Cartao> execute (Long renda) {
        ResponseEntity<List<Cartao>> cartoesReponse = cartoesResourceClient.getCartoesRendaAte(renda);
        return cartoesReponse.getBody();
    }
}
