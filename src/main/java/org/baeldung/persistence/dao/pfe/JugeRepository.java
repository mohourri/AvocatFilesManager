package org.baeldung.persistence.dao.pfe;

import java.util.List;

import org.baeldung.persistence.model.pfe.Juge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugeRepository extends JpaRepository<Juge, String> {
	public List<Juge> findByIdTribunalAndTypeTribunal(Long idTribunal, Long typeTribunal);
}
