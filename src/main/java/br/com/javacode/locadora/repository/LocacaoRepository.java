package br.com.javacode.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javacode.locadora.entity.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
