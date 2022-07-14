package br.com.javacode.locadora.controllerRest.cliente;

import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class ClienteUri {

	@SuppressWarnings("unused")
	private final EntityLinks entityLinks;

	public static final String API_V1 = "/api/v1/";
	
	public static final String CLIENTES_FIND_ALL = "/clientes";

	public static final String CLIENTE_FIND_BY_ID = "/cliente/{id}";

	public static final String CLIENTE_CREATE = "/cliente";
	
	public static final String CLIENTE_UPDATE = "/cliente/{id}";

	public static final String CLIENTE_DELETE = "/cliente/{id}";

	public ClienteUri(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
}
