package selecao;

import java.math.BigDecimal;

public enum TipoViaEnum {

	PAVIMENTADA(new BigDecimal(0.54)),
	NAO_PAVIMENTADA(new BigDecimal(0.62));
	 
    private final BigDecimal custoKmRodado;

    TipoViaEnum(BigDecimal custokmRodado) {
    	this.custoKmRodado = custokmRodado;
    }
    
	public BigDecimal getCustoKmRodado() {
		return custoKmRodado;
	}
}
