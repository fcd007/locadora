package br.com.javacode.locadora.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "locadoradb", name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cli_nome", nullable = true, length = 128)
	private String nome;

	@Column(name = "cli_nome_empresa", nullable = true, length = 128)
	private String nomeEmpresa;

	@Column(name = "cli_endereco", nullable = true, length = 255)
	private String endereco;

	@Column(name = "cli_telefone", nullable = true, length = 32)
	private String telefone;

	@Column(name = "cli_email", nullable = true, length = 128)
	private String email;

	@Column(name = "cli_tipo_cliente", nullable = true, length = 1)
	private String tipoCliente; // criar um enum

	@Column(name = "cli_cnpj", nullable = true, unique = true, length = 14)
	private String CNPJ;

	@Column(name = "cli_cpf", nullable = true, unique = true, length = 11)
	private String CPF;

	@Column(name = "cli_dat_nascimento", nullable = true)
	private Date dataNacimento;

	@Column(name = "cli_sexo", nullable = true,  length = 1)
	private String sexo; // criar um enum

	@Column(name = "cli_idade", nullable = true)
	private Integer idade;

	@CreationTimestamp
	@Column(name = "dat_create")
	private Date dataCriacao;

	@UpdateTimestamp
	@Column(name = "dat_update")
	private Date dataUpate;

	@Version
	@Column(name = "nro_version")
	private Long versao;
}
