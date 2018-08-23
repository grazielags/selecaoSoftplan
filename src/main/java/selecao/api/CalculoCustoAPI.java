package selecao.api;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import selecao.TipoViaEnum;
import selecao.api.dto.CalculoCustoDTO;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/calculoCusto")
@Api(value="/v1/calculoCusto", description="Api de cálculo de custos")
public class CalculoCustoAPI {
	
	private final BigDecimal QTD_MAXIMA_DE_TONELADAS = new BigDecimal(5.0);
	private final BigDecimal VALOR_KM_EXCESSO_CARGA = new BigDecimal(0.02);
	
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CalculoCustoDTO> calcularCustos(@RequestBody CalculoCustoDTO calculoCustoDTO) {
    	BigDecimal custoTotal = new BigDecimal(0d);
    	custoTotal = TipoViaEnum.NAO_PAVIMENTADA.getCustoKmRodado().multiply(calculoCustoDTO.getDistanciaNaoPavimentada());
    	custoTotal = custoTotal.add(TipoViaEnum.PAVIMENTADA.getCustoKmRodado().multiply(calculoCustoDTO.getDistanciaPavimentada()));
    	custoTotal = custoTotal.multiply(calculoCustoDTO.getVeiculo().getFatorMultiplicador());
    	BigDecimal diferencaCarga = calculoCustoDTO.getCarga().subtract(QTD_MAXIMA_DE_TONELADAS);
    	if (diferencaCarga.compareTo(new BigDecimal(0.0)) == 1) {
    		BigDecimal valorExcessoCargaPorKm = diferencaCarga.multiply(VALOR_KM_EXCESSO_CARGA);
    		BigDecimal totalKmsPercorridos = calculoCustoDTO.getDistanciaNaoPavimentada().add(calculoCustoDTO.getDistanciaPavimentada());
    		BigDecimal valorTotalExcessoCarga = valorExcessoCargaPorKm.multiply(totalKmsPercorridos);
    		custoTotal = custoTotal.add(valorTotalExcessoCarga);
    	}
    	calculoCustoDTO.setCustoTransporte(custoTotal.setScale(2, BigDecimal.ROUND_HALF_UP));
    	return new ResponseEntity<CalculoCustoDTO>(calculoCustoDTO, HttpStatus.OK);
    }

}
