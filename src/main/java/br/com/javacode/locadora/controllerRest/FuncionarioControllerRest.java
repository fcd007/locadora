package br.com.javacode.locadora.controllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javacode.locadora.entity.Funcionario;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.FuncionarioRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(FuncionarioUri.API_V1)
public class FuncionarioControllerRest {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping(FuncionarioUri.FUNCIONARIOS_FIND_ALL)
	public List<Funcionario> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Funcionario
	 */
	@GetMapping(FuncionarioUri.FUNCIONARIOS_FIND_BY_ID)
	public ResponseEntity<Funcionario> getFuncionarioId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario inexistente com id: " + id));

		return ResponseEntity.ok(funcionario);
	}

	/**
	 * Cria Funcionario
	 * 
	 * @param Funcionario
	 * @return Funcionario
	 */
	@PostMapping(FuncionarioUri.FUNCIONARIO_CREATE)
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		
		Funcionario funcionarioCreate = new Funcionario();
		
		if(funcionario != null) {
			funcionarioCreate.setFirstName(funcionario.getFirstName());
			funcionarioCreate.setLastName(funcionario.getLastName());
			funcionarioCreate.setEmailId(funcionario.getEmailId());
			funcionarioCreate.setDataCriacao(funcionario.getDataCriacao());
			funcionarioCreate.setDataUpate(funcionario.getDataUpate());
		}
		
		return funcionarioRepository.save(funcionarioCreate);
	}

	/**
	 * Atualizar enitidade Funcionario pelo Long id
	 * 
	 * @param id
	 * @param funcionarioDetalhes
	 * @return
	 */
	@PutMapping(FuncionarioUri.FUNCIONARIO_UPDATE)
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id,
			@RequestBody Funcionario funcionarioDetalhes) {
		Funcionario funcionarioUpdate = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario inexistente com id: " + id));

		funcionarioUpdate.setFirstName(funcionarioDetalhes.getFirstName());
		funcionarioUpdate.setLastName(funcionarioDetalhes.getLastName());
		funcionarioUpdate.setEmailId(funcionarioDetalhes.getEmailId());
		funcionarioUpdate.setDataUpate(funcionarioDetalhes.getDataUpate());

		funcionarioRepository.save(funcionarioUpdate);

		return ResponseEntity.ok(funcionarioUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(FuncionarioUri.FUNCIONARIOS_DELETE)
	public ResponseEntity<HttpStatus> deleteFuncionario(@PathVariable Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Funcionario inexistente com o id: " + id));

		funcionarioRepository.delete(funcionario);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
