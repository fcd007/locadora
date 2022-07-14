package br.com.javacode.locadora.controllerRest.devolucao;

import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class DevolucaoUri {

	@SuppressWarnings("unused")
	private final EntityLinks entityLinks;

	public static final String API_V1 = "/api/v1/";
	
	public static final String DEVOLUCOES_FIND_ALL = "/devolucoes";

	public static final String DEVOLUCAO_FIND_BY_ID = "/devolucao/{id}";

	public static final String DEVOLUCAO_CREATE = "/devolucao";
	
	public static final String DEVOLUCAO_UPDATE = "/devolucao/{id}";

	public static final String DEVOLUCAO_DELETE = "/devolucao/{id}";

	public DevolucaoUri(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
}
