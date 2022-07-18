package br.com.javacode.locadora.service.devolucao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javacode.locadora.entity.Devolucao;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.DevolucaoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DevolucaoServiceImpl implements DevolucaoService {

	@Autowired
	DevolucaoRepository devolucaoRepository;

	@Override
	public List<Devolucao> getAllDevolucoes() {
		return devolucaoRepository.findAll();
	}

	@Override
	public Devolucao salvarDevolucao(Devolucao devolucao) {
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

		devolucaoRepository.save(devolucaoCreate);

		return devolucaoCreate;
	}

	@Override
	public Devolucao getDevolucaoById(Long id) {
		Devolucao Devolucao = devolucaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Devolucao inexistente com id: " + id));

		return Devolucao;
	}

	@Override
	public Devolucao updateDevolucaoById(Long id, Devolucao devolucaoDetalhes) {
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

		return devolucaoUpdate;
	}

	@Override
	public Boolean deleteDevolucaoById(Long id) {
		Devolucao Devolucao = devolucaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Devolucao inexistente com o id: " + id));

		devolucaoRepository.delete(Devolucao);

		return true;
	}

}
