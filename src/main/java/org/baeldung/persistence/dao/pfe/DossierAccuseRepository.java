package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.DossierAccuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierAccuseRepository extends JpaRepository<DossierAccuse, Integer> {
	public DossierAccuse findByIdAccuseAndNumeroDossier(Long idAccuse, String numeroDossier);
}
