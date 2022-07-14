package br.com.javacode.locadora.dto;

import java.util.Date;

import br.com.javacode.locadora.enuns.EstadoVeiculoEnum;
import lombok.Data;

@Data
public class DevolucaoDTOV1 {

	private Long id;

	private Date dataHoraDevolucao;

	private Integer quilometragemDevolucao;

	private EstadoVeiculoEnum devEstadoVeiculo;

}
