package controleAtividades.service;

import static java.util.Objects.isNull;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleAtividades.entity.Atividade;
import controleAtividades.entity.TipoAtividadeEnum;
import controleAtividades.entity.repository.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
    private AtividadeRepository atividadeRepository;
	
    public AtividadeService() {}

    public List<Atividade> getAll() {
		List<Atividade> atividades = (List<Atividade>) atividadeRepository.findAll();
        return atividades;
    }

    public Atividade getById(Integer id) {
    	Atividade atividade = atividadeRepository.findById(id);
        if(isNull(atividade)) {
            throw new RuntimeException("Atividade não encontrada!");
        }
        return atividade;
    }

    public Atividade save(Atividade atividade) {
    	return atividadeRepository.save(atividade);
    }

    /**
     * Método responsável por verificar a regra de negócio de não permitir incluir/alterar atividades do tipo manutenção urgente
     * no fim de semana ou sexta-feira após às 13:00 horas.
     * 
     * @param atividade
     * @return true caso seja fim de semana, ou após às 13:00 de sexta-feira.
     */
    public boolean validaRegraFimDeSemanaOuSexta(Atividade atividade) {
		LocalDateTime now = LocalDateTime.now();
    	DayOfWeek day = now.getDayOfWeek();
        boolean isWeekend = day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    	return TipoAtividadeEnum.MANUTENCAO_URGENTE.equals(atividade.getTipo())
    			&& (isWeekend || 
    			(day == DayOfWeek.FRIDAY && now.getHour() > 13));
	}

	/**
	 * Método responsável por verificar a regra de negócio de não permitir incluir/alterar atividades concluídas do tipo atendimento
	 * ou manutenção urgente, cuja descrição tenha menos que 50 caracteres.
	 * 
	 * @param atividade
	 * @return true caso o tipo da atividade seja de atendimento ou manutenção urgente e a descrição tenha menos que 50 caracteres.
	 */
	public boolean validaAtividadeConcluidaETipoAtendimentoEDescricao(Atividade atividade) {
		return atividade.getConcluida()
				&& (TipoAtividadeEnum.ATENDIMENTO.equals(atividade.getTipo())
    			|| TipoAtividadeEnum.MANUTENCAO_URGENTE.equals(atividade.getTipo()))
    			&& atividade.getDescricao().length() < 50;
	}
    
    public void remove(Integer id) {
    	atividadeRepository.delete(id);
    }
}
