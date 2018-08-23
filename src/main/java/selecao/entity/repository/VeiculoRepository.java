package selecao.entity.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import selecao.entity.Veiculo;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {
	public Veiculo findById(Integer id);

	public List<Veiculo> findAll(Sort sort);
}
