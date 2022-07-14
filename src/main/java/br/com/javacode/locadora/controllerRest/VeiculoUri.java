package br.com.javacode.locadora.controllerRest;

import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class VeiculoUri {

	@SuppressWarnings("unused")
	private final EntityLinks entityLinks;

	public static final String API_V1 = "/api/v1/";

	public static final String VEICULOS_FIND_ALL = "/veiculos";

	public static final String VEICULO_FIND_BY_ID = "/veiculo/{id}";

	public static final String VEICULO_CREATE = "/veiculo";

	public static final String VEICULO_UPDATE = "/veiculo/{id}";

	public static final String VEICULO_DELETE = "/veiculo/{id}";

	public VeiculoUri(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
}
