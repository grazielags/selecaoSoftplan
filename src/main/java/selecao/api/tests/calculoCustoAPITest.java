package selecao.api.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import selecao.api.CalculoCustoAPI;
import selecao.api.dto.CalculoCustoDTO;
import selecao.api.dto.VeiculoDTO;

public class calculoCustoAPITest {

	private CalculoCustoAPI api;
	CalculoCustoDTO calculoCustoDto = null;
	
	@Before
	public void setUp() {
		api = new CalculoCustoAPI();
		calculoCustoDto = new CalculoCustoDTO();
		calculoCustoDto.setCarga(new BigDecimal(5.0));
		calculoCustoDto.setDistanciaNaoPavimentada(new BigDecimal(0.0));
		calculoCustoDto.setDistanciaPavimentada(new BigDecimal(100.0));
		VeiculoDTO veiculoDto = new VeiculoDTO();
		veiculoDto.setModelo("Caminhão caçamba");
		veiculoDto.setFatorMultiplicador(new BigDecimal(1.05));
		calculoCustoDto.setVeiculo(veiculoDto);
	}

	@Test
	public void calculaCustos100KmPavimentadosCaminhaoCacamba5Toneladas() {
		ResponseEntity<CalculoCustoDTO> resultado = this.api.calcularCustos(calculoCustoDto);	
		assertEquals(resultado.getBody().getCustoTransporte(), new BigDecimal(56.7).setScale(2, BigDecimal.ROUND_HALF_UP));
	}

	@Test
	public void calculaCustos60KmNaoPavimentadosCaminhaoBau4Toneladas() {
		calculoCustoDto.setDistanciaPavimentada(new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP));
		calculoCustoDto.setDistanciaNaoPavimentada(new BigDecimal(60.0).setScale(2, BigDecimal.ROUND_HALF_UP));
		VeiculoDTO veiculoDto = new VeiculoDTO();
		veiculoDto.setModelo("Caminhão baú");
		veiculoDto.setFatorMultiplicador(new BigDecimal(1.0));
		calculoCustoDto.setVeiculo(veiculoDto);
		ResponseEntity<CalculoCustoDTO> resultado = this.api.calcularCustos(calculoCustoDto);	
		assertTrue(resultado.getBody().getCustoTransporte().compareTo(new BigDecimal(37.2).setScale(2, BigDecimal.ROUND_HALF_UP)) == 0);
	}

	@Test
	public void calculaCustos180KmNaoPavimentadosCarreta12Toneladas() {
		calculoCustoDto.setDistanciaPavimentada(new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP));
		calculoCustoDto.setDistanciaNaoPavimentada(new BigDecimal(180.0).setScale(2, BigDecimal.ROUND_HALF_UP));
		calculoCustoDto.setCarga(new BigDecimal(12.0));
		VeiculoDTO veiculoDto = new VeiculoDTO();
		veiculoDto.setModelo("Carreta");
		veiculoDto.setFatorMultiplicador(new BigDecimal(1.12));
		calculoCustoDto.setVeiculo(veiculoDto);
		ResponseEntity<CalculoCustoDTO> resultado = this.api.calcularCustos(calculoCustoDto);
		assertTrue(resultado.getBody().getCustoTransporte().compareTo(new BigDecimal(150.19).setScale(2, BigDecimal.ROUND_HALF_UP)) == 0);
	}

	@Test
	public void calculaCustos80KmPavimentadosE20NaoPavimentadosCaminhaoBau6Toneladas() {
		calculoCustoDto.setDistanciaPavimentada(new BigDecimal(80.0).setScale(2, BigDecimal.ROUND_HALF_UP));
		calculoCustoDto.setDistanciaNaoPavimentada(new BigDecimal(20.0).setScale(2, BigDecimal.ROUND_HALF_UP));
		calculoCustoDto.setCarga(new BigDecimal(6.0));
		VeiculoDTO veiculoDto = new VeiculoDTO();
		veiculoDto.setModelo("Caminhão baú");
		veiculoDto.setFatorMultiplicador(new BigDecimal(1.0));
		calculoCustoDto.setVeiculo(veiculoDto);
		ResponseEntity<CalculoCustoDTO> resultado = this.api.calcularCustos(calculoCustoDto);
		assertTrue(resultado.getBody().getCustoTransporte().compareTo(new BigDecimal(57.6).setScale(2, BigDecimal.ROUND_HALF_UP)) == 0);
	}

	@Test
	public void calculaCustos50KmPavimentadosE30NaoPavimentadosCaminhaoCacamba5Toneladas() {
		calculoCustoDto.setDistanciaPavimentada(new BigDecimal(50.0).setScale(2, BigDecimal.ROUND_HALF_UP));
		calculoCustoDto.setDistanciaNaoPavimentada(new BigDecimal(30.0).setScale(2, BigDecimal.ROUND_HALF_UP));
		calculoCustoDto.setCarga(new BigDecimal(5.0));
		VeiculoDTO veiculoDto = new VeiculoDTO();
		veiculoDto.setModelo("Caminhão caçamba");
		veiculoDto.setFatorMultiplicador(new BigDecimal(1.05));
		calculoCustoDto.setVeiculo(veiculoDto);
		ResponseEntity<CalculoCustoDTO> resultado = this.api.calcularCustos(calculoCustoDto);
		assertTrue(resultado.getBody().getCustoTransporte().compareTo(new BigDecimal(47.88).setScale(2, BigDecimal.ROUND_HALF_UP)) == 0);
	}
}
