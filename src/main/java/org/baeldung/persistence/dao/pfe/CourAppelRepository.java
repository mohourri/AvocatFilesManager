package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.CourAppel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourAppelRepository extends JpaRepository<CourAppel, Long> {
	
}
