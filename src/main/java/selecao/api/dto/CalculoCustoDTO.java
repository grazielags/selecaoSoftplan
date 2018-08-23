package selecao.api.dto;

import java.math.BigDecimal;

public class CalculoCustoDTO {
	
	private BigDecimal distanciaPavimentada;
	private BigDecimal distanciaNaoPavimentada;
	private VeiculoDTO veiculo;
	private BigDecimal carga;
	private BigDecimal custoTransporte;

	public BigDecimal getDistanciaPavimentada() {
		return distanciaPavimentada;
	}
	public void setDistanciaPavimentada(BigDecimal distanciaPavimentada) {
		this.distanciaPavimentada = distanciaPavimentada;
	}
	public BigDecimal getDistanciaNaoPavimentada() {
		return distanciaNaoPavimentada;
	}
	public void setDistanciaNaoPavimentada(BigDecimal distanciaNaoPavimentada) {
		this.distanciaNaoPavimentada = distanciaNaoPavimentada;
	}
	public VeiculoDTO getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}
	public BigDecimal getCarga() {
		return carga;
	}
	public void setCarga(BigDecimal carga) {
		this.carga = carga;
	}
	public BigDecimal getCustoTransporte() {
		return custoTransporte;
	}
	public void setCustoTransporte(BigDecimal custoTransporte) {
		this.custoTransporte = custoTransporte;
	}
	
}
