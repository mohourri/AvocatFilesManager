package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.OfficierCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficierCivilRepository extends JpaRepository<OfficierCivil, String> {

}
