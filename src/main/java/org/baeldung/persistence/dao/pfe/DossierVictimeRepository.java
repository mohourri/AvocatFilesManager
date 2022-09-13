package org.baeldung.persistence.dao.pfe;

import org.baeldung.persistence.model.pfe.DossierVictime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierVictimeRepository extends JpaRepository<DossierVictime, Integer> {
	
	//@Query("delete from DossierVictime where idVictime = ?1 and numeroDossier = ?2")
	//public void deleteByIdVictimeAndNumeroDossier(Long idVictime, String numeroDossier);
}
