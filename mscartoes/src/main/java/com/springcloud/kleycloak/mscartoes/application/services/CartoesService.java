package com.springcloud.kleycloak.mscartoes.application.services;

import com.springcloud.kleycloak.mscartoes.application.usecases.cartao.GetCartoesRendaMenorIgualUseCase;
import com.springcloud.kleycloak.mscartoes.application.usecases.cartao.SalvarCartaoUseCase;
import com.springcloud.kleycloak.mscartoes.domain.models.Cartoes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartoesService {

    private final SalvarCartaoUseCase salvarCartaoUseCase;
    private final GetCartoesRendaMenorIgualUseCase getCartoesRendaMenorIgualUseCase;

    public Cartoes salvarCartao(Cartoes cartao) {
        return salvarCartaoUseCase.execute(cartao);
    }

    public List<Cartoes> getCartoesRendaMenorIgual(Long renda) {
        return getCartoesRendaMenorIgualUseCase.execute(renda);
    }
}
