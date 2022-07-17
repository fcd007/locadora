package br.com.javacode.locadora.mapper;

import org.modelmapper.ModelMapper;

import br.com.javacode.locadora.dto.DevolucaoDTOV1;
import br.com.javacode.locadora.entity.Devolucao;

public class VeiculoMapperV1 {

	private ModelMapper modelMapper = new ModelMapper();

	public DevolucaoDTOV1 convertToDto(Devolucao devolucao) {
		DevolucaoDTOV1 devolucaoDTOV1 = modelMapper.map(devolucao, DevolucaoDTOV1.class);

		return devolucaoDTOV1;
	}

	public Devolucao convertToEntity(DevolucaoDTOV1 DevolucaoDTOV1) {
		Devolucao devolucao = modelMapper.map(DevolucaoDTOV1, Devolucao.class);

		return devolucao;
	}
}
