package selecao.service;

import static java.util.Objects.isNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import selecao.entity.Veiculo;
import selecao.entity.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
    private VeiculoRepository veiculoRepository;
	
    public VeiculoService() {}

    public List<Veiculo> getAll() {
		List<Veiculo> veiculos = (List<Veiculo>) veiculoRepository.findAll();
        return veiculos;
    }

    public Veiculo getById(Integer id) {
    	Veiculo veiculo = veiculoRepository.findById(id);
        if(isNull(veiculo)) {
            throw new RuntimeException("Veículo não encontrado!");
        }
        return veiculo;
    }

    public Veiculo save(Veiculo veiculo) {
    	return veiculoRepository.save(veiculo);
    }
    
    public void remove(Integer id) {
    	veiculoRepository.delete(id);
    }
}
