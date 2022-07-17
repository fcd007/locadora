package br.com.javacode.locadora.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javacode.locadora.entity.Cliente;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		Cliente clienteCreate = new Cliente();

		if (cliente != null) {
			if (cliente.getNome() != null) {
				clienteCreate.setNome(cliente.getNome());
			}
			if (cliente.getNomeEmpresa() != null) {
				clienteCreate.setNomeEmpresa(cliente.getNomeEmpresa());
			}
			if (cliente.getEndereco() != null) {
				clienteCreate.setEndereco(cliente.getEndereco());
			}
			if (cliente.getTelefone() != null) {
				clienteCreate.setTelefone((cliente.getTelefone()));
			}
			if (cliente.getEmail() != null) {
				clienteCreate.setEmail(cliente.getEmail());
			}
			if (cliente.getCliTipoCliente() != null) {
				clienteCreate.setCliTipoCliente(cliente.getCliTipoCliente());
			}
			if (cliente.getCNPJ() != null) {
				clienteCreate.setCNPJ(cliente.getCNPJ());
			}
			if (cliente.getCPF() != null) {
				clienteCreate.setCPF(cliente.getCPF());
			}
			if (cliente.getDataNacimento() != null) {
				clienteCreate.setDataNacimento(cliente.getDataNacimento());
			}
			if (cliente.getCliSexo() != null) {
				clienteCreate.setCliSexo(cliente.getCliSexo());
			}
			if (cliente.getIdade() != null) {
				clienteCreate.setIdade(cliente.getIdade());
			}
		}

		return clienteRepository.save(clienteCreate);
	}

	@Override
	public Cliente getClienteById(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente inexistente com id: " + id));
		return cliente;
	}

	@Override
	public Cliente updateClienteById(Long id, Cliente clienteDetalhes) {
		Cliente clienteUpdate = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente inexistente com id: " + id));

		if (clienteUpdate != null) {
			if (clienteDetalhes.getNome() != null) {
				clienteUpdate.setNome(clienteDetalhes.getNome());
			}
			if (clienteDetalhes.getNomeEmpresa() != null) {
				clienteUpdate.setNomeEmpresa(clienteDetalhes.getNomeEmpresa());
			}
			if (clienteDetalhes.getEndereco() != null) {
				clienteUpdate.setEndereco(clienteDetalhes.getEndereco());
			}
			if (clienteDetalhes.getTelefone() != null) {
				clienteUpdate.setTelefone((clienteDetalhes.getTelefone()));
			}
			if (clienteDetalhes.getEmail() != null) {
				clienteUpdate.setEmail(clienteDetalhes.getEmail());
			}
			if (clienteDetalhes.getCliTipoCliente() != null) {
				clienteUpdate.setCliTipoCliente(clienteDetalhes.getCliTipoCliente());
			}
			if (clienteDetalhes.getCNPJ() != null) {
				clienteUpdate.setCNPJ(clienteDetalhes.getCNPJ());
			}
			if (clienteDetalhes.getCPF() != null) {
				clienteUpdate.setCPF(clienteDetalhes.getCPF());
			}
			if (clienteDetalhes.getDataNacimento() != null) {
				clienteUpdate.setDataNacimento(clienteDetalhes.getDataNacimento());
			}
			if (clienteDetalhes.getCliSexo() != null) {
				clienteUpdate.setCliSexo(clienteDetalhes.getCliSexo());
			}
			if (clienteDetalhes.getIdade() != null) {
				clienteUpdate.setIdade(clienteDetalhes.getIdade());
			}
		}

		return clienteUpdate;
	}

	@Override
	public Boolean deleteClienteById(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente inexistente com o id: " + id));

		clienteRepository.delete(cliente);
		return true;
	}

}
