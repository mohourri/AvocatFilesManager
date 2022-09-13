package org.baeldung.persistence.dao.pfe;
import java.util.List;

import org.baeldung.persistence.model.pfe.Avocat;
import org.baeldung.persistence.model.pfe.Victime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VictimeRepository extends JpaRepository<Victime, Long> {
	public Victime getVictimeByIdVictime(Long Id);
	public Victime getVictimeByCin(String cin);
	
	@Query(value = "SELECT v FROM Victime v WHERE (LOCATE(v.nom, ?1) > 0 AND LOCATE(v.prenom, ?1) > 0) OR (v.nom = ?1 OR v.prenom = ?1)")
	public List<Victime> getVictimesByKeyword(String keyword);
	
	@Query(value = "SELECT a FROM Victime v, Avocat a WHERE v.cinAvocat = a.cinAvocat AND v.idVictime=?1")
	public Avocat getAvocat(Long idVictime);
	
	public void deleteByIdVictime(Long id);
	
	@Query(value = "SELECT v FROM Victime v, DossierVictime dv WHERE v.idVictime = dv.idVictime AND dv.numeroDossier = ?1")
	public List<Victime> getVictimeByNumeroDossier(String numeroDossier);
	
	@Query(value = "SELECT a FROM Avocat a, AvocatVictime av WHERE a.cinAvocat = av.cinAvocat AND av.idVictime = ?1")
	public List<Avocat> getAvocatByVictime(Long idVictime);
}
