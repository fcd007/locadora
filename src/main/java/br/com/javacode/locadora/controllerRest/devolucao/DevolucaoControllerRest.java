package br.com.javacode.locadora.controllerRest.devolucao;

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

import br.com.javacode.locadora.entity.Devolucao;
import br.com.javacode.locadora.service.devolucao.DevolucaoService;

@CrossOrigin("*")
@RestController
@RequestMapping(DevolucaoUri.API_V1)
public class DevolucaoControllerRest {

	@Autowired
	DevolucaoService devolucaoService;

	@GetMapping(DevolucaoUri.DEVOLUCOES_FIND_ALL)
	public List<Devolucao> getAllDevolucaos() {
		return devolucaoService.getAllDevolucoes();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Devolucao
	 */
	@GetMapping(DevolucaoUri.DEVOLUCAO_FIND_BY_ID)
	public ResponseEntity<Devolucao> getDevolucaoId(@PathVariable Long id) {
		Devolucao Devolucao = devolucaoService.getDevolucaoById(id);
		return ResponseEntity.ok(Devolucao);
	}

	/**
	 * Cria Devolucao
	 * 
	 * @param Devolucao
	 * @return Devolucao
	 */
	@PostMapping(DevolucaoUri.DEVOLUCAO_CREATE)

	public Devolucao createDevolucao(@RequestBody Devolucao Devolucao) {
		Devolucao DevolucaoCreate = devolucaoService.salvarDevolucao(Devolucao);
		return DevolucaoCreate;
	}

	/**
	 * Atualizar enitidade Devolucao pelo Long id
	 * 
	 * @param id
	 * @param DevolucaoDetalhes
	 * @return
	 */
	@PutMapping(DevolucaoUri.DEVOLUCAO_UPDATE)
	public ResponseEntity<Devolucao> updateDevolucao(@PathVariable Long id, @RequestBody Devolucao DevolucaoDetalhes) {
		Devolucao DevolucaoUpdate = devolucaoService.updateDevolucaoById(id, DevolucaoDetalhes);
		return ResponseEntity.ok(DevolucaoUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(DevolucaoUri.DEVOLUCAO_DELETE)
	public ResponseEntity<HttpStatus> deleteDevolucao(@PathVariable Long id) {
		devolucaoService.deleteDevolucaoById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
