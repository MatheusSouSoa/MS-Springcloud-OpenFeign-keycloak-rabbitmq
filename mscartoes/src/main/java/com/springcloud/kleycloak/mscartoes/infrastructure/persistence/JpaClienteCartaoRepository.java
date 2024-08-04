package com.springcloud.kleycloak.mscartoes.infrastructure.persistence;

import com.springcloud.kleycloak.mscartoes.domain.models.ClienteCartao;
import com.springcloud.kleycloak.mscartoes.domain.repository.ClienteCartaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaClienteCartaoRepository extends JpaRepository<ClienteCartao, Long>, ClienteCartaoRepository {

}
