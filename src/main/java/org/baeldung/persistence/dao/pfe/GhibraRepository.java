package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.Ghibra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GhibraRepository extends JpaRepository<Ghibra, Integer> {

}
