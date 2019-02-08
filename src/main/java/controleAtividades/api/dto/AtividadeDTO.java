package controleAtividades.api.dto;

import controleAtividades.entity.TipoAtividadeEnum;

public class AtividadeDTO {

	private Integer id;
	private String titulo;
	private String descricao;
	private TipoAtividadeEnum tipo;
	private Boolean concluida;
	private String error;

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
