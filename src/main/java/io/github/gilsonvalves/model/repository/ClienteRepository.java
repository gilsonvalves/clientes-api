package io.github.gilsonvalves.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.gilsonvalves.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
