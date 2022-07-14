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

import br.com.javacode.locadora.entity.Funcionario;
import br.com.javacode.locadora.entity.Veiculo;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.VeiculoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping(VeiculoUri.API_V1)
public class VeiculoControllerRest {

	@Autowired
	private VeiculoRepository veiculoRepository;

	/**
	 * 
	 * @return List Veiculos
	 */
	@GetMapping(VeiculoUri.VEICULOS_FIND_ALL)
	public List<Veiculo> getAllveiculos() {
		return veiculoRepository.findAll();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Veiculo
	 */
	@GetMapping(VeiculoUri.VEICULO_FIND_BY_ID)
	public ResponseEntity<Veiculo> getVeiculoId(@PathVariable Long id) {
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo inexistente com id: " + id));

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

		Veiculo veiculoCreate = new Veiculo();

		if (veiculo != null) {
			if (veiculo.getPlaca() != null) {
				veiculoCreate.setPlaca(veiculo.getPlaca());
			}
			if (veiculo.getCor() != null) {
				veiculoCreate.setCor(veiculo.getCor());
			}
			if (veiculo.getAnoFabricacao() != null) {
				veiculoCreate.setAnoFabricacao(veiculo.getAnoFabricacao());
			}
			if (veiculo.getModeloDescricao() != null) {
				veiculoCreate.setModeloDescricao(veiculo.getModeloDescricao());
			}
			if (veiculo.getMarcaDescricao() != null) {
				veiculoCreate.setMarcaDescricao(veiculo.getMarcaDescricao());
			}
			if (veiculo.getCombusivel() != null) {
				veiculoCreate.setCombusivel(veiculo.getCombusivel());
			}
			if (veiculo.getNumPortas() != null) {
				veiculoCreate.setNumPortas(veiculo.getNumPortas());
			}
			if (veiculo.getQuilometragem() != null) {
				veiculoCreate.setQuilometragem(veiculo.getQuilometragem());
			}
			if (veiculo.getRenavam() != null) {
				veiculoCreate.setRenavam(veiculo.getRenavam());
			}
			if (veiculo.getChassi() != null) {
				veiculoCreate.setChassi(veiculo.getChassi());
			}
			if (veiculo.getValorLocacao() != null) {
				veiculoCreate.setValorLocacao(veiculo.getValorLocacao());
			}
		}

		return veiculoRepository.save(veiculoCreate);
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
		Veiculo veiculoUpdate = veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo inexistente com id: " + id));

		if (veiculoDetalhes.getPlaca() != null) {
			veiculoUpdate.setPlaca(veiculoDetalhes.getPlaca());
		}
		if (veiculoDetalhes.getCor() != null) {
			veiculoUpdate.setCor(veiculoDetalhes.getCor());
		}
		if (veiculoDetalhes.getAnoFabricacao() != null) {
			veiculoUpdate.setAnoFabricacao(veiculoDetalhes.getAnoFabricacao());
		}
		if (veiculoDetalhes.getModeloDescricao() != null) {
			veiculoUpdate.setModeloDescricao(veiculoDetalhes.getModeloDescricao());
		}
		if (veiculoDetalhes.getMarcaDescricao() != null) {
			veiculoUpdate.setMarcaDescricao(veiculoDetalhes.getMarcaDescricao());
		}
		if (veiculoDetalhes.getCombusivel() != null) {
			veiculoUpdate.setCombusivel(veiculoDetalhes.getCombusivel());
		}
		if (veiculoDetalhes.getNumPortas() != null) {
			veiculoUpdate.setNumPortas(veiculoDetalhes.getNumPortas());
		}
		if (veiculoDetalhes.getQuilometragem() != null) {
			veiculoUpdate.setQuilometragem(veiculoDetalhes.getQuilometragem());
		}
		if (veiculoDetalhes.getRenavam() != null) {
			veiculoUpdate.setRenavam(veiculoDetalhes.getRenavam());
		}
		if (veiculoDetalhes.getChassi() != null) {
			veiculoUpdate.setChassi(veiculoDetalhes.getChassi());
		}
		if (veiculoDetalhes.getValorLocacao() != null) {
			veiculoUpdate.setValorLocacao(veiculoDetalhes.getValorLocacao());
		}

		veiculoRepository.save(veiculoUpdate);

		return ResponseEntity.ok(veiculoUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(VeiculoUri.VEICULO_DELETE)
	public ResponseEntity<HttpStatus> deleteVeiculo(@PathVariable Long id) {
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo inexistente com o id: " + id));

		veiculoRepository.delete(veiculo);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
