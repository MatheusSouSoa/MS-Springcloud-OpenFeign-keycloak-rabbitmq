package com.springcloud.kleycloak.mscartoes.application.usecases.cartao;

import com.springcloud.kleycloak.mscartoes.domain.models.Cartoes;
import com.springcloud.kleycloak.mscartoes.infrastructure.persistence.JpaCartoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SalvarCartaoUseCase {

    private  final JpaCartoesRepository repository;

    @Transactional
    public Cartoes execute (Cartoes cartao) {
        return repository.save(cartao);
    }
}
