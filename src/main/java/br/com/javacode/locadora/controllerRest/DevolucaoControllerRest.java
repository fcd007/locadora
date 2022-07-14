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

import br.com.javacode.locadora.entity.Devolucao;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.DevolucaoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(DevolucaoUri.API_V1)
public class DevolucaoControllerRest {

	@Autowired
	private DevolucaoRepository devolucaoRepository;

	@GetMapping(DevolucaoUri.DEVOLUCOES_FIND_ALL)
	public List<Devolucao> getAllDevolucoes() {
		return devolucaoRepository.findAll();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Devolucao
	 */
	@GetMapping(DevolucaoUri.DEVOLUCAO_FIND_BY_ID)
	public ResponseEntity<Devolucao> getDevolucaoId(@PathVariable Long id) {
		Devolucao devolucao = devolucaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Devolucao inexistente com id: " + id));

		return ResponseEntity.ok(devolucao);
	}

	/**
	 * Cria Devolucao
	 * 
	 * @param Devolucao
	 * @return Devolucao
	 */
	@PostMapping(DevolucaoUri.DEVOLUCAO_CREATE)
	public Devolucao createDevolucao(@RequestBody Devolucao devolucao) {

		Devolucao devolucaoCreate = new Devolucao();

		if (devolucao != null) {
			if (devolucao.getDataHoraDevolucao() != null) {
				devolucaoCreate.setDataHoraDevolucao(devolucao.getDataHoraDevolucao());
			}
			if (devolucao.getQuilometragemDevolucao() != null) {
				devolucaoCreate.setQuilometragemDevolucao(devolucao.getQuilometragemDevolucao());
			}
			if (devolucao.getDevEstadoVeiculo() != null) {
				devolucaoCreate.setDevEstadoVeiculo(devolucao.getDevEstadoVeiculo());
			}
		}

		return devolucaoRepository.save(devolucaoCreate);
	}

	/**
	 * Atualizar enitidade Devolucao pelo Long id
	 * 
	 * @param id
	 * @param DevolucaoDetalhes
	 * @return
	 */
	@PutMapping(DevolucaoUri.DEVOLUCAO_UPDATE)
	public ResponseEntity<Devolucao> updateDevolucao(@PathVariable Long id, @RequestBody Devolucao devolucaoDetalhes) {
		Devolucao devolucaoUpdate = devolucaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Devolucao inexistente com id: " + id));

		if (devolucaoDetalhes != null) {
			if (devolucaoDetalhes.getDataHoraDevolucao() != null) {
				devolucaoUpdate.setDataHoraDevolucao(devolucaoDetalhes.getDataHoraDevolucao());
			}
			if (devolucaoDetalhes.getQuilometragemDevolucao() != null) {
				devolucaoUpdate.setQuilometragemDevolucao(devolucaoDetalhes.getQuilometragemDevolucao());
			}
			if (devolucaoDetalhes.getDevEstadoVeiculo() != null) {
				devolucaoUpdate.setDevEstadoVeiculo(devolucaoDetalhes.getDevEstadoVeiculo());
			}
		}

		devolucaoRepository.save(devolucaoUpdate);

		return ResponseEntity.ok(devolucaoUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(DevolucaoUri.DEVOLUCAO_DELETE)
	public ResponseEntity<HttpStatus> deleteDevolucao(@PathVariable Long id) {
		Devolucao devolucao = devolucaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Devolucao inexistente com o id: " + id));

		devolucaoRepository.delete(devolucao);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
