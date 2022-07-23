package br.com.javacode.locadora.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;

import br.com.javacode.locadora.dto.DevolucaoDTOV1;
import br.com.javacode.locadora.entity.Devolucao;

@Mapper(componentModel = "spring")
public interface LocacaoMapperV1 {

	LocacaoMapperV1 INSTANCIA = Mappers.getMapper(LocacaoMapperV1.class);

	static LocacaoMapperV1 locacaoMapperV1() {
		return INSTANCIA;
	}
}
