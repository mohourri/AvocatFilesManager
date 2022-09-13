package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Integer> {

}
