package controleAtividades.entity.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import controleAtividades.entity.Atividade;

@Repository
public interface AtividadeRepository extends CrudRepository<Atividade, Integer> {
	public Atividade findById(Integer id);

	public List<Atividade> findAll(Sort sort);
}
