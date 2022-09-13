package org.baeldung.persistence.model.pfe;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "officier_civil")
public class OfficierCivil {
	@Id
	@Column(unique = true, nullable = false, length = 60, name = "CNI_OFFICIER_CIVIL")
	private String cniOfficierCivil;
	
	@Column(length = 40, name = "PRENOM_OFFICIER_CIVIL")
	private String prenom;
	
	@Column(length = 40, name = "NOM_OFFICIER_CIVIL")
	private String nom;
	
	@Column(length = 150, name = "ADRESSE_OFFICIER_CIVIL")
	private String addresse;
	
	@Column(name = "Assurance")
	private Long idAssurance;
	
	
	@OneToMany(mappedBy = "officierCivil", fetch = FetchType.LAZY)
	private Collection<Accuse> accuses;
	
	@ManyToOne
	@JoinColumn(name = "Assurance",referencedColumnName="ID_Assurance", insertable=false, updatable=false)
	private Assurance assurance;
	
	
	public String getCniOfficierCivil() {
		return cniOfficierCivil;
	}
	public void setCniOfficierCivil(String cniOfficierCivil) {
		this.cniOfficierCivil = cniOfficierCivil;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public Long getAssurance() {
		return idAssurance;
	}
	public void setAssurance(Long assurance) {
		this.idAssurance = assurance;
	}
	
	
}
