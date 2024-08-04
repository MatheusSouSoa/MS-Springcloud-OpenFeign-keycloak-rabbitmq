package com.springcloud.kleycloak.mscartoes.infrastructure.persistence;

import com.springcloud.kleycloak.mscartoes.domain.models.Cartoes;
import com.springcloud.kleycloak.mscartoes.domain.repository.CartaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCartoesRepository extends JpaRepository<Cartoes, Long>, CartaoRepository {
}
