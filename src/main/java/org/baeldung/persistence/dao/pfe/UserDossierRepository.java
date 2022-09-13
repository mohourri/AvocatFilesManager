package org.baeldung.persistence.dao.pfe;

import java.util.List;

import org.baeldung.persistence.model.pfe.Dossier;
import org.baeldung.persistence.model.pfe.UserDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDossierRepository extends JpaRepository<UserDossier, Long>{
	@Query(value = "SELECT d FROM Dossier d, UserDossier ud WHERE d.numeroDossier = ud.numeroDossier AND ud.idUser = ?1")
	public List<Dossier> getDossierByIdUser(Long idUser);
}
