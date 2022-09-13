package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.AvocatAccuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvocatAccuseRepository extends JpaRepository<AvocatAccuse, Integer> {

}
