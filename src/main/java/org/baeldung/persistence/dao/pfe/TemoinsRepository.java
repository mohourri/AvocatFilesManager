package org.baeldung.persistence.dao.pfe;

import java.util.List;

import org.baeldung.persistence.model.pfe.Temoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TemoinsRepository extends JpaRepository<Temoin, String> {
	public Temoin getTemoinByCinTemoin(String cin);
	
	@Query(value = "SELECT t FROM Temoin t WHERE (LOCATE(t.nom, ?1) > 0 AND LOCATE(t.prenom, ?1) > 0) OR (t.nom = ?1 OR t.prenom = ?1)")
	public List<Temoin> getTemoinsByKeyword(String keyword);
	
	@Query(value = "DELETE FROM Temoin WHERE cinTemoin = ?1")
	public void deleteTemoinByCinTemoin(String cin);
	
	@Query(value = "SELECT tn FROM Temoin tn, Temoigner tg WHERE tn.cinTemoin = tg.cinTemoin AND tg.numeroDossier = ?1")
	public List<Temoin> getTemoinByNumeroDossier(String numeroDossier);
}
