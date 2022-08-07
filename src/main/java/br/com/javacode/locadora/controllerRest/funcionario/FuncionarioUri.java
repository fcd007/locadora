package br.com.javacode.locadora.controllerRest.funcionario;

import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioUri {

	@SuppressWarnings("unused")
	private final EntityLinks entityLinks;

	public static final String API_V1 = "/api/v1/";
	
	public static final String FUNCIONARIOS_FIND_ALL = "/funcionarios/listar";

	public static final String FUNCIONARIO_FIND_BY_ID = "/funcionarios/{id}";

	public static final String FUNCIONARIO_CREATE = "/funcionarios/salvar";
	
	public static final String FUNCIONARIO_UPDATE = "/funcionarios/{id}";

	public static final String FUNCIONARIO_DELETE = "/funcionarios/{id}";

	public FuncionarioUri(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
}
