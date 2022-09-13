package org.baeldung.persistence.dao.pfe;

import java.util.List;

import org.baeldung.persistence.model.pfe.DroitsPersonneDecedee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DroitsPersonneDecedeeRepository extends JpaRepository<DroitsPersonneDecedee, Long> {
	
	@Query(value = "SELECT d FROM DroitsPersonneDecedee d, Indemnite i WHERE d.idDawi = i.idDawi AND i.idVictime = ?1")
	public List<DroitsPersonneDecedee> getDroitsPersonneDecedeeByVictime(Long idVictime);
	
	public DroitsPersonneDecedee getDroitsPersonneDecedeeByIdDawi(Long id);
	public DroitsPersonneDecedee getDroitsPersonneDecedeeByCin(String cin);
}
