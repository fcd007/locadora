package br.com.javacode.locadora.controllerRest.locacao;

import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class LocacaoUri {

	@SuppressWarnings("unused")
	private final EntityLinks entityLinks;

	public static final String API_V1 = "/api/v1/";

	public static final String LOCACOES_FIND_ALL = "/locacoes";

	public static final String LOCACAO_FIND_BY_ID = "/locacao/{id}";

	public static final String LOCACAO_CREATE = "/locacao";

	public static final String LOCACAO_UPDATE = "/locacao/{id}";

	public static final String LOCACAO_DELETE = "/locacao/{id}";

	public LocacaoUri(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
}
