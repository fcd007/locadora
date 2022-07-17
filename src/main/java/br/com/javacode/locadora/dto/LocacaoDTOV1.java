package br.com.javacode.locadora.dto;

import java.util.Date;

import br.com.javacode.locadora.entity.Cliente;
import br.com.javacode.locadora.entity.Devolucao;
import br.com.javacode.locadora.entity.Veiculo;
import lombok.Data;

@Data
public class LocacaoDTOV1 {

	private Long id;

	private Date dataHoraLocacao;

	private Date dataHoraPrevista;

	private Integer quilomentragemLocacao;

	private String finalidade;

	private String localTrafegagem;

	private Float valorLocacao;

	private Float valorCaucao;

	private String statusLocacao;

	private Veiculo veiculo;

	private Cliente cliente;

	private Devolucao devolucao;

}
