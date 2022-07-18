package br.com.javacode.locadora.service.veiculo;

import java.util.List;

import br.com.javacode.locadora.entity.Veiculo;

public interface VeiculoService {

	List<Veiculo> getAllVeiculos();

	Veiculo getVeiculoById(Long id);

	Veiculo salvarVeiculo(Veiculo veiculo);

	Boolean deleteVeiculoById(Long id);

	Veiculo updateVeiculoById(Long id, Veiculo veiculoDetalhes);
}
