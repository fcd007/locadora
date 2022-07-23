package br.com.javacode.locadora.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;

import br.com.javacode.locadora.dto.DevolucaoDTOV1;
import br.com.javacode.locadora.entity.Devolucao;

@Mapper(componentModel = "spring")
public interface VeiculoMapperV1 {

	VeiculoMapperV1 INSTANCIA = Mappers.getMapper(VeiculoMapperV1.class);

	static VeiculoMapperV1 veiculoMapperV1() {
		return INSTANCIA;
	}
}
