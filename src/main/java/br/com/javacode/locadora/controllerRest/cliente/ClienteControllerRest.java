package br.com.javacode.locadora.controllerRest.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javacode.locadora.entity.Cliente;
import br.com.javacode.locadora.exception.ResourceNotFoundException;
import br.com.javacode.locadora.repository.ClienteRepository;
import br.com.javacode.locadora.service.cliente.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping(ClienteUri.API_V1)
public class ClienteControllerRest {

	@Autowired
	ClienteService clienteService;

	@GetMapping(ClienteUri.CLIENTES_FIND_ALL)
	public List<Cliente> getAllClientes() {
		return clienteService.getAllClientes();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Cliente
	 */
	@GetMapping(ClienteUri.CLIENTE_FIND_BY_ID)
	public ResponseEntity<Cliente> getClienteId(@PathVariable Long id) {
		Cliente cliente = clienteService.getClienteById(id);
		return ResponseEntity.ok(cliente);
	}

	/**
	 * Cria Cliente
	 * 
	 * @param cliente
	 * @return Cliente
	 */
	@PostMapping(ClienteUri.CLIENTE_CREATE)
	public Cliente createCliente(@RequestBody Cliente cliente) {
		Cliente clienteCreate = clienteService.salvarCliente(cliente);
		return clienteCreate;
	}

	/**
	 * Atualizar enitidade Cliente pelo Long id
	 * 
	 * @param id
	 * @param clienteDetalhes
	 * @return
	 */
	@PutMapping(ClienteUri.CLIENTE_UPDATE)
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetalhes) {
		Cliente clienteUpdate = clienteService.updateClienteById(id, clienteDetalhes);
		return ResponseEntity.ok(clienteUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(ClienteUri.CLIENTE_DELETE)
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable Long id) {
		clienteService.deleteClienteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
