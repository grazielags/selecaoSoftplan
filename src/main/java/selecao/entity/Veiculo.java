package selecao.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo", schema = "public")
public class Veiculo {

	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_veiculo", sequenceName = "seq_veiculo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_veiculo")
	@Column(name = "id")
	private Integer id;
	@Column
	private String modelo;
	@Column(name = "fator_multiplicador")
	private BigDecimal fatorMultiplicador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getFatorMultiplicador() {
		return fatorMultiplicador;
	}

	public void setFatorMultiplicador(BigDecimal fatorMultiplicador) {
		this.fatorMultiplicador = fatorMultiplicador;
	}

}
