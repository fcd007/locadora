package br.com.javacode.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javacode.locadora.entity.Devolucao;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {

}
