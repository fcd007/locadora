package br.com.javacode.locadora.controllerRest.veiculo;

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

import br.com.javacode.locadora.entity.Veiculo;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.service.veiculo.VeiculoService;

@CrossOrigin("*")
@RestController
@RequestMapping(VeiculoUri.API_V1)
public class VeiculoControllerRest {

	@Autowired
	private VeiculoService veiculoService;

	/**
	 * 
	 * @return List Veiculos
	 */
	@GetMapping(VeiculoUri.VEICULOS_FIND_ALL)
	public List<Veiculo> getAllveiculos() {
		return veiculoService.getAllVeiculos();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Veiculo
	 */
	@GetMapping(VeiculoUri.VEICULO_FIND_BY_ID)
	public ResponseEntity<Veiculo> getVeiculoId(@PathVariable Long id) {
		Veiculo veiculo = veiculoService.getVeiculoById(id);
		return ResponseEntity.ok(veiculo);
	}

	/**
	 * Cria Veiculo
	 * 
	 * @param Veiculo
	 * @return Veiculo
	 */
	@PostMapping(VeiculoUri.VEICULO_CREATE)
	public Veiculo createVeiculo(@RequestBody Veiculo veiculo) {
		Veiculo veiculoCreate = veiculoService.salvarVeiculo(veiculo);
		return veiculoCreate;
	}

	/**
	 * Atualizar enitidade Veiculo pelo Long id
	 * 
	 * @param id
	 * @param veiculoDetalhes
	 * @return
	 */
	@PutMapping(VeiculoUri.VEICULO_UPDATE)
	public ResponseEntity<Veiculo> updateVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculoDetalhes) {
		Veiculo veiculoUpdate = veiculoService.updateVeiculoById(id, veiculoDetalhes);
		return ResponseEntity.ok(veiculoUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(VeiculoUri.VEICULO_DELETE)
	public ResponseEntity<HttpStatus> deleteVeiculo(@PathVariable Long id) {
		veiculoService.deleteVeiculoById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
