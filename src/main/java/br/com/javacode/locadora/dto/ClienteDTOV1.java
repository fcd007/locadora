package br.com.javacode.locadora.dto;

import java.util.Date;

import br.com.javacode.locadora.enuns.ClienteTipoEnum;
import br.com.javacode.locadora.enuns.SexoEnum;
import lombok.Data;

@Data
public class ClienteDTOV1 {

	private Long id;

	private String nome;

	private String nomeEmpresa;

	private String endereco;

	private String telefone;

	private String email;

	private ClienteTipoEnum cliTipoCliente;

	private String CNPJ;

	private String CPF;

	private Date dataNacimento;

	private SexoEnum cliSexo;

	private Integer idade;

}
