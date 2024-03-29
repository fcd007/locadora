package br.com.javacode.locadora.service.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javacode.locadora.entity.Funcionario;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.FuncionarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		Funcionario funcionarioCreate = new Funcionario();

		if (funcionario != null) {
			funcionarioCreate.setNome(funcionario.getNome());
			funcionarioCreate.setSobrenome(funcionario.getSobrenome());
			funcionarioCreate.setEmail(funcionario.getEmail());
		}

		return funcionarioRepository.save(funcionarioCreate);
	}

	@Override
	public Funcionario getFuncionarioById(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario inexistente com id: " + id));

		return funcionario;
	}

	@Override
	public Funcionario updateFuncionarioById(Long id, Funcionario funcionarioDetalhes) {
		Funcionario funcionarioUpdate = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario inexistente com id: " + id));
		funcionarioUpdate.setNome(funcionarioDetalhes.getNome());
		funcionarioUpdate.setSobrenome(funcionarioDetalhes.getSobrenome());
		funcionarioUpdate.setEmail(funcionarioDetalhes.getEmail());

		funcionarioRepository.save(funcionarioUpdate);

		return funcionarioUpdate;
	}

	@Override
	public Boolean deleteFuncionarioById(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario inexistente com o id: " + id));

		funcionarioRepository.delete(funcionario);

		return true;
	}

}
