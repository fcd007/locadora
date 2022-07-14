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
import br.com.javacode.locadora.repository.LocacaoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(LocacaoUri.API_V1)
public class LocacaoControllerRest {

	@Autowired
	private LocacaoRepository locacaoRepository;

	/**
	 * Find all Locacoes
	 * 
	 * @return List Locacao
	 */
	@GetMapping(LocacaoUri.LOCACOES_FIND_ALL)
	public List<Locacao> getAllLoccacoes() {
		return locacaoRepository.findAll();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Locacao
	 */
	@GetMapping(LocacaoUri.LOCACAO_FIND_BY_ID)
	public ResponseEntity<Locacao> getLocacaoId(@PathVariable Long id) {
		Locacao locacao = locacaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Locacao inexistente com id: " + id));

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

		Locacao locacaoCreate = new Locacao();

		if (Loccacao != null) {
			if (Loccacao.getDataHoraLocacao() != null) {
				locacaoCreate.setDataHoraLocacao(Loccacao.getDataHoraLocacao());
			}
			if (Loccacao.getQuilomentragemLocacao() != null) {
				locacaoCreate.setQuilomentragemLocacao(Loccacao.getQuilomentragemLocacao());
			}
			if (Loccacao.getFinalidade() != null) {
				locacaoCreate.setFinalidade(Loccacao.getFinalidade());
			}
			if (Loccacao.getLocalTrafegagem() != null) {
				locacaoCreate.setLocalTrafegagem(Loccacao.getLocalTrafegagem());
			}
			if (Loccacao.getValorLocacao() != null) {
				locacaoCreate.setValorLocacao(Loccacao.getValorLocacao());
			}
			if (Loccacao.getValorCaucao() != null) {
				locacaoCreate.setValorCaucao(Loccacao.getValorCaucao());
			}
			if (Loccacao.getStatusLocacao() != null) {
				locacaoCreate.setStatusLocacao(Loccacao.getStatusLocacao());
			}
			if (Loccacao.getVeiculo() != null) {
				locacaoCreate.setVeiculo(Loccacao.getVeiculo());
			}
			if (Loccacao.getCliente() != null) {
				locacaoCreate.setCliente(Loccacao.getCliente());
			}
			if (Loccacao.getDevolucao() != null) {
				locacaoCreate.setDevolucao(Loccacao.getDevolucao());
			}
		}

		return locacaoRepository.save(locacaoCreate);
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
		Locacao locacaoUpdate = locacaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Locacao inexistente com id: " + id));

		if (locacaoDetalhes.getDataHoraLocacao() != null) {
			locacaoUpdate.setDataHoraLocacao(locacaoDetalhes.getDataHoraLocacao());
		}
		if (locacaoDetalhes.getQuilomentragemLocacao() != null) {
			locacaoUpdate.setQuilomentragemLocacao(locacaoDetalhes.getQuilomentragemLocacao());
		}
		if (locacaoDetalhes.getFinalidade() != null) {
			locacaoUpdate.setFinalidade(locacaoDetalhes.getFinalidade());
		}
		if (locacaoDetalhes.getLocalTrafegagem() != null) {
			locacaoUpdate.setLocalTrafegagem(locacaoDetalhes.getLocalTrafegagem());
		}
		if (locacaoDetalhes.getValorLocacao() != null) {
			locacaoUpdate.setValorLocacao(locacaoDetalhes.getValorLocacao());
		}
		if (locacaoDetalhes.getValorCaucao() != null) {
			locacaoUpdate.setValorCaucao(locacaoDetalhes.getValorCaucao());
		}
		if (locacaoDetalhes.getStatusLocacao() != null) {
			locacaoUpdate.setStatusLocacao(locacaoDetalhes.getStatusLocacao());
		}
		if (locacaoDetalhes.getVeiculo() != null) {
			locacaoUpdate.setVeiculo(locacaoDetalhes.getVeiculo());
		}
		if (locacaoDetalhes.getCliente() != null) {
			locacaoUpdate.setCliente(locacaoDetalhes.getCliente());
		}
		if (locacaoDetalhes.getDevolucao() != null) {
			locacaoUpdate.setDevolucao(locacaoDetalhes.getDevolucao());
		}

		locacaoRepository.save(locacaoUpdate);

		return ResponseEntity.ok(locacaoUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(LocacaoUri.LOCACAO_DELETE)
	public ResponseEntity<HttpStatus> deleteLocacao(@PathVariable Long id) {
		Locacao locacao = locacaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Locacao inexistente com o id: " + id));

		locacaoRepository.delete(locacao);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
