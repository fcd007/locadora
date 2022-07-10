package br.com.javacode.locadora.controllerRest;

import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioUri {

	@SuppressWarnings("unused")
	private final EntityLinks entityLinks;

	public static final String API_V1 = "/api/v1/";
	
	public static final String FUNCIONARIOS_FIND_ALL = "/funcionarios";

	public static final String FUNCIONARIOS_FIND_BY_ID = "/funcionario/{id}";

	public static final String FUNCIONARIO_CREATE = "/funcionario";
	
	public static final String FUNCIONARIO_UPDATE = "/funcionario/{id}";

	public static final String FUNCIONARIOS_DELETE = "/funcionario/{id}";

	public FuncionarioUri(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
}
