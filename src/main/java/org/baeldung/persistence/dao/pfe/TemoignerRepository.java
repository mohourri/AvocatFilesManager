package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.Temoigner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemoignerRepository extends JpaRepository<Temoigner, Integer> {

}
