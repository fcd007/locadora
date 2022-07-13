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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "locadoradb", name = "veiculos")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vei_placa", nullable = true,  length = 32)
	private String placa;

	@Column(name = "vei_cor", nullable = true,  length = 32)
	private String cor;

	@Column(name = "vei_ano_fabricacao", nullable = true,  length = 10)
	private String anoFabricacao;

	@Column(name = "vei_modelo", nullable = true,  length = 64)
	private String modeloDescricao;

	@Column(name = "vei_marca", nullable = true,  length = 64)
	private String marcaDescricao;

	@Column(name = "vei_combustivel", nullable = true,  length = 64)
	private String combusivel;

	@Column(name = "vei_num_portas")
	private Integer numPortas;

	@Column(name = "vei_quilometragem", nullable = true,  length = 64)
	private String quilometragem;

	@Column(name = "vei_renavam", nullable = true,  length = 64)
	private String renavam;

	@Column(name = "vei_chassi", nullable = true,  length = 64)
	private String chassi;

	@Column(name = "vei_valor_locacao")
	private Long valorLocacao;
	
	@CreationTimestamp
	@Column(name = "dat_create")
	private Date dataCriacao;

	@Column(name = "dat_update")
	private Date dataUpate;

	@Version
	@Column(name = "nro_version")
	private Long versao;
}
