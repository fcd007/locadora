package br.com.javacode.locadora.service.locacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javacode.locadora.entity.Locacao;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.LocacaoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	LocacaoRepository locacaoRepository;

	@Override
	public List<Locacao> getAllLocacoes() {
		return locacaoRepository.findAll();
	}

	@Override
	public Locacao getLocacaoById(Long id) {
		Locacao locacao = locacaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Locacao inexistente com id: " + id));
		return locacao;
	}

	@Override
	public Locacao salvarLocacao(Locacao locacao) {
		Locacao locacaoCreate = new Locacao();

		if (locacao != null) {
			if (locacao.getDataHoraLocacao() != null) {
				locacaoCreate.setDataHoraLocacao(locacao.getDataHoraLocacao());
			}
			if (locacao.getQuilomentragemLocacao() != null) {
				locacaoCreate.setQuilomentragemLocacao(locacao.getQuilomentragemLocacao());
			}
			if (locacao.getFinalidade() != null) {
				locacaoCreate.setFinalidade(locacao.getFinalidade());
			}
			if (locacao.getLocalTrafegagem() != null) {
				locacaoCreate.setLocalTrafegagem(locacao.getLocalTrafegagem());
			}
			if (locacao.getValorLocacao() != null) {
				locacaoCreate.setValorLocacao(locacao.getValorLocacao());
			}
			if (locacao.getValorCaucao() != null) {
				locacaoCreate.setValorCaucao(locacao.getValorCaucao());
			}
			if (locacao.getStatusLocacao() != null) {
				locacaoCreate.setStatusLocacao(locacao.getStatusLocacao());
			}
			if (locacao.getVeiculo() != null) {
				locacaoCreate.setVeiculo(locacao.getVeiculo());
			}
			if (locacao.getCliente() != null) {
				locacaoCreate.setCliente(locacao.getCliente());
			}
			if (locacao.getDevolucao() != null) {
				locacaoCreate.setDevolucao(locacao.getDevolucao());
			}
		}

		return locacaoCreate;
	}

	@Override
	public Boolean deleteLocacaoById(Long id) {
		Locacao locacao = locacaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Locacao inexistente com o id: " + id));
		locacaoRepository.delete(locacao);
		return true;
	}

	@Override
	public Locacao updateLocacaoById(Long id, Locacao locacaoDetalhes) {
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

		return locacaoUpdate;
	}

}
