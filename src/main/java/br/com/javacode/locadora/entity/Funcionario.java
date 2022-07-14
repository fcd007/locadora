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

	@Column(name = "fun_first_name", nullable = true, length = 128)
	private String firstName;

	@Column(name = "fun_last_name", nullable = true, length = 128)
	private String lastName;

	@Column(name = "fun_email_id", nullable = true, length = 64)
	private String emailId;

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
