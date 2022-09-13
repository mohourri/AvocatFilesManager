package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.PremiereInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PremiereInstanceRepository extends JpaRepository<PremiereInstance, Long> {

}
