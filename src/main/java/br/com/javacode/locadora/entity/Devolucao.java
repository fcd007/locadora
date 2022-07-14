package br.com.javacode.locadora.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.javacode.locadora.enuns.EstadoVeiculoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "locadoradb", name = "devolucoes")
public class Devolucao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "dev_data_hora_devolucao")
	private Date dataHoraDevolucao;

	@Column(name = "dev_quilometragem_devolucao")
	private Integer quilometragemDevolucao;

	@Enumerated(EnumType.STRING)
	private EstadoVeiculoEnum devEstadoVeiculo;
}
