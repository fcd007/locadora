package br.com.javacode.locadora.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DevolucaoMapperV1 {

	DevolucaoMapperV1 INSTANCIA = Mappers.getMapper(DevolucaoMapperV1.class);

	static DevolucaoMapperV1 devolucaoMapperV1() {
		return INSTANCIA;
	}
}
