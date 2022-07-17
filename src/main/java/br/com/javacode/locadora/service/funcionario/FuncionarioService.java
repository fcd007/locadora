package br.com.javacode.locadora.service.funcionario;

import java.util.List;

import br.com.javacode.locadora.entity.Funcionario;

public interface FuncionarioService {

	List<Funcionario> getAllFuncionarios();

	Funcionario getFuncionarioById(Long id);

	Funcionario salvarFuncionario(Funcionario funcionario);

	Boolean deleteFuncionarioById(Long id);

	Funcionario updateFuncionarioById(Long id, Funcionario funcionarioDetalhes);
}
