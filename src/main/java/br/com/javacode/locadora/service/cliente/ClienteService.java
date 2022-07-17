package br.com.javacode.locadora.service.cliente;

import java.util.List;

import br.com.javacode.locadora.entity.Cliente;

public interface ClienteService {

	List<Cliente> getAllClientes();

	Cliente getClienteById(Long id);

	Cliente salvarCliente(Cliente Cliente);

	Boolean deleteClienteById(Long id);

	Cliente updateClienteById(Long id, Cliente ClienteDetalhes);
}
