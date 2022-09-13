package org.baeldung.service.pfe;

import java.util.List;

import org.baeldung.persistence.dao.pfe.DossierRepository;
import org.baeldung.persistence.model.pfe.Dossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeancesService {
	@Autowired
	DossierRepository dossierRepository;
	
	public List<Dossier> getAllDossiers() {
		return dossierRepository.findAll();
	}
	
    public Dossier getDossierById(String id) {
		return dossierRepository.findById(id).get();
	}
    
    public void ajouterDossier(Dossier dossier) {
		dossierRepository.save(dossier);  
	}
    
    public List<Dossier> getWeekSeances(){
    	return dossierRepository.getWeekSeances();
    }
    
    public List<Dossier> getDaySeances(){
    	return dossierRepository.getDaySeances();
    }
    
    public Dossier getLastDossier() {
    	return dossierRepository.findFirstByOrderByNumeroDossierDesc();
    }
    
    public Dossier getNearestSeance() {
    	return dossierRepository.findFirstByOrderByDateSeance();
    }
}
