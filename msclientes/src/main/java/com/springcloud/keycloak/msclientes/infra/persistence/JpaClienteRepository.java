package com.springcloud.keycloak.msclientes.infra.persistence;

import com.springcloud.keycloak.msclientes.domain.model.Cliente;
import com.springcloud.keycloak.msclientes.domain.repository.ClienteRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepository {

}
