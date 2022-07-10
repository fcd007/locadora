package br.com.javacode.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javacode.locadora.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
