package selecao.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import selecao.api.dto.VeiculoDTO;
import selecao.entity.Veiculo;
import selecao.service.VeiculoService;

@Component
public class VeiculoMapper {

	@Autowired
	private VeiculoService veiculoService;

	public VeiculoDTO mapToDto(Veiculo veiculo) {
		VeiculoDTO veiculoDTO = new VeiculoDTO();
		veiculoDTO.setId(veiculo.getId());
		veiculoDTO.setModelo(veiculo.getModelo());
		veiculoDTO.setFatorMultiplicador(veiculo.getFatorMultiplicador());
		return veiculoDTO;
	}

	public List<VeiculoDTO> mapToDto(List<Veiculo> entities) {
		List<VeiculoDTO> dtos = new ArrayList<VeiculoDTO>();
		for (Veiculo entity : entities) {
			if (entity != null) {
				dtos.add(this.mapToDto(entity));
			}
		}
		return dtos;
	}

	public Veiculo mapToEntity(VeiculoDTO veiculoDTO) {
		if (veiculoDTO != null) {
			Veiculo veiculo = new Veiculo();
			if (veiculoDTO.getId() != null) {
				veiculo = this.veiculoService.getById(veiculoDTO.getId());
				if (veiculo == null) {
					veiculo = new Veiculo();
				}
			}
			veiculo.setModelo(veiculoDTO.getModelo());
			veiculo.setFatorMultiplicador(veiculoDTO.getFatorMultiplicador());
			return veiculo;
		}
		return null;
	}
}
