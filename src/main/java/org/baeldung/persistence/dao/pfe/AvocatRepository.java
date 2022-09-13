package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.Avocat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvocatRepository extends JpaRepository<Avocat, String> {

}
