package br.com.javacode.locadora.mapper;

import org.modelmapper.ModelMapper;

import br.com.javacode.locadora.dto.ClienteDTOV1;
import br.com.javacode.locadora.dto.DevolucaoDTOV1;
import br.com.javacode.locadora.entity.Cliente;
import br.com.javacode.locadora.entity.Devolucao;

public class ClienteMapperV1 {

	private ModelMapper modelMapper = new ModelMapper();

	public ClienteDTOV1 convertToDto(Cliente cliente) {
		ClienteDTOV1 clienteDTOV1 = modelMapper.map(cliente, ClienteDTOV1.class);

		return clienteDTOV1;
	}

	public Devolucao convertToEntity(DevolucaoDTOV1 devolucaoDTOV1) {
		Devolucao devolucao = modelMapper.map(devolucaoDTOV1, Devolucao.class);

		if (devolucaoDTOV1.getId() != null) {
			//Devolucao devolucaoOld = devolucaoService.getDevolucaoById(devolucaoDTOV1.getId());
			
		}

		return devolucao;
	}

}
