package controleAtividades.api.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleAtividades.api.dto.AtividadeDTO;
import controleAtividades.entity.Atividade;
import controleAtividades.service.AtividadeService;

@Component
public class AtividadeMapper {

	@Autowired
	private AtividadeService atividadeService;

	public AtividadeDTO mapToDto(Atividade atividade) {
		AtividadeDTO atividadeDTO = new AtividadeDTO();
		atividadeDTO.setId(atividade.getId());
		atividadeDTO.setDescricao(atividade.getDescricao());
		atividadeDTO.setTitulo(atividade.getTitulo());
		atividadeDTO.setTipo(atividade.getTipo());
		atividadeDTO.setConcluida(atividade.getConcluida());
		return atividadeDTO;
	}

	public List<AtividadeDTO> mapToDto(List<Atividade> entities) {
		List<AtividadeDTO> dtos = new ArrayList<AtividadeDTO>();
		for (Atividade entity : entities) {
			if (entity != null) {
				dtos.add(this.mapToDto(entity));
			}
		}
		return dtos;
	}

	public Atividade mapToEntity(AtividadeDTO atividadeDTO) {
		if (atividadeDTO != null) {
			Atividade atividade = new Atividade();
			if (atividadeDTO.getId() != null) {
				atividade = this.atividadeService.getById(atividadeDTO.getId());
				if (atividade == null) {
					atividade = new Atividade();
				}
			}
			atividade.setDescricao(atividadeDTO.getDescricao());
			atividade.setTitulo(atividadeDTO.getTitulo());
			atividade.setTipo(atividadeDTO.getTipo());
			atividade.setConcluida(atividadeDTO.getConcluida());
			return atividade;
		}
		return null;
	}
}
