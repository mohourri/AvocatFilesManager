package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.AvocatVictime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvocatVictimeRepository extends JpaRepository<AvocatVictime, Integer> {

}
