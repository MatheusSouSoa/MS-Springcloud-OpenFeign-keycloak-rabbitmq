package com.springcloud.kleycloak.mscartoes.application.usecases.cartao;

import com.springcloud.kleycloak.mscartoes.domain.models.Cartoes;
import com.springcloud.kleycloak.mscartoes.infrastructure.persistence.JpaCartoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCartoesRendaMenorIgualUseCase {

    private final JpaCartoesRepository repository;

    public List<Cartoes> execute (Long renda) {

        var rendaBigDecimal = BigDecimal.valueOf(renda);
        List<Cartoes> cartoes = repository.findByRendaLessThanEqual(rendaBigDecimal);
        System.out.println("Cartões encontrados: " + cartoes.size());
        return cartoes;
    }

}
