package br.com.javacode.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javacode.locadora.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
