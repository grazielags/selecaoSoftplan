package controleAtividades.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import controleAtividades.api.dto.AtividadeDTO;
import controleAtividades.api.mapper.AtividadeMapper;
import controleAtividades.entity.Atividade;
import controleAtividades.service.AtividadeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/atividades")
@Api(value="/v1/atividades", description="Api de atividade")
public class AtividadeAPI {
	
	@Autowired
    private AtividadeService atividadeService;
	@Autowired
    private AtividadeMapper atividadeMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AtividadeDTO>> getAll() {
    	return new ResponseEntity<List<AtividadeDTO>>(atividadeMapper.mapToDto(atividadeService.getAll()), HttpStatus.OK);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Atividade getById(@PathVariable Integer id) {
        return atividadeService.getById(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AtividadeDTO> saveEdit(@PathVariable Integer id, @RequestBody AtividadeDTO atividadeDTO) {
    	Atividade atividade = atividadeMapper.mapToEntity(atividadeDTO);
    	if (atividadeService.validaRegraFimDeSemanaOuSexta(atividade)) {
    		AtividadeDTO atividadeDTO2 = atividadeMapper.mapToDto(atividade);
    		atividadeDTO2.setError("Não pode ser inserida/alterada uma atividade do tipo manutenção urgente no fim de semana e na sexta-feira após às 13:00 horas.");
    		return new ResponseEntity<AtividadeDTO>(atividadeDTO2, HttpStatus.FAILED_DEPENDENCY);
    	}
    	if (atividadeService.validaAtividadeConcluidaETipoAtendimentoEDescricao(atividade)) {
    		AtividadeDTO atividadeDTO2 = atividadeMapper.mapToDto(atividade);
    		atividadeDTO2.setError("Não pode ser inserida/alterada uma atividade do tipo manutenção urgente ou atendimento com descrição inferior a 50 caracteres.");
    		return new ResponseEntity<AtividadeDTO>(atividadeDTO2, HttpStatus.LENGTH_REQUIRED);
    	}
    	atividade = atividadeService.save(atividade);
    	return new ResponseEntity<AtividadeDTO>(atividadeMapper.mapToDto(atividade), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AtividadeDTO> save(@RequestBody AtividadeDTO atividadeDTO) {
    	Atividade atividade = atividadeService.save(atividadeMapper.mapToEntity(atividadeDTO));
    	return new ResponseEntity<AtividadeDTO>(atividadeMapper.mapToDto(atividade), HttpStatus.CREATED);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id) {
        atividadeService.remove(id);
    }
}
