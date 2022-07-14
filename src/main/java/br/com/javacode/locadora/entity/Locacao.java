package br.com.javacode.locadora.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(schema = "locadoradb", name = "locacoes")
public class Locacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "loc_data_hora_locacao")
	private Date dataHoraLocacao;

	@Column(name = "loc_data_hora_prevista")
	private Date dataHoraPrevista;

	@Column(name = "loc_quilometragem_locacao")
	private Integer quilomentragemLocacao;

	@Column(name = "loc_finalidade", length = 128)
	private String finalidade;

	@Column(name = "loc_local_trafegagem", length = 128)
	private String localTrafegagem;

	@Column(name = "loc_valor_locacao")
	private Float valorLocacao;

	@Column(name = "loc_valor_caucao")
	private Float valorCaucao;

	@Column(name = "loc_status_locacao", length = 1)
	private String statusLocacao;
	// Unidirectional
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loc_veiculo_id", referencedColumnName = "id")
	private Veiculo veiculo;
	// one to many unidirectional mapping
	// default fetch type for OneToMany: LAZY
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loc_cliente_id", referencedColumnName = "id")
	private Cliente cliente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loc_devolucao_id", referencedColumnName = "id")
	Devolucao devolucao;

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
