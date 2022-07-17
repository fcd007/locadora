package br.com.javacode.locadora.controllerRest.locacao;

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

import br.com.javacode.locadora.entity.Locacao;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.service.locacao.LocacaoService;

@CrossOrigin("*")
@RestController
@RequestMapping(LocacaoUri.API_V1)
public class LocacaoControllerRest {

	@Autowired
	private LocacaoService locacaoService;

	/**
	 * Find all Locacoes
	 * 
	 * @return List Locacao
	 */
	@GetMapping(LocacaoUri.LOCACOES_FIND_ALL)
	public List<Locacao> getAllLoccacoes() {
		return locacaoService.getAllLocacoes();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Locacao
	 */
	@GetMapping(LocacaoUri.LOCACAO_FIND_BY_ID)
	public ResponseEntity<Locacao> getLocacaoId(@PathVariable Long id) {
		Locacao locacao = locacaoService.getLocacaoById(id);
		return ResponseEntity.ok(locacao);
	}

	/**
	 * Cria Locacao
	 * 
	 * @param Locacao
	 * @return Locacao
	 */
	@PostMapping(LocacaoUri.LOCACAO_CREATE)
	public Locacao createLoccacao(@RequestBody Locacao Loccacao) {
		Locacao locacao = locacaoService.salvarLocacao(Loccacao);
		return locacao;
	}

	/**
	 * Atualizar enitidade Locacao pelo Long id
	 * 
	 * @param id
	 * @param locacaoDetalhes
	 * @return
	 */
	@PutMapping(LocacaoUri.LOCACAO_UPDATE)
	public ResponseEntity<Locacao> updateLocacao(@PathVariable Long id, @RequestBody Locacao locacaoDetalhes) {
		Locacao locacaoUpdate = locacaoService.updateLocacaoById(id, locacaoDetalhes);
		return ResponseEntity.ok(locacaoUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(LocacaoUri.LOCACAO_DELETE)
	public ResponseEntity<HttpStatus> deleteLocacao(@PathVariable Long id) {
		locacaoService.deleteLocacaoById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
