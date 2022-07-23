package br.com.javacode.locadora.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapperV1 {

	ClienteMapperV1 INSTANCIA = Mappers.getMapper(ClienteMapperV1.class);

	static ClienteMapperV1 clienteMapperV1() {
		return INSTANCIA;
	}
}
