package org.baeldung.persistence.dao.pfe;

import java.util.List;

import org.baeldung.persistence.model.pfe.Indemnite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IndemniteRepository extends JpaRepository<Indemnite, Integer> {
	public List<Indemnite>getIndemnitesByIdVictime(Long idVictime);
}
