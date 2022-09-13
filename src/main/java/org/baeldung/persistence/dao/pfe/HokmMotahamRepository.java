package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.HokmMotaham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HokmMotahamRepository extends JpaRepository<HokmMotaham, Integer> {

}
