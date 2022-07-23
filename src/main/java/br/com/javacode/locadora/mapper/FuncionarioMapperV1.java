package br.com.javacode.locadora.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;

import br.com.javacode.locadora.dto.DevolucaoDTOV1;
import br.com.javacode.locadora.entity.Devolucao;

@Mapper(componentModel = "spring")
public interface FuncionarioMapperV1 {

	FuncionarioMapperV1 INSTANCIA = Mappers.getMapper(FuncionarioMapperV1.class);

	static FuncionarioMapperV1 funcionarioMapperV1() {
		return INSTANCIA;
	}
}
