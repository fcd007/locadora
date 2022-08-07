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
@Table(schema = "locadoradb", name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "fun_nome", nullable = true, length = 128)
	private String nome;

	@Column(name = "fun_sobrenome", nullable = true, length = 128)
	private String sobrenome;

	@Column(name = "fun_email", nullable = true, length = 64)
	private String email;

	@CreationTimestamp
	@Column(name = "dat_criacao")
	private Date dataCriacao;

	@UpdateTimestamp
	@Column(name = "dat_atualizacao")
	private Date dataUpate;

	@Version
	@Column(name = "nro_versao")
	private Long versao;
}
