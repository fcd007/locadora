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

@CrossOrigin("*")
@RestController
@RequestMapping(ClienteUri.API_V1)
public class ClienteControllerRest {

	@Autowired
	private ClienteRepository ClienteRepository;

	@GetMapping(ClienteUri.CLIENTES_FIND_ALL)
	public List<Cliente> getAllClientes() {
		return ClienteRepository.findAll();
	}

	/**
	 * @param recebe Long id
	 * @return retorna entidade Cliente
	 */
	@GetMapping(ClienteUri.CLIENTE_FIND_BY_ID)
	public ResponseEntity<Cliente> getClienteId(@PathVariable Long id) {
		Cliente cliente = ClienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente inexistente com id: " + id));

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

		return ClienteRepository.save(clienteCreate);
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
		Cliente clienteUpdate = ClienteRepository.findById(id)
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

		ClienteRepository.save(clienteUpdate);

		return ResponseEntity.ok(clienteUpdate);
	}

	/**
	 * 
	 * @param Long id
	 * @return HttpStatus
	 */
	@DeleteMapping(ClienteUri.CLIENTE_DELETE)
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable Long id) {
		Cliente Cliente = ClienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente inexistente com o id: " + id));

		ClienteRepository.delete(Cliente);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
