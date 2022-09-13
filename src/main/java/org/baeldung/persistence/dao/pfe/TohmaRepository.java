package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.Tohma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TohmaRepository extends JpaRepository<Tohma, Integer> {
	
}
