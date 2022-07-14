package br.com.javacode.locadora.dto;

import lombok.Data;

@Data
public class VeiculoDTOV1 {

	private Long id;

	private String placa;

	private String cor;

	private String anoFabricacao;

	private String modeloDescricao;

	private String marcaDescricao;

	private String combusivel;

	private Integer numPortas;

	private Integer quilometragem;

	private String renavam;

	private String chassi;

	private Long valorLocacao;

}
