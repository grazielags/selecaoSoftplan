package controleAtividades.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "atividade", schema = "public")
public class Atividade {

	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_atividade", sequenceName = "seq_atividade")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade")
	@Column(name = "id")
	private Integer id;

	@Column
	private String titulo;

	@Column
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column
	private TipoAtividadeEnum tipo;

	@Column
	private Boolean concluida;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoAtividadeEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtividadeEnum tipo) {
		this.tipo = tipo;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

}
