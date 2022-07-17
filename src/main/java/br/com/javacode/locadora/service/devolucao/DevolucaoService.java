package br.com.javacode.locadora.service.devolucao;

import java.util.List;

import br.com.javacode.locadora.entity.Devolucao;

public interface DevolucaoService {

	List<Devolucao> getAllDevolucoes();

	Devolucao getDevolucaoById(Long id);

	Devolucao salvarDevolucao(Devolucao devolucao);

	Boolean deleteDevolucaoById(Long id);

	Devolucao updateDevolucaoById(Long id, Devolucao devolucaoDetalhes);
}
