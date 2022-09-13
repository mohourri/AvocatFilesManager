package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.Barreau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarreauRepository extends JpaRepository<Barreau, Long> {
	
}
