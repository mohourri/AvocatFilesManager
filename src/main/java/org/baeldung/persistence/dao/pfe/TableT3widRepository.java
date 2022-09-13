package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.TableT3wid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TableT3widRepository extends JpaRepository<TableT3wid, Integer> {

}
