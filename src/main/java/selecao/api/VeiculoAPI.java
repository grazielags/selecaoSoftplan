package selecao.api;

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

import selecao.api.dto.VeiculoDTO;
import selecao.api.mapper.VeiculoMapper;
import selecao.entity.Veiculo;
import selecao.service.VeiculoService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/v1/veiculos")
@Api(value="/v1/veiculos", description="Api de veiculo")
public class VeiculoAPI {
	
	@Autowired
    private VeiculoService veiculoService;
	@Autowired
    private VeiculoMapper veiculoMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VeiculoDTO>> getAll() {
    	return new ResponseEntity<List<VeiculoDTO>>(veiculoMapper.mapToDto(veiculoService.getAll()), HttpStatus.OK);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Veiculo getById(@PathVariable Integer id) {
        return veiculoService.getById(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<VeiculoDTO> saveEdit(@PathVariable Integer id, @RequestBody VeiculoDTO veiculoDTO) {
    	Veiculo veiculo = veiculoService.save(veiculoMapper.mapToEntity(veiculoDTO));
    	return new ResponseEntity<VeiculoDTO>(veiculoMapper.mapToDto(veiculo), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<VeiculoDTO> save(@RequestBody VeiculoDTO veiculoDTO) {
    	Veiculo veiculo = veiculoService.save(veiculoMapper.mapToEntity(veiculoDTO));
    	return new ResponseEntity<VeiculoDTO>(veiculoMapper.mapToDto(veiculo), HttpStatus.CREATED);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Integer id) {
        veiculoService.remove(id);
    }

}
