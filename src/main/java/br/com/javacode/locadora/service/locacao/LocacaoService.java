package br.com.javacode.locadora.service.locacao;

import java.util.List;

import br.com.javacode.locadora.entity.Funcionario;
import br.com.javacode.locadora.entity.Locacao;

public interface LocacaoService {

	List<Locacao> getAllLocacoes();

	Locacao getLocacaoById(Long id);

	Locacao salvarLocacao(Locacao locacao);

	Boolean deleteLocacaoById(Long id);

	Locacao updateLocacaoById(Long id, Locacao locacaoDetalhes);
}
