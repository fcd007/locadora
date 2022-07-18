package br.com.javacode.locadora.service.veiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javacode.locadora.entity.Veiculo;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.VeiculoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	VeiculoRepository veiculoRepository;

	@Override
	public List<Veiculo> getAllVeiculos() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo getVeiculoById(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo inexistente com id: " + id));
		
		return veiculo;
	}

	@Override
	public Veiculo salvarVeiculo(Veiculo veiculo) {
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

		veiculoRepository.save(veiculoCreate);

		return veiculoCreate;
	}

	@Override
	public Boolean deleteVeiculoById(Long id) {
		Veiculo veiculo = veiculoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Veiculo inexistente com o id: " + id));
		
		veiculoRepository.delete(veiculo);
		
		return true;
	}

	@Override
	public Veiculo updateVeiculoById(Long id, Veiculo veiculoDetalhes) {
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

		return veiculoUpdate;
	}

}
