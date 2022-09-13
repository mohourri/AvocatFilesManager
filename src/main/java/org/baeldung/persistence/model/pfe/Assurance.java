package org.baeldung.persistence.model.pfe;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "assurance")
public class Assurance {
	@Id
	@Column(unique = true, nullable = false, name = "ID_Assurance")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAssurance;
	
	@Column(length = 200, name = "Nom_Assurance")
	private String nomAssurance;
	
	
	@OneToMany(mappedBy = "assurance", fetch = FetchType.LAZY)
	private Collection<Accuse> accuses;
	
	@OneToMany(mappedBy = "assurance", fetch = FetchType.LAZY)
	private Collection<OfficierCivil> officierCivils;
	
	public Long getIdAssurance() {
		return idAssurance;
	}
	public void setIdAssurance(Long idAssurance) {
		this.idAssurance = idAssurance;
	}
	public String getNomAssurance() {
		return nomAssurance;
	}
	public void setNomAssurance(String nomAssurance) {
		this.nomAssurance = nomAssurance;
	}
	public Assurance(Long idAssurance, String nomAssurance) {
		super();
		this.idAssurance = idAssurance;
		this.nomAssurance = nomAssurance;
	}
	public Assurance() {
		super();
	}
	
}
