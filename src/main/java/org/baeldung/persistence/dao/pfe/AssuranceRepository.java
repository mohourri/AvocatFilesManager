package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Long> {

}
