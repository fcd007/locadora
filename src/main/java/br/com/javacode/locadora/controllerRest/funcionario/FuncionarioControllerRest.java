package br.com.javacode.locadora.controllerRest.funcionario;

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
import br.com.javacode.locadora.service.funcionario.FuncionarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(FuncionarioUri.API_V1)
public class FuncionarioControllerRest {

	@Autowired
	FuncionarioService funcionarioService;

	@GetMapping(FuncionarioUri.FUNCIONARIOS_FIND_ALL)
	public List<Funcionario> getAllFuncionarios() {
		return funcionarioService.getAllFuncionarios();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Funcionario
	 */
	@GetMapping(FuncionarioUri.FUNCIONARIO_FIND_BY_ID)
	public ResponseEntity<Funcionario> getFuncionarioId(@PathVariable Long id) {

		Funcionario funcionario = funcionarioService.getFuncionarioById(id);

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

		Funcionario funcionarioCreate = funcionarioService.salvarFuncionario(funcionario);

		return funcionarioCreate;
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
		Funcionario funcionarioUpdate = funcionarioService.updateFuncionarioById(id, funcionarioDetalhes);
		return ResponseEntity.ok(funcionarioUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(FuncionarioUri.FUNCIONARIO_DELETE)
	public ResponseEntity<HttpStatus> deleteFuncionario(@PathVariable Long id) {
		funcionarioService.deleteFuncionarioById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
