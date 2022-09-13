package org.baeldung.persistence.dao.pfe;
import java.util.List;

import org.baeldung.persistence.model.pfe.Accuse;
import org.baeldung.persistence.model.pfe.Avocat;
import org.baeldung.persistence.model.pfe.OfficierCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccuseRepository extends JpaRepository<Accuse, Long> {
	public Accuse getAccuseByIdAccuse(Long Id);
	public Accuse getAccuseByCin(String cin);
	
	@Query(value = "SELECT a FROM Accuse a WHERE (LOCATE(a.nom, ?1) > 0 AND LOCATE(a.prenom, ?1) > 0) OR (a.nom = ?1 OR a.prenom = ?1)")
	public List<Accuse> getAccusesByKeyword(String keyword);
	
	@Query(value = "SELECT a FROM Avocat a, AvocatAccuse aa WHERE a.cinAvocat = aa.cinAvocat AND aa.idAccuse = ?1")
	public List<Avocat> getAvocatByAccuse(Long idAccuse);
	
	@Query(value = "SELECT oc FROM Accuse ac, OfficierCivil oc WHERE ac.cniOfficierCivil = oc.cniOfficierCivil AND ac.idAccuse=?1")
	public OfficierCivil getOfficierCivil(Long idAccuse);
	
	public void deleteByIdAccuse(Long id);
	
	@Query(value = "SELECT a FROM Accuse a, DossierAccuse da WHERE a.idAccuse = da.idAccuse AND da.numeroDossier = ?1")
	public List<Accuse> getAccuseByNumeroDossier(String numeroDossier);

	@Query(value = "SELECT ass.nomAssurance FROM Accuse ac, Assurance ass WHERE ac.idAssurance = ass.idAssurance AND ac.idAccuse = ?1")
	public String getAccuseAssurance(Long idAccuse);
	
	@Query(value = "SELECT t.nomTohma FROM DossierAccuse da, Tohma t WHERE da.idTohma = t.idTohma AND da.idAccuse = ?1 AND da.numeroDossier = ?2")
	public String getAccuseTohma(Long idAccuse, String numeroDossier);
	
	@Query(value = "SELECT ass.nomAssurance FROM OfficierCivil oc, Assurance ass WHERE oc.idAssurance = ass.idAssurance AND oc.cniOfficierCivil = ?1")
	public String getOfficierCivilAssurance(String cniOfficierCivil);
	
}
