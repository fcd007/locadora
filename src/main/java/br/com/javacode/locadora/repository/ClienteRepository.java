package br.com.javacode.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javacode.locadora.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
