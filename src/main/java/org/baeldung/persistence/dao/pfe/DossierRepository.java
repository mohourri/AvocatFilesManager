package org.baeldung.persistence.dao.pfe;

import java.util.List;

import org.baeldung.persistence.model.pfe.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, String> {
	@Query("SELECT d FROM Dossier d WHERE DATEDIFF(d.dateSeance, SYSDATE()) BETWEEN 0 AND 6 ORDER BY d.dateSeance")
	public List<Dossier> getWeekSeances();
	
	@Query("SELECT d FROM Dossier d WHERE DATEDIFF(SYSDATE(), d.dateSeance) = 0 ORDER BY d.dateSeance")
	public List<Dossier> getDaySeances();
	
	public Dossier findFirstByOrderByNumeroDossierDesc();
	
	public Dossier findFirstByOrderByDateSeance();
}
